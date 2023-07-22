package dev.proptit.activityoverview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            val fullName = binding.fullnameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            if(AccountManager.checkRegister(fullName, email, password)){
                val newAccount = Account(fullName, email, password)
                AccountManager.addAccount(newAccount)
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("Email", email)
                intent.putExtra("Password", password)
                startActivity(intent)
            }
            else{
                binding.registerErrorText.visibility = View.VISIBLE
            }
        }
    }
}

