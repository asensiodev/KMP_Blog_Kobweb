package com.example.blogmultiplatform.data

import com.example.blogmultiplatform.models.User

interface MongoRepository {
    suspend fun userExists(user: User): User?
}