package dev.proptit.activityoverview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val to = binding.to
        val subject = binding.subject
        val composeMail = binding.composeMail
        val sendButton = binding.sendButton
        sendButton.setOnClickListener {
            val toAddress = to.text.toString()
            val emailSubject = subject.text.toString()
            val emailText = composeMail.text.toString()
            if (isValidEmail(emailSubject)) {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(toAddress))
                    putExtra(Intent.EXTRA_SUBJECT, emailSubject)
                    putExtra(Intent.EXTRA_TEXT, emailText)
                }
                startActivity(emailIntent)
            } else {
                Toast.makeText(this, "Invalid mail", Toast.LENGTH_SHORT).show()
            }
        }
    }
}