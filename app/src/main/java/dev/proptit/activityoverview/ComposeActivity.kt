package dev.proptit.activityoverview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.proptit.activityoverview.databinding.ActivityComposeBinding

class ComposeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComposeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComposeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toBox.fieldName.text = getString(R.string.to)
        binding.subjectBox.fieldName.text = getString(R.string.subject)
        binding.composeEmailBox.fieldName.text = getString(R.string.compose_email)
    }
}