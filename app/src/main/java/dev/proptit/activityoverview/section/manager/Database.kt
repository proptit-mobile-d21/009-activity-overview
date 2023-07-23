package dev.proptit.activityoverview.section.manager

import dev.proptit.activityoverview.section.account.Account

object Database {
    val accounts = mutableListOf<Account>().apply {
        add(Account("ADMIN", "admin@app.org", "admin1234"))
    }
}