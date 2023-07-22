package dev.proptit.activityoverview

import android.util.Patterns

object AccountManager {

    private val accountList = mutableListOf<Account>()


    private fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
    fun addAccount(account: Account){
        accountList.add(account)
    }

    fun checkLogin(email: String?, password: String?) : Boolean{
        if(email.isValidEmail() && !password.isNullOrEmpty()) return true
        return false
    }

    fun checkRegister(fullName : String, email : String, password: String) : Boolean{
        if(!fullName.isNullOrEmpty() && email.isValidEmail() && !password.isNullOrEmpty()) return true
        return false
    }
}
data class Account(val fullName : String, val email : String, val password : String)