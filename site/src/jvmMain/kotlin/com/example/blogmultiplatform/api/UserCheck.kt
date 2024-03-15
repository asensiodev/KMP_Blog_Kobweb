import com.example.blogmultiplatform.data.MongoDB
import com.example.blogmultiplatform.models.User
import com.example.blogmultiplatform.models.UserWithoutPassword
import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.data.getValue
import com.varabyte.kobweb.api.http.setBodyText
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Api(routeOverride = "userexists")
suspend fun userExists(context: ApiContext) {
    try {
        val userRequest: User? =
            context.req.body?.decodeToString()?.let { Json.decodeFromString<User>(it) }
        val user = userRequest?.let {
            context.data.getValue<MongoDB>().userExists(
                User(username = it.username, password = it.password)
            )
        }
        if (user != null) {
            context.res.setBodyText(
                Json.encodeToString<UserWithoutPassword>(
                    UserWithoutPassword(id = user.id, username = user.username)
                )
            )
        } else {
            context.res.setBodyText(Json.encodeToString(Exception("User doesn't exist.")))
        }
    } catch (e: Exception) {
        context.res.setBodyText(Json.encodeToString(Exception("Something went wrong: ${e.message}")))
    }
}