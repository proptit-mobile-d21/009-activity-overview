package dev.proptit.activityoverview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import dev.proptit.activityoverview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundle = intent.extras
        if(bundle!=null)
        {
            val receivedEmail = bundle.getString("email")
            binding.emailbox.setText(receivedEmail)
            val receivedPassword = bundle.getString("password")
            binding.passwordbox.setText(receivedPassword)
        }

        binding.btnregister.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnlogin.setOnClickListener {
            if(Manager.checkCorrectAccount(binding.emailbox.text.toString(), binding.passwordbox.text.toString()))
            {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else{
                Toast.makeText(this, "Wrong email address or password!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}