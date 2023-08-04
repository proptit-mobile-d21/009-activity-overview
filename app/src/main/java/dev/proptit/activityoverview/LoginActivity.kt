package dev.proptit.activityoverview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.Data.findAccount
import dev.proptit.activityoverview.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val email = binding.email
        val password = binding.password
        val loginButton = binding.loginButton
        loginButton.setOnClickListener {
            val account = Account("", email.text.toString(), password.text.toString())
            if (isValidEmail(email.text.toString())) {
                if (findAccount(account)) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    this.finish()
                } else {
                    Toast.makeText(this, "Wrong email or password !", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Invalid mail !", Toast.LENGTH_SHORT).show()
            }
        }
        val registerButton = binding.registerButton
        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}