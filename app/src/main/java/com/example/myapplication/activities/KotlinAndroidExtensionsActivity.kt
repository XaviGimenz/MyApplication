package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityKotlinAndroidExtensionsBinding

// import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*


class KotlinAndroidExtensionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKotlinAndroidExtensionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKotlinAndroidExtensionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn = findViewById<Button>(R.id.buttonById)
        btn.setOnClickListener{ Toast.makeText(this,"Click by id", Toast.LENGTH_SHORT).show() }

        //buttonByKat.setOnClickListener { Toast.makeText(this,"Click by KAT", Toast.LENGTH_SHORT).show()  }

        binding.buttonByKat.setOnClickListener { Toast.makeText(this,"Click by binding", Toast.LENGTH_SHORT).show()  }
    }


}