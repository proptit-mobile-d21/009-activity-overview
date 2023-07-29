package dev.proptit.activityoverview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            val fullName = binding.editFullName.text.toString()
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "không được để trống thông tin", Toast.LENGTH_SHORT).show()
            } else if (AccountManager.checkExistMail(email)) {
                Toast.makeText(this, "email đã tồn tại", Toast.LENGTH_SHORT).show()
            } else if (!AccountManager.checkValidMail(email)) {
                Toast.makeText(this, "email không hợp lệ", Toast.LENGTH_SHORT).show()
            } else if (!AccountManager.checkValidPassword(password)) {
                Toast.makeText(this, "mật khẩu không hợp lệ", Toast.LENGTH_SHORT).show()
            } else {
                AccountManager.addAccount(Account(fullName, email, password))
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                startActivity(intent)
            }
        }
    }
}