package com.example.blogmultiplatform.components

import androidx.compose.runtime.Composable
import com.example.blogmultiplatform.util.Res
import com.example.blogmultiplatform.models.Theme
import com.example.blogmultiplatform.util.Constants.ROBOTO
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

@Composable
fun SidePanel() {
    Column(
        modifier = Modifier
            .padding(leftRight = 40.px, topBottom = 50.px)
            .height(100.vh)
            .width(250.px)
            .position(Position.Fixed)
            .backgroundColor(Theme.Secondary.rgb)
            .zIndex(9)
    ) {
        Image(
            modifier = Modifier.margin(bottom = 60.px),
            src = Res.Image.LOGO,
            alt = "Logo"
        )
        SpanText(
            modifier = Modifier
                .margin(30.px)
                .fontSize(14.px)
                .color(Theme.HalfWhite.rgb),
            text = "Dashboard"
        )
        NavigationItem(
            title = "Home",
            iconPath = Res.PathIcon.home,
            onClick = {}
        )
        NavigationItem(
            title = "Create",
            iconPath = Res.PathIcon.home,
            onClick = {}
        )
        NavigationItem(
            title = "Posts",
            iconPath = Res.PathIcon.home,
            onClick = {}
        )
        NavigationItem(
            title = "Logout",
            iconPath = Res.PathIcon.home,
            onClick = {}
        )
    }
}

@Composable
fun NavigationItem(
    modifier: Modifier = Modifier,
    selected: Boolean = false, // TODO: Change icon and text color upon this
    title: String,
    iconPath: String,
    onClick: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .cursor(Cursor.Pointer)
            .onClick { onClick() }
    ) {
        SidePanelIcon(iconPath)
        SpanText(
            text = title,
            modifier = Modifier.color(Color.white)
        )
    }
}

@Composable
fun SidePanelIcon(iconPath: String) {
    Image(
        modifier = Modifier
            .size(24.px)
            //.width(30.px)
            .margin(right = 5.px, bottom = 10.px)
            .borderRadius(5.px),
        src = iconPath
    )
}