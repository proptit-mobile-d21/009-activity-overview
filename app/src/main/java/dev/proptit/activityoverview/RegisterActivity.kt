package dev.proptit.activityoverview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
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
            Register()
        }
    }

    private fun Register() {
        val fullName = binding.fullNameBox.box.text.toString()
        val email = binding.emailBox.box.text.toString()
        val password = binding.passBox.box.text.toString()
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Trường nhập vào không hợp lệ", Toast.LENGTH_SHORT).show()
        } else {
            val user = User(fullName, email, password)
            val reference = FirebaseDatabase.getInstance().getReference("Users")
            Log.d("Test database", "adda")
            reference.child(fullName).setValue(user).addOnCompleteListener {
                binding.fullNameBox.fieldName.text = ""
                binding.emailBox.fieldName.text = ""
                binding.passBox.fieldName.text = ""
                Toast.makeText(this, "Đăng kí thành công", Toast.LENGTH_SHORT).show()
            }
        }
    }
}