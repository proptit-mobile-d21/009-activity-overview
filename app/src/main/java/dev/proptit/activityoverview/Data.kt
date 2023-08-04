package dev.proptit.activityoverview

import android.util.Patterns

data class Account(
    val fullName: String,
    val email: String,
    val password: String
)

object Data {
    private val accountList = mutableListOf(
        Account("Hoang Quoc Anh", "quocanh20102003@gmail.com", "20102003")
    )

    fun addAccount(account: Account) {
        accountList.add(account)
    }

    fun findAccount(account: Account): Boolean {
        return accountList.any { account.email == it.email && account.password == it.password }
    }
}

fun isValidEmail(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}