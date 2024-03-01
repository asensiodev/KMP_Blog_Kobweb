package com.example.blogmultiplatform.pages.admin

import androidx.compose.runtime.*
import com.example.blogmultiplatform.util.Res
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
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Input

@Page
@Composable
fun LoginScreen() {

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