package dev.proptit.activityoverview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            if(AccountManager.checkLogin(email, password)){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        val extras = intent.extras
        if(extras != null){
            binding.emailEditText.setText( extras.getString("Email"))
            binding.passwordEditText.setText(extras.getString("Password"))
        }


    }
}