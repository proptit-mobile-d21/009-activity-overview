package dev.proptit.activityoverview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            if (binding.editEmail.text.toString().isEmpty() || binding.editPassword.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(this, "Không được để trống thông tin", Toast.LENGTH_SHORT).show()
            } else {
                if (AccountManager.checkAccount(
                        binding.editEmail.text.toString(),
                        binding.editPassword.text.toString()
                    )
                ) {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val email: String? = intent.getStringExtra("email")
        val password: String? = intent.getStringExtra("password")
        if (email != null && password != null) {
            binding.editEmail.setText(email)
            binding.editPassword.setText(password)
        }
    }
}