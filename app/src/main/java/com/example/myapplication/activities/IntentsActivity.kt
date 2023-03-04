package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.myapplication.Models.Student
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
        val intent = Intent(this, intentExtrasActivity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY // no guarda el activity en el stack
        //intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION // sin animacion
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // borra el stack completo
        startActivity(intent)
        //finish() // cuando se lanza el intent, mata el activity evitando que entre en el stack
    }

    private fun goIntentObject(){
        val intent = Intent(this, intentExtrasActivity::class.java)
        val student = Student("ALberto", "Santos", 24, isDeveloper = false)
        intent.putExtra("student", student)
        startActivity(intent)

    }
}