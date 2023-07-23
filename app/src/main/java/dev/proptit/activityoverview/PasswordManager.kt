package dev.proptit.activityoverview

import android.util.Log

object PasswordManager {
    private val users = mutableListOf<User>()

    fun isValidEmail(email: String): Boolean {
        return email.contains("@")
    }

    fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }

    fun isDuplicateEmail(email: String): Boolean {
        Log.d("User", users.isNotEmpty().toString())
        Log.d("User", users.any { it.email == email }.toString())
        return users.isEmpty() || users.any { it.email == email }
    }

    fun addUser(user: User) {
        users.add(user)
    }

    fun isCorrectUser(email: String, password: String): Boolean {
        return users.any { it.email == email && it.password == password }
    }
}