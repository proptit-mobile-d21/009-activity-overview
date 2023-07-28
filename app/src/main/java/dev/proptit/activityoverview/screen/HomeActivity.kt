package dev.proptit.activityoverview.screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        binding.btnToEmail.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW)
//            val toMail = binding.etTo.text.toString()
//            val subject = binding.etSubject.text.toString()
//            val content = binding.etContent.text.toString()
//            val data = Uri.parse(
//                "mailto:${toMail}?subject=" + Uri.encode(subject) + "&body=" + Uri.encode(
//                    content
//                )
//            )
//            intent.data = data
//            startActivity(intent)
//        }
        binding.btnToEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            val toMail = binding.etTo.text.toString()
            val subject = binding.etSubject.text.toString()
            val content = binding.etContent.text.toString()
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, toMail)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, content)
            startActivity(intent)

//            val intent = Intent(Intent.ACTION_SEND)
//            intent.type = "message/rfc822"
//            intent.putExtra(Intent.EXTRA_SUBJECT, "This is a test email.")
//            intent.putExtra(Intent.EXTRA_TEXT, "This is the body of the email.")
//            startActivity(Intent.createChooser(intent, "Choose an email app:"))
        }
    }
}