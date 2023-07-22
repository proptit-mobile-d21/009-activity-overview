package dev.proptit.activityoverview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import dev.proptit.activityoverview.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnRegister.setOnClickListener {
//            val receiver = binding.toEditText.text.toString()
//            val subject =  binding.subjectEditText.text.toString()
//            val composeMail =  binding.composeEmailEditText.text.toString()
//            if(MailManager.checkCompose(receiver, subject, composeMail)){
//                val mail = Mail(receiver, subject, composeMail)
//                MailManager.addNewMail(mail)
//            }
//            else{
//                binding.composeErrorText.visibility = View.VISIBLE
//            }
//        }
    }
}