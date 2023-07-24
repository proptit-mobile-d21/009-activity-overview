package dev.proptit.activityoverview

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AccountDao {
    @Insert
    fun insert(account: Account)

    @Query("SELECT * FROM account_table LIMIT 1")
    fun getSavedAccount(): Account?

    @Query("DELETE FROM account_table")
    fun clearSavedAccount()
}