package dev.proptit.activityoverview

object User {
    private val dataUsers : HashMap<String, String> = HashMap()
    private fun findUser(email: String): Boolean{
        return dataUsers.containsKey(email)
    }
    fun addUser(email: String, password: String): Boolean {
        return if(!findUser(email)){
            dataUsers[email] = password
            true
        } else{
            false
        }
    }

    fun checkUser(email: String, password: String): Boolean{
        return if(findUser(email)){
            dataUsers[email].equals(password)
        } else{
            false
        }
    }
}