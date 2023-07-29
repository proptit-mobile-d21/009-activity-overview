package dev.proptit.activityoverview

import android.util.Patterns
import javax.security.auth.Subject

object MailManager {
    private val mailList = mutableListOf<Mail>()

    private fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
    fun addNewMail(mail : Mail){
        mailList.add(mail)
    }

    fun checkCompose(receiver: String, subject: String, composeMail: String) : Boolean{
        if(receiver.isValidEmail() && !subject.isNullOrEmpty() && !composeMail.isNullOrEmpty()) return true
        return false
    }
}

data class Mail(val receiver : String, val subject: String, val composeMail : String)