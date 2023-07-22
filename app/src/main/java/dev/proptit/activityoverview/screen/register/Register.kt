package dev.proptit.activityoverview.screen.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding
import dev.proptit.activityoverview.screen.login.Login
import dev.proptit.activityoverview.section.account.Account
import dev.proptit.activityoverview.section.password.PasswordManager

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var btnRegister: Button
    private lateinit var btnLogin: Button
    private lateinit var edtPassword: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtFullName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponent()
        setupClickListener()
    }

    private fun initComponent() {
        btnRegister = binding.btnRegister
        btnLogin = binding.btnLogin
        edtPassword = binding.edtPassword
        edtEmail = binding.edtEmail
        edtFullName = binding.edtFullName
    }

    private fun setupClickListener() {
        btnRegister.setOnClickListener {
            val fullName = edtFullName.text.toString()
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            if (!PasswordManager.checkValidEmail(email)) {
                Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show()
            } else if (PasswordManager.checkDuplicateEmail(email)) {
                Toast.makeText(this, "Email already exists", Toast.LENGTH_SHORT).show()
            } else if (!PasswordManager.checkValidPassword(password)) {
                Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show()
            } else {
                val account = Account(fullName, email, password)
                PasswordManager.addAccount(account)
                val intent = Intent(this, Login::class.java)
                intent.putExtra("email", email)
                startActivity(intent)
            }
        }
        btnLogin.setOnClickListener {
            finish()
        }
    }

}