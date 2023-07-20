package dev.proptit.activityoverview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            if(binding.editName.text.isEmpty()){
                Toast.makeText(this, "Vui lòng nhập tên!", Toast.LENGTH_SHORT).show()
            }
            else if(binding.editEmail.text.isEmpty()){
                Toast.makeText(this, "Vui lòng nhập email!", Toast.LENGTH_SHORT).show()
            }
            else if(binding.editPassword.text.isEmpty()){
                Toast.makeText(this, "Vui lòng nhập mật khẩu!", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("email", binding.editEmail.text.toString().trim())
                intent.putExtra("password", binding.editPassword.text.toString().trim())
                startActivity(intent)
            }
        }
    }
}