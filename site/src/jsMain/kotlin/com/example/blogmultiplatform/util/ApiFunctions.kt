package com.example.blogmultiplatform.util

import com.example.blogmultiplatform.models.User
import com.example.blogmultiplatform.models.UserWithoutPassword
import com.varabyte.kobweb.browser.api
import kotlinx.browser.window
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

suspend fun userExists(user: User): UserWithoutPassword? {
    return try {
        val result = window.api.tryPost(
            apiPath = "userexists",
            body = Json.encodeToString(user).encodeToByteArray()
        )
        Json.decodeFromString<UserWithoutPassword>(result.toString())
    } catch (e: Exception) {
        println("Error checking user existance ${e.message}")
        null
    }
}