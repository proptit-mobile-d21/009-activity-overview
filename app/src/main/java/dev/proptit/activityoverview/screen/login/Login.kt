package dev.proptit.activityoverview.screen.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityLoginBinding
import dev.proptit.activityoverview.screen.home.Home
import dev.proptit.activityoverview.screen.register.Register
import dev.proptit.activityoverview.section.password.PasswordManager

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponent()

        val receivedEmail = intent.getStringExtra("email")
        edtEmail.setText(receivedEmail)

        setupClickListener()
    }

    private fun initComponent() {
        btnLogin = binding.btnLogin
        btnRegister = binding.btnRegister
        edtEmail = binding.edtEmail
        edtPassword = binding.edtPassword
    }

    private fun setupClickListener() {
        btnLogin.setOnClickListener {
            if (PasswordManager.checkAccount(
                    edtEmail.text.toString(),
                    edtPassword.text.toString()
                )
            ) {
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Wrong email or password", Toast.LENGTH_SHORT).show()
            }
        }
        btnRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}