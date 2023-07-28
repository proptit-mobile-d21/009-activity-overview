package dev.proptit.activityoverview.section.password

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import dev.proptit.activityoverview.section.account.Account

object PasswordManager {
    private val accountList = mutableListOf<Account>()

    init {
        accountList.add(Account("Admin","admin", "admin"))
    }

    fun addAccount(account: Account){
        accountList.add(account)
    }

    fun checkAccount(mail: String, pass: String): Boolean {
        for (account in accountList) {
            if (account.mail == mail && account.pass == pass) {
                return true
            }
        }
        return false
    }

    fun checkValidMail(mail: String): Boolean {
        return mail.contains("@")
    }

    fun checkValidPass(pass: String): Boolean {
        return pass.length >= 6
    }
}