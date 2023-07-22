package dev.proptit.activityoverview.section.password

import dev.proptit.activityoverview.section.account.Account

object PasswordManager {
    private val accounts = mutableListOf<Account>()

    init {
        accounts.add(Account("Admin", "admin", "admin"))
    }

    fun addAccount(account: Account) {
        accounts.add(account)
    }

    fun checkAccount(email: String, password: String): Boolean {
        for (account in accounts) {
            if (account.email == email && account.password == password) {
                return true
            }
        }
        return false
    }

    fun checkDuplicateEmail(email: String): Boolean {
        for (account in accounts) {
            if (account.email == email) {
                return true
            }
        }
        return false
    }

    fun checkValidEmail(email: String): Boolean {
        return email.contains("@")
    }

    fun checkValidPassword(password: String): Boolean {
        return password.length >= 6
    }
}

