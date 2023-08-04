package dev.proptit.activityoverview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fullName = binding.fullName
        val email = binding.email
        val password = binding.password
        val registerButton = binding.registerButton
        registerButton.setOnClickListener {
            Data.addAccount(
                Account(
                    fullName.text.toString(),
                    email.text.toString(), password.text.toString()
                )
            )
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        val loginButton = binding.loginButton
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}