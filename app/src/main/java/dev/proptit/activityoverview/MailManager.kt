package dev.proptit.activityoverview

import javax.security.auth.Subject

object MailManager {
    private val mailList = mutableListOf<Mail>()

    fun addNewMail(mail : Mail){
        mailList.add(mail)
    }

    fun checkCompose(receiver: String, subject: String, composeMail: String) : Boolean{
        if(!receiver.isNullOrEmpty() && !subject.isNullOrEmpty() && !composeMail.isNullOrEmpty()) return true
        return false
    }
}

data class Mail(val receiver : String, val subject: String, val composeMail : String)