package dev.proptit.activityoverview.section

class Password {
    private val listAccounts = mutableListOf<Account>()
    fun addAccount(account: Account){
        listAccounts.add(account)
        listAccounts.forEach(){ println(it) }
    }
    fun checkValidEmail(email:String):Boolean{
        return email.contains("@")
    }
    fun checkValidPassword(password: String):Boolean{
        return password.length >= 8
    }
    fun checkDuplicateEmail(email: String):Boolean{
        listAccounts.forEach(){
            if(it.email == email) return true
        }
        return false
    }
}