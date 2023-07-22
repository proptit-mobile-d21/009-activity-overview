package dev.proptit.activityoverview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityHomeBinding

class HomeActivity:AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}