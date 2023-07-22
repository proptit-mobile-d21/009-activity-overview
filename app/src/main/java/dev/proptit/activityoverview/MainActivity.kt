package dev.proptit.activityoverview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import dev.proptit.activityoverview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val laucher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val data = it.data
            if (data != null) {
                val email = data.getStringExtra("email")
                binding.etEmail.setText(email)
            }
        }
    }
   // private val REQUEST_CODE_REGISTER_EMAIL = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener {
            if (binding.etEmail.text.toString().equals("") || binding.etPassword.text.toString()
                    .equals("")
            ) {
                Toast.makeText(
                    this@MainActivity,
                    "Please enter your email and password",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (User.checkUser(
                        binding.etEmail.text.toString(),
                        binding.etPassword.text.toString()
                    )
                ) {
                    val intent = Intent(this@MainActivity, SendEmailActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@MainActivity, "Login failed", Toast.LENGTH_SHORT).show()
                }

            }

        }

        binding.tvRegister.setOnClickListener {
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
//            startActivityForResult(intent, REQUEST_CODE_REGISTER_EMAIL)
            laucher.launch(intent)
        }
    }

//    @Deprecated("Deprecated in Java")
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(REQUEST_CODE_REGISTER_EMAIL == requestCode && resultCode == Activity.RESULT_OK){
//            if (data != null) {
//                val email = data.getStringExtra("email")
//                val password = data.getStringExtra("password")
//                binding.etEmail.setText(email)
//                binding.etPassword.setText(password)
//            }
//        }
//
//    }
}