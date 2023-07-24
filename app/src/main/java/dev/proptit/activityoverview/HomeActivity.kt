package dev.proptit.activityoverview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val recipient = binding.recipient
        val subject = binding.subject
        val mail = binding.composeEmail
        val send = binding.sendButton
        send.setOnClickListener {
            val recipientText = recipient.text.toString()
            val subjectText = subject.text.toString()
            val mailText = mail.text.toString()

            val intent = Intent(Intent.ACTION_SENDTO).apply{
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(recipientText))
                putExtra(Intent.EXTRA_SUBJECT, subjectText)
                putExtra(Intent.EXTRA_TEXT, mailText)
            }
            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Hello",Toast.LENGTH_SHORT).show()
            }
        }
    }
}