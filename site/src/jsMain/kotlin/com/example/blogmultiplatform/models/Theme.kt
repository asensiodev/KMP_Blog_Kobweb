package com.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue
) {
    Primary(
        hex = "#00696b",
        rgb = rgb(r = 0, g = 105, b = 107)
    ),
    Outline(
        hex = "#dae4e4",
        rgb = rgb(r = 218, g = 228, b = 228)
    )
}