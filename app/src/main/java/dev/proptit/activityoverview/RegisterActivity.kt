package dev.proptit.activityoverview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnregister.setOnClickListener{
            val fullName = binding.namebox.text.toString()
            val email = binding.emailbox2.text.toString()
            val password = binding.passwordbox2.text.toString()

            if(!Manager.checkValidateEmailAddress(email))
            {
                Toast.makeText(this, "Invalid email. Try again!", Toast.LENGTH_SHORT).show()
            }else if(Manager.checkDuplicateEmail(email))
            {
                Toast.makeText(this, "This email has already existed", Toast.LENGTH_SHORT).show()
            } else if(!Manager.checkValidatePassword(password))
            {
                Toast.makeText(this, "Invalid password. Try again!", Toast.LENGTH_SHORT).show()
            } else{
                val account = Account(fullName, email, password)
                Manager.addNewAccount(account)
                val intent = Intent(this, MainActivity::class.java)
                val bundle = Bundle()
                bundle.putString("email", email)
                bundle.putString("password", password)
                intent.putExtras(bundle)
                startActivity(intent)
            }

        }

        binding.btnlogin.setOnClickListener {
            finish()
        }

    }
}
