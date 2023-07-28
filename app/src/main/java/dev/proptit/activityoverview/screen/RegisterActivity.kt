package dev.proptit.activityoverview.screen

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding
import dev.proptit.activityoverview.section.account.Account
import dev.proptit.activityoverview.section.password.PasswordManager

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnToLogin.setOnClickListener {
            if(!PasswordManager.checkValidMail(binding.etAccount.text.toString())){
                val dialog = AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Invalid Mail input!")
                    .setPositiveButton("OK", null)
                    .create()
                dialog.show()
            }else if(!PasswordManager.checkValidPass(binding.etPass.text.toString())){
                val dialog = AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Invalid Password input!")
                    .setPositiveButton("OK", null)
                    .create()
                dialog.show()
            }else{
                val account = Account(binding.etName.toString(), binding.etAccount.text.toString(), binding.etPass.text.toString())
                PasswordManager.addAccount(account)
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("mail", binding.etAccount.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }


}