package com.example.blogmultiplatform.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.rgba

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue
) {
    Primary(
        hex = "#00696b",
        rgb = rgb(r = 0, g = 105, b = 107)
    ),
    Secondary(
        hex = "#001019",
        rgb(r = 0, g = 16, b = 25)
    ),
    Outline(
        hex = "#dae4e4",
        rgb = rgb(r = 218, g = 228, b = 228)
    ),
    HalfWhite(
        hex = "#FFFFFF",
        rgb = rgba(r = 255, g = 255, b = 255, a = 0.5)
    )
}