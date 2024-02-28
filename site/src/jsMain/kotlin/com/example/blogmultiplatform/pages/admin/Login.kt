package com.example.blogmultiplatform.pages.admin

import androidx.compose.runtime.Composable
import com.example.blogmultiplatform.util.Res
import com.models.Theme
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
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Input

@Page
@Composable
fun LoginScreen() {

    Box(
        modifier = Modifier.fillMaxSize().backgroundColor(Theme.Outline.rgb),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(leftRight = 50.px, bottom = 24.px),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.width(100.px).margin(bottom = 50.px),
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
                    .backgroundColor(Colors.White)
                    .toAttrs {
                        attr(attr = "placeholder", value = "Password")
                    }
            )
        }
    }
}