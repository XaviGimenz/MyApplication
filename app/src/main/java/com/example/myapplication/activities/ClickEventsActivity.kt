package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R

class ClickEventsActivity : AppCompatActivity(), View.OnLongClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_events)

        clickInLine()

        val btn1 = findViewById<Button>(R.id.buttonClickMulti1)
        val btn2 = findViewById<Button>(R.id.buttonClickMulti2)
        val btn3 = findViewById<Button>(R.id.buttonClickMulti3)

        btn1.setOnLongClickListener(this)
        btn2.setOnLongClickListener(this)
        btn3.setOnLongClickListener(this)
    }
    //Regla obligatoria para clicks en xmls:
    // el metodo tiene que ser PUBLICO,  nombres tienen que coincidir y reciben 1 solo parametro(view)

    fun xmlClick(view: View){
        Toast.makeText(this, "Click on xml", Toast.LENGTH_SHORT).show()

    }

    private fun clickInLine(){
        val btn = findViewById<Button>(R.id.buttonClickInLine)
        btn.setOnClickListener { Toast.makeText(this, "Click in line ", Toast.LENGTH_SHORT).show() }
    }

    override fun onLongClick(view: View): Boolean {
        when(view.id){
            R.id.buttonClickMulti1 -> Toast.makeText(this, "Click multi1", Toast.LENGTH_SHORT).show()
            R.id.buttonClickMulti2 -> Toast.makeText(this, "Click multi2", Toast.LENGTH_SHORT).show()
            R.id.buttonClickMulti3 -> Toast.makeText(this, "Click multi3", Toast.LENGTH_SHORT).show()
        }
        return true
    }


}