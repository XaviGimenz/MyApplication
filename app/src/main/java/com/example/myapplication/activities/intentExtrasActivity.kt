package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Models.Student
import com.example.myapplication.databinding.ActivityIntentExtrasBinding

class intentExtrasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntentExtrasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentExtrasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentExtrasFromPreviousActivity()
        binding.buttonBack.setOnClickListener { goBack() }
        getParcelableExtraFromPreviousActivity()
    }
    private fun getParcelableExtraFromPreviousActivity(){
        val student = intent.getParcelableExtra<Student>("student")
        student?.let{
            binding.textViewName.text = student.name
            binding.textViewLastName.text = student.lastName
            binding.textViewAge.text = "${student.age}"
            binding.checkBoxDeveloper.isChecked = student.isDeveloper
        }
    }
    private fun getIntentExtrasFromPreviousActivity(){

        val name: String? = intent.getStringExtra("name")
        val lastName: String? = intent.getStringExtra("lastName")
        val age = intent.getIntExtra("age", 0)
        val developer = intent.getBooleanExtra("developer", false)

        if(name != null && lastName != null && age > 0) {
            binding.textViewName.text = name
            binding.textViewLastName.text = lastName
            binding.textViewAge.text = "$age"
            binding.checkBoxDeveloper.isChecked = developer
        }
    }
    private fun goBack(){
        val intent = Intent(this, IntentsActivity::class.java)
        startActivity(intent)
        finish()
    }
}