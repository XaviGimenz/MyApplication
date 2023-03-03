package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityIntentsBinding

class IntentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonIntentExtras.setOnClickListener { goIntentExtras() }
        binding.buttonIntentFlags.setOnClickListener { goIntentFlags() }
        binding.buttonIntentObjects.setOnClickListener { goIntentObject() }
    }

    private fun goIntentExtras(){
        val intent = Intent(this, intentExtrasActivity::class.java)
        intent.putExtra("name", "Xavi")
        intent.putExtra("lastName", "Gimenez")
        intent.putExtra("age", 30)
        intent.putExtra("developer", true)
        startActivity(intent)

    }
    private fun goIntentFlags(){
        val intent = Intent()
        startActivity(intent)

    }
    private fun goIntentObject(){
        val intent = Intent()
        startActivity(intent)

    }
}