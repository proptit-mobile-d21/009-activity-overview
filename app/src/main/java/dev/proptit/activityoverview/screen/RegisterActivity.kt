package dev.proptit.activityoverview.screen

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding
import dev.proptit.activityoverview.section.manager.AccountManager
import dev.proptit.activityoverview.share.IntentExtra

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val accountManager: AccountManager = AccountManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initBehaviour()
    }

    private fun initBehaviour() {
        binding.registerBtn.setOnClickListener registerBtnOnClick@ {
            val name: String = binding.registerNameEdit.text.toString()
            val email: String = binding.registerEmailEdit.text.toString()
            val password: String = binding.registerPasswordEdit.text.toString()

            if (!accountManager.validateEmail(email)) {
                Toast.makeText(applicationContext, "Invalid Email", Toast.LENGTH_SHORT).show()
                return@registerBtnOnClick
            }
            if (!accountManager.validatePassword(password)) {
                Toast.makeText(applicationContext, "Invalid Password", Toast.LENGTH_SHORT).show()
                return@registerBtnOnClick
            }

            try {
                accountManager.register(name, email, password)
                val intent = Intent()
                intent.putExtra(IntentExtra.USER_EMAIL, email)
                setResult(Activity.RESULT_OK, intent)
                finish()
            } catch (_: AccountManager.EmailIsAlreadyRegistered) {
                Toast.makeText(applicationContext, "This email is already registered!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.registerToLogin.setOnClickListener { finish() }
    }
}