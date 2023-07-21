package dev.proptit.activityoverview

object AccountManager {

    private val accounts = mutableListOf<Account>()


    fun addAccount(account: Account){
        accounts.add(account)
    }

    fun checkLogin(email: String, password: String){

    }
}
data class Account(val fullName : String, val email : String, val password : String)