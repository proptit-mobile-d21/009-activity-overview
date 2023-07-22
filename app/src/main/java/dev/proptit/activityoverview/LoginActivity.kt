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
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        val extras = intent.extras
        if (extras != null) {
            binding.editEmail.setText(extras.getString("email"))
            binding.editPassword.setText(extras.getString("password"))
        }

    }
}