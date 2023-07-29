package dev.proptit.activityoverview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import dev.proptit.activityoverview.databinding.ActivityMainBinding
import dev.proptit.activityoverview.section.Password

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var registerTxt: TextView
    private lateinit var emailEdt: EditText
    private lateinit var passwordEdt: EditText
    private lateinit var loginBtn: Button
    private lateinit var passwordManager:Password
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initComponent()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        registerTxt.setOnClickListener(){
            val intent = Intent(this,RegisterActivity::class.java )
            startActivity(intent)
        }
        loginBtn.setOnClickListener(){
            val email = emailEdt.text.toString()
            val password = passwordEdt.text.toString()
            if(!passwordManager.checkValidEmail(email)){
                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show()
            }else if(!passwordManager.checkValidPassword(password)){
                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show()
            }else{
                val intent  = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun initComponent() {
        registerTxt = binding.txtNewAccount
        emailEdt = binding.edtEmail
        emailEdt.setText(intent.getStringExtra("email"))
        passwordEdt = binding.edtPassword
        loginBtn = binding.btnLogin
        passwordManager = Password()
    }
}