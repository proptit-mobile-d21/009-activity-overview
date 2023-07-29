package dev.proptit.activityoverview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            val receiver = binding.toEditText.text.toString()
            val subject =  binding.subjectEditText.text.toString()
            val composeMail =  binding.composeEmailEditText.text.toString()
            if(MailManager.checkCompose(receiver, subject, composeMail)){
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("mailto:") // only email apps should handle this

                intent.putExtra(Intent.EXTRA_EMAIL, receiver)
                intent.putExtra(Intent.EXTRA_SUBJECT, subject)
                intent.putExtra(Intent.EXTRA_TEXT, composeMail)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                    Toast.makeText(this, "Successful sending!", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this, "Not.", Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this, "To/Subject/Compose email is not correct.", Toast.LENGTH_LONG).show()
            }
        }
    }
}