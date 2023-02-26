package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.coroutines.delay

class LifeCycleActivity : AppCompatActivity() {

    private var exitEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }

    /*override fun onBackPressed() {
        if (exitEnabled){
            super.onBackPressed()
        }
        exitEnabled = true
        Toast.makeText(this, "vuelve a pulsar para irse", Toast.LENGTH_SHORT).show()
        Handler().postDelayed(Runnabe {exitEnabled = false}, delay)
    }*/
}