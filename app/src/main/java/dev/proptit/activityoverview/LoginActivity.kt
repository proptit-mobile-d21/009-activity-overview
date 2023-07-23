package dev.proptit.activityoverview

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.emailBox.fieldName.text = getString(R.string.email)
        binding.passBox.fieldName.text = getString(R.string.pass)
        binding.passBox.box.inputType =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        val receiveEmail = intent.getStringExtra("email")
        binding.emailBox.box.setText(receiveEmail)
        binding.registerText.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val email = binding.emailBox.box.text.toString()
        val password = binding.passBox.box.text.toString()
        if (!PasswordManager.isValidEmail(email)) {
            Toast.makeText(this, "Email không hợp lệ", Toast.LENGTH_SHORT).show()
        } else if (!PasswordManager.isCorrectUser(email, password)) {
            Toast.makeText(this, "Email hoặc mật khẩu sai", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, ComposeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}