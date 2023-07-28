package dev.proptit.activityoverview.section.account

import java.io.Serializable

data class Account(val name: String, val email:String, val password:String) : Serializable