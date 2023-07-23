package dev.proptit.activityoverview.screen

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.gson.Gson
import dev.proptit.activityoverview.databinding.ActivityLoginBinding
import dev.proptit.activityoverview.section.manager.AccountManager


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val accountManager: AccountManager = AccountManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initBehaviour()
    }

    private fun initBehaviour() {
        binding.loginBtn.setOnClickListener loginBtnOnClick@ {
            val email = binding.loginEmailEdit.text.toString()
            val password = binding.loginPasswordEdit.text.toString()

            if (!accountManager.validateEmail(email)) {
                Toast.makeText(applicationContext, "Invalid Email", Toast.LENGTH_SHORT).show()
                return@loginBtnOnClick
            }
            if (!accountManager.validatePassword(password)) {
                Toast.makeText(applicationContext, "Invalid Password", Toast.LENGTH_SHORT).show()
                return@loginBtnOnClick
            }

            try {
                val account = accountManager.login(email, password)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(IntentExtra.USER_ACCOUNT, Gson().toJson(account))
                startActivity(intent)
            } catch (_: AccountManager.IncorrectEmailOrPassword) {
                Toast.makeText(applicationContext, "Incorrect Email or Password", Toast.LENGTH_SHORT).show()
            }
        }

        val getEmailFromRegisterActivity =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            when (it.resultCode) {
                Activity.RESULT_OK -> {
                    val userEmail = it.data?.getStringExtra(IntentExtra.USER_EMAIL)
                    binding.loginEmailEdit.setText(userEmail)
                    binding.loginPasswordEdit.setText("")
                }
            }
        }

        binding.loginToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            getEmailFromRegisterActivity.launch(intent)
        }
    }
}