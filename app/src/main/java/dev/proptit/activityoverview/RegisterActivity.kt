package dev.proptit.activityoverview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fullNameBox.fieldName.text = getString(R.string.full_name)
        binding.emailBox.fieldName.text = getString(R.string.email)
        binding.passBox.fieldName.text = getString(R.string.pass)
        binding.passBox.box.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
    }
}