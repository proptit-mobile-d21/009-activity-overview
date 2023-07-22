package dev.proptit.activityoverview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import dev.proptit.activityoverview.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    companion object {
        val USER_EMAIL: String = "user_email"
    }

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(USER_EMAIL, binding.loginEmailEdit.text)
            startActivity(intent)
        }

        binding.loginToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent, RegisterActivity.REGISTER_THEN_LOGIN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RegisterActivity.REGISTER_THEN_LOGIN) {
            if (resultCode == Activity.RESULT_OK) {
                val userEmail = data?.getStringExtra(RegisterActivity.USER_EMAIL)
                binding.loginEmailEdit.setText(userEmail)
            }
        }
    }
}