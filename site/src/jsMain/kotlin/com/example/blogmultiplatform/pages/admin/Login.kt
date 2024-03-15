package com.example.blogmultiplatform.pages.admin

import androidx.compose.runtime.*
import com.example.blogmultiplatform.models.User
import com.example.blogmultiplatform.models.UserWithoutPassword
import com.example.blogmultiplatform.util.Id
import com.example.blogmultiplatform.util.Res
import com.example.blogmultiplatform.util.userExists
import com.models.Theme
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Input
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.set

@Page
@Composable
fun LoginScreen() {

    val scope = rememberCoroutineScope()
    val context = rememberPageContext()
    var errorText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize().backgroundColor(Theme.Outline.rgb),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(topBottom = 24.px, leftRight = 50.px),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(100.px)
                    .margin(bottom = 30.px)
                    .borderRadius(5.px),
                src = Res.Image.LOGO,
                description = "Logo Image"
            )
            Input(
                type = InputType.Email,
                attrs = Modifier
                    .id(Id.USERNAME_INPUT)
                    .width(350.px)
                    .height(54.px)
                    .padding(leftRight = 20.px)
                    .margin(bottom = 12.px)
                    .backgroundColor(Colors.White)
                    .border(width = 0.px, style = LineStyle.None, color = Colors.Transparent)
                    .borderRadius(10.px)
                    .toAttrs {
                        attr(attr = "placeholder", value = "Username")
                    }
            )
            Input(
                type = InputType.Password,
                attrs = Modifier
                    .id(Id.PASSWORD_INPUT)
                    .width(350.px)
                    .height(54.px)
                    .padding(leftRight = 20.px)
                    .margin(bottom = 20.px)
                    .backgroundColor(Colors.White)
                    .border(width = 0.px, style = LineStyle.None, color = Colors.Transparent)
                    .borderRadius(10.px)
                    .toAttrs {
                        attr(attr = "placeholder", value = "Password")
                    }
            )
            Button(
                attrs = Modifier
                    .width(100.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Colors.White)
                    .borderRadius(20.px)
                    .fontSize(FontSize.Medium)
                    .border(width = 2.px, style = LineStyle.None, color = Colors.White)
                    .padding(10.px)
                    .onClick {
                        scope.launch {
                            val username = (document.getElementById(Id.USERNAME_INPUT) as HTMLInputElement).value
                            val password = (document.getElementById(Id.PASSWORD_INPUT) as HTMLInputElement).value
                            if (username.isNotEmpty() && password.isNotEmpty()) {
                                val user = userExists(
                                    User(username, password)
                                )
                                if (user != null) {
                                    rememberLoggedIn(remember = true, user = user)
                                    context.router.navigateTo("admin/home")
                                } else {
                                    errorText = "User not registered"
                                    delay(3_000)
                                    errorText = ""
                                }
                            } else {
                                errorText = "Input fields are empty"
                                delay(3_000)
                                errorText = ""
                            }
                        }
                    }
                    .toAttrs()
            ) {
                SpanText(
                    text = "Sign in",
                    modifier = Modifier
                )
            }
            SpanText(
                text = errorText,
                modifier = Modifier
                    .color(Colors.Red)
                    .textAlign(TextAlign.Center)
            )
        }
    }
}

private fun rememberLoggedIn(remember: Boolean, user: UserWithoutPassword? = null) {
    localStorage["remember"] = remember.toString()
    if (user != null) {
        localStorage["userId"] = user.id
        localStorage["username"] = user.username
    }
}