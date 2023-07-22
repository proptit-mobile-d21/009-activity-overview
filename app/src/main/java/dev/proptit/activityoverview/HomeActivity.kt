package dev.proptit.activityoverview

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

        binding.btnComposeEmail.setOnClickListener {
            val receiver = binding.editTo.text.toString()
            val subject = binding.editSubject.text.toString()
            val composeMail = binding.editComposeEmail.text.toString()
            if (receiver.isEmpty() || subject.isEmpty() || composeMail.isEmpty()) {
                Toast.makeText(this, "Không được để trống thông tin", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Hoàn tất tác vụ!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}