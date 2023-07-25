package dev.proptit.activityoverview

object Manager {
    private val accounts = mutableListOf<Account>()

    fun addNewAccount(account: Account){
        accounts.add(account)
    }

    fun checkValidateEmailAddress(email:String):Boolean{
        return email.contains("@")
    }

    fun checkValidatePassword(password:String):Boolean{
        return password.length>=6
    }

    fun checkCorrectAccount(email: String, password: String):Boolean{
        for(account in accounts)
        {
            if(account.email==email && account.password==password)
            {
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
}