package dev.proptit.activityoverview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    companion object {
        val REGISTER_THEN_LOGIN: Int = 2003;
        val USER_EMAIL: String = "new_user_email"
    }

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {
            val intent = Intent()
            intent.putExtra(USER_EMAIL, binding.registerEmailEdit.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        binding.registerToLogin.setOnClickListener { finish() }
    }
}