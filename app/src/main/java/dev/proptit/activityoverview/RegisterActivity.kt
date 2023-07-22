package dev.proptit.activityoverview

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityMainBinding
import dev.proptit.activityoverview.databinding.ActivityRegisterBinding

class RegisterActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
