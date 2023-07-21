package dev.proptit.activityoverview

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.proptit.activityoverview.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener{
            Intent(this, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnToHome.setOnClickListener{
            Intent(this, HomeActivity::class.java).also {
                startActivity(it)
            }
        }
    }
//override fun onCreate(savedInstanceState: Bundle?) {
//    binding = ActivityLoginBinding.inflate(layoutInflater)
//    super.onCreate(savedInstanceState)
//    setContentView(binding.root)
//    Log.d("===Activity Lifecycle===", "onCreate")
//    Toast.makeText(this, "Activity Lifecycle: onCreate", Toast.LENGTH_SHORT).show()
//}
//
//    override fun onStart() {
//        super.onStart()
//        Log.d("===Activity Lifecycle===", "onStart")
//        Toast.makeText(this, "Activity Lifecycle: onStart", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d("===Activity Lifecycle===", "onPause")
//        Toast.makeText(this, "Activity Lifecycle: onPause", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("===Activity Lifecycle===", "onStop")
//        Toast.makeText(this, "Activity Lifecycle: onStop", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("===Activity Lifecycle===", "onDestroy")
//        Toast.makeText(this, "Activity Lifecycle: onDestroy", Toast.LENGTH_SHORT).show()
//    }


}