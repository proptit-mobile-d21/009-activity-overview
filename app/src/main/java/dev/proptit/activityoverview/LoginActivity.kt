package dev.proptit.activityoverview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.util.Patterns
class LoginActivity : AppCompatActivity() {
    private lateinit var accountManager : AccountManager
    private lateinit var binding: ActivityLoginBinding
    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        accountManager = AccountManager.getInstance(this)
        val email = binding.emailLogin
        val password = binding.passwordLogin
        val forgot = binding.forgotPassword
        val register = binding.loginToRegister
        val login = binding.loginButton
        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
        login.setOnClickListener {
            val emailText = email.text.toString()
            val passwordText = password.text.toString()
            if (emailText.isBlank() || passwordText.isBlank()) {
                Toast.makeText(
                    this, "Please enter all information completely!",
                    Toast.LENGTH_SHORT
                ).show()
            } else if(isEmailValid(emailText)) {
                GlobalScope.launch(Dispatchers.Main) {
                    val savedAccount = withContext(Dispatchers.IO) {
                        accountManager.getSavedAccount()
                    }
                    if (savedAccount != null && savedAccount.email == emailText
                        && savedAccount.password == passwordText
                    ) {
                        Toast.makeText(this@LoginActivity, "Sign in success!", Toast.LENGTH_SHORT)
                            .show()
                        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this@LoginActivity,
                            "Email or password is incorrect!", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "Invalid email!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}