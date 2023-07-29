package dev.proptit.activityoverview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding
import dev.proptit.activityoverview.section.Account
import dev.proptit.activityoverview.section.Password

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var loginTxt: TextView
    private lateinit var fullNameEdt: EditText
    private lateinit var emailEdt: EditText
    private lateinit var passwordEdt: EditText
    private lateinit var registerBtn: Button
    private lateinit var passwordManager:Password
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponent()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        loginTxt.setOnClickListener(){
            finish()
        }
        registerBtn.setOnClickListener(){
            val fullName = fullNameEdt.text.toString()
            val email = emailEdt.text.toString()
            val password = passwordEdt.text.toString()
            if(!passwordManager.checkValidEmail(email)){
               Toast.makeText(this,"Invalid Email", Toast.LENGTH_SHORT).show()
            }else if(!passwordManager.checkDuplicateEmail(email)){
                Toast.makeText(this,"Email has already existed", Toast.LENGTH_SHORT).show()
            }
            else if(!passwordManager.checkValidPassword(password)){
                Toast.makeText(this,"Invalid Password", Toast.LENGTH_SHORT).show()
            }
            else{
                val newAccount = Account(fullName,email,password)
                passwordManager.addAccount(newAccount)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("email", email)
                startActivity(intent)
            }
        }
    }

    private fun initComponent() {
        loginTxt = binding.txtAlreadyAccount
        fullNameEdt = binding.edtFullName
        emailEdt = binding.edtEmail
        passwordEdt = binding.edtPassword
        registerBtn = binding.btnRegister
        passwordManager = Password()
    }
}