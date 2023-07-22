package dev.proptit.activityoverview

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.proptit.activityoverview.databinding.ActivitySendEmailBinding

class SendEmailActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySendEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendEmailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSend.setOnClickListener{
            val receiver = binding.etEmailReceiver.text.toString()
            val subject = binding.etSubject.text.toString()
            val body = binding.etEmailBody.text.toString()
            if(receiver == "" || subject == "" || body == ""){
                Toast.makeText(this@SendEmailActivity, "Please enter all fields", Toast.LENGTH_SHORT).show()
            }
            else{
                sendEmail(receiver, subject, body)
            }
        }
    }
    @SuppressLint("QueryPermissionsNeeded")
    private fun sendEmail(receiver: String, subject: String, body: String){
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(receiver))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, body)
        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
        else{
            Toast.makeText(this@SendEmailActivity, "No app can handle this request", Toast.LENGTH_SHORT).show()
        }
    }
}