package dev.proptit.activityoverview.screen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityLoginBinding
import dev.proptit.activityoverview.section.password.PasswordManager


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.etAccount.setText(intent.getStringExtra("mail"))

        binding.btnRegister.setOnClickListener{
            Intent(this, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnToHome.setOnClickListener{
            if(PasswordManager.checkAccount(binding.etAccount.text.toString(), binding.etPass.text.toString())){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val dialog = AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Invalid Account!")
                    .setPositiveButton("OK", null)
                    .create()
                dialog.show()
            }
        }
    }


}