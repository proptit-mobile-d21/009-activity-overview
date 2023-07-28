package dev.proptit.activityoverview.screen

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import dev.proptit.activityoverview.databinding.ActivityMainBinding
import dev.proptit.activityoverview.section.account.Account
import dev.proptit.activityoverview.share.IntentExtra

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initBehaviour()
        showWelcome()
    }

    private fun initBehaviour() {
        binding.mainSendBtn.setOnClickListener {
            // https://developer.android.com/guide/components/intents-common.html#Email
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, binding.mainToEdit.text)
                putExtra(Intent.EXTRA_SUBJECT, binding.mainSubjectEdit.text)
                putExtra(Intent.EXTRA_TEXT, binding.mainComposeEmailEdit.text)
            }
            startActivity(intent)
        }
    }

    private fun showWelcome() {
        val accountJson: String? = intent?.getStringExtra(IntentExtra.USER_ACCOUNT)
        var message: String = "Unknown Account"
        if (accountJson != null) {
            val account: Account = Gson().fromJson(accountJson, Account::class.java)
            message = "Welcome back, ${account.name}"
        }
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}