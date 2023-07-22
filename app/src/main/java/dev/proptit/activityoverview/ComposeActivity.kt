package dev.proptit.activityoverview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityComposeBinding

class ComposeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComposeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComposeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toBox.fieldName.text = getString(R.string.to)
        binding.subjectBox.fieldName.text = getString(R.string.subject)
        binding.composeEmailBox.fieldName.text = getString(R.string.compose_email)
        binding.btnSend.setOnClickListener {
            sendMail()
        }
    }

    private fun sendMail() {
        val originalString = binding.toBox.box.text.toString()
        val recipients = originalString.split(",").toTypedArray()
        val subject = binding.subjectBox.box.text.toString()
        val compose = binding.composeEmailBox.box.text.toString()
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, recipients)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, compose)
        startActivity(intent)
    }
}