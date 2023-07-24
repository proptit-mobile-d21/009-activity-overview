package dev.proptit.activityoverview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding
import android.util.Patterns

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var accountManager: AccountManager

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        accountManager = AccountManager.getInstance(this)
        val fullname = binding.fullnameRegister
        val email = binding.emailRegister
        val password = binding.passwordRegister
        val login = binding.registerToLogin
        val register = binding.registerButton
        login.setOnClickListener {
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        register.setOnClickListener {
            val fullnameText = fullname.text.toString()
            val emailText = email.text.toString()
            val passwordText = password.text.toString()
            if(fullnameText.isBlank() || emailText.isBlank() || passwordText.isBlank()) {
                Toast.makeText(this, "Please enter all information completely!",
                    Toast.LENGTH_SHORT).show()
            }else if(isEmailValid(emailText)) {
                accountManager.saveAccount(fullnameText, emailText, passwordText)
                Toast.makeText(this, "Sign Up Success!", Toast.LENGTH_SHORT).show()
                intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                Toast.makeText(this, "Invalid email!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}