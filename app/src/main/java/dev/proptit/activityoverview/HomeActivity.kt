package dev.proptit.activityoverview

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnsend.setOnClickListener {
            val tomail = binding.tobox.text.toString()
            val subject = binding.subjectbox.text.toString()
            val content = binding.composebox.text.toString()

            val i: Intent = Intent(Intent.ACTION_SENDTO)
            i.setType("message/rfc822")
            i.setData(Uri.parse("mailto:"))
            i.putExtra(Intent.EXTRA_EMAIL, arrayOf(tomail))
            i.putExtra(Intent.EXTRA_SUBJECT, subject)
            i.putExtra(Intent.EXTRA_TEXT, content)
            try {
                startActivity(Intent.createChooser(i, "Send mail..."))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    this,
                    "There are no email clients installed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}