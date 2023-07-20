package dev.proptit.activityoverview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.proptit.activityoverview.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            if(binding.editTo.text.isEmpty()){
                Toast.makeText(this, "Vui lòng nhập địa chỉ email!", Toast.LENGTH_SHORT).show()
            }
            else if(binding.editSubject.text.isEmpty()){
                Toast.makeText(this, "Vui lòng nhập tiêu đề!", Toast.LENGTH_SHORT).show()
            }
            else if(binding.editComposeEmail.text.isEmpty()){
                Toast.makeText(this, "Vui lòng nhập nội dung!", Toast.LENGTH_SHORT).show()
            }
            else {
                val emailAddress = binding.editTo.text.toString().trim()
                val emailSubject = binding.editSubject.text.toString().trim()
                val emailContent = binding.editComposeEmail.text.toString().trim()

                val intent = Intent(Intent.ACTION_SEND)

                intent.putExtra(Intent.EXTRA_EMAIL, emailAddress)
                intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject)
                intent.putExtra(Intent.EXTRA_TEXT, emailContent)
                startActivity(intent)
            }
        }
    }
}