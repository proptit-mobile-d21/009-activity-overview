package dev.proptit.activityoverview

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fullNameBox.fieldName.text = getString(R.string.full_name)
        binding.emailBox.fieldName.text = getString(R.string.email)
        binding.passBox.fieldName.text = getString(R.string.pass)
        binding.passBox.box.inputType =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        binding.btnRegister.setOnClickListener {
            register()
        }

        binding.loginText.setOnClickListener {
            finish()
        }
    }

    private fun register() {
        val fullName = binding.fullNameBox.box.text.toString()
        val email = binding.emailBox.box.text.toString()
        val password = binding.passBox.box.text.toString()
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Trường nhập vào không hợp lệ", Toast.LENGTH_SHORT).show()
        } else if (!PasswordManager.isValidEmail(email)) {
            Toast.makeText(this, "Email không hợp lệ", Toast.LENGTH_SHORT).show()
        } else if (!PasswordManager.isDuplicateEmail(email)) {
            Toast.makeText(this, "Email đã tồn tại", Toast.LENGTH_SHORT).show()
        } else if (!PasswordManager.isValidPassword(password)) {
            Toast.makeText(this, "Mật khẩu phải chứa 6 kí tự trở lên", Toast.LENGTH_SHORT).show()
        } else {
            val user = User(fullName, email, password)
            PasswordManager.addUser(user)
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
}