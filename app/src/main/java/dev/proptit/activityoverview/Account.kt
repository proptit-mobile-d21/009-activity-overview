package dev.proptit.activityoverview

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account_table")
data class Account(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val fullName: String,
    val email: String,
    val password: String
)