package dev.proptit.activityoverview.section.manager

import dev.proptit.activityoverview.section.account.Account
import java.lang.Exception
import java.util.regex.Pattern

class AccountManager {

    class IncorrectEmailOrPassword : Exception()
    class EmailIsAlreadyRegistered : Exception()

    private val EMAIL_PATTERN = Pattern.compile("\\S+\\@\\w+\\.\\w+")

    fun validateEmail(email: String) : Boolean = EMAIL_PATTERN.matcher(email).matches()

    fun validatePassword(password: String) : Boolean = password.length > 6

    fun register(name: String, email: String, password: String) {
        Database.accounts.forEach { if (it.email == email) throw EmailIsAlreadyRegistered() }
        Database.accounts.add(Account(name, email, password))
    }

    fun login(email: String, password: String) : Account {
        Database.accounts.forEach {
            if (it.email == email && it.password == password)
                return it
        }
        throw IncorrectEmailOrPassword()
    }
}