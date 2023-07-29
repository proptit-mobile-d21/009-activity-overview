package dev.proptit.activityoverview

object AccountManager {
    private val accountList = mutableListOf<Account>()

    init {
        accountList.add(Account("Admin", "admin", "admin"))
    }

    fun addAccount(acc: Account) {
        accountList.add(acc)
    }

    fun checkAccount(email: String, password: String): Boolean {
        for (acc in accountList) {
            if (acc.email == email && acc.password == password)
                return true
        }
        return false
    }

    fun checkExistMail(mail: String): Boolean {
        for (acc in accountList) {
            if (acc.email == mail)
                return true
        }
        return false
    }

    fun checkValidMail(mail: String): Boolean {
        return mail.contains("@")
    }

    fun checkValidPassword(password: String): Boolean {
        return password.length >= 6
    }

}