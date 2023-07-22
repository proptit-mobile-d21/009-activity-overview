package dev.proptit.activityoverview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnRegister.setOnClickListener{
            val name = binding.etFullName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            if(name.isEmpty() or email.isEmpty() or password.isEmpty()){
                Toast.makeText(this, "Please enter your email and password",Toast.LENGTH_SHORT).show()
            }
            else{
                if(User.addUser(email, password)){
                    Toast.makeText(this, "Register successfully", Toast.LENGTH_SHORT).show()
                    val intent = Intent().apply {
                        putExtra("email", email)
                    }
                    setResult(Activity.RESULT_OK, intent )
                    finish()
                }
                else{
                    Toast.makeText(this, "Register failed", Toast.LENGTH_SHORT).show()
                }

            }

        }


    }
}