package dev.proptit.activityoverview.screen.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityHomeBinding
import dev.proptit.activityoverview.section.password.PasswordManager

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var toEdt: EditText
    private lateinit var subjectEdt: EditText
    private lateinit var contentEdt: EditText
    private lateinit var sendBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponent()
        setupClickListener()
    }

    private fun initComponent() {
        toEdt = binding.edtTo
        subjectEdt = binding.edtSubject
        contentEdt = binding.edtComposeEmail
        sendBtn = binding.btnSend
    }

    private fun setupClickListener() {
        sendBtn.setOnClickListener {
            val toMess = toEdt.text.toString()
            val subjectMess = subjectEdt.text.toString()
            val contentMess = contentEdt.text.toString()

            if (toMess.isEmpty() || subjectMess.isEmpty() || contentMess.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (!PasswordManager.checkValidEmail(toMess)) {
                Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show()
            } else {
                Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(toMess))
                    putExtra(Intent.EXTRA_SUBJECT, subjectMess)
                    putExtra(Intent.EXTRA_TEXT, contentMess)
                }.run {
                    startActivity(Intent.createChooser(this, "Choose an email client"))
                }
            }
        }
    }
}