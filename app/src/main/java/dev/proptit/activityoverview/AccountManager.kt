package dev.proptit.activityoverview

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AccountManager private constructor(private val accountDao: AccountDao) {
    companion object {
        @Volatile
        private var INSTANCE: AccountManager? = null

        fun getInstance(context: Context): AccountManager {
            return INSTANCE ?: synchronized(this) {
                val database = AppDatabase.getInstance(context)
                val instance = AccountManager(database.accountDao())
                INSTANCE = instance
                instance
            }
        }
    }

    fun saveAccount(fullName: String, email: String, password: String) {
        val account = Account(fullName = fullName, email = email, password = password)
        GlobalScope.launch(Dispatchers.IO) {
            accountDao.insert(account)
        }
    }

    suspend fun getSavedAccount(): Account? {
        return withContext(Dispatchers.IO) {
            accountDao.getSavedAccount()
        }
    }

    fun clearSavedAccount() {
        GlobalScope.launch(Dispatchers.IO) {
            accountDao.clearSavedAccount()
        }
    }
}