package dev.proptit.activityoverview

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

        binding.btnToEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            val toMail = binding.etTo.text.toString()
            val subject = binding.etSubject.text.toString()
            val content = binding.etContent.text.toString()
            val data = Uri.parse(
                "mailto:${toMail}?subject=" + Uri.encode(subject) + "&body=" + Uri.encode(
                    content
                )
            )
            intent.data = data
            startActivity(intent)
        }
    }
}