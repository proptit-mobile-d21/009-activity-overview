package dev.proptit.activityoverview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import dev.proptit.activityoverview.databinding.ActivityHomeBinding
import dev.proptit.activityoverview.section.Password

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var emailEdt: EditText
    private lateinit var contentEdt: EditText
    private lateinit var sendBtn: Button
    private lateinit var passwordManager: Password
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponent()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        sendBtn.setOnClickListener(){
            val email = emailEdt.text.toString()
            val content = contentEdt.text.toString()
            if(!passwordManager.checkValidEmail(email)){
                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show()
            }
            else if(content.isEmpty()){
                Toast.makeText(this, "Fill the content", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(Intent.ACTION_SEND)
            }
        }
    }

    private fun initComponent() {
        emailEdt = binding.edtTo
        contentEdt = binding.edtContent
        sendBtn = binding.btnSend
        passwordManager = Password()
    }
}