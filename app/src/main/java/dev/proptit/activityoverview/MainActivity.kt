package dev.proptit.activityoverview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.proptit.activityoverview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mainSendBtn.setOnClickListener {
            // https://developer.android.com/guide/components/intents-common.html#Email
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, binding.mainToEdit.text)
                putExtra(Intent.EXTRA_SUBJECT, binding.mainSubjectEdit.text)
                putExtra(Intent.EXTRA_TEXT, binding.mainComposeEmailEdit.text)
            }
            startActivity(intent)
        }
    }


}