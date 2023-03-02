package com.example.myapplication.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityPicassoBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class PicassoActivity : AppCompatActivity() {

    private lateinit var Binding: ActivityPicassoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = ActivityPicassoBinding.inflate(layoutInflater)
        setContentView(Binding.root)
        setContentView(R.layout.activity_picasso)

        val btn = findViewById<Button>(R.id.ButtonLoader)
        btn.setOnClickListener { loadImages() }

        Picasso.get().load(
            "https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg").fetch()
    }
    private fun loadImages(){
        val imgTop = findViewById<ImageView>(R.id.imageViewTop)
        val imgBtm = findViewById<ImageView>(R.id.imageViewBottom)
        val context: Context = this
        Picasso.get().load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg")
            //.fit()
            .resize(300, 300)
            .centerInside()
            .into(imgTop)

        /*Picasso.get().load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
            .fit()
            .into(imgBtm)*/

        /*Picasso.get().load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
            .fit()
            .transform(CircleTransform()) //renderizar la imagen como un circulo
            .into(imgBtm)*/

        Picasso.get().load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
            .fetch(object: Callback{
                override fun onSuccess() {
                    imgBtm.alpha = 0f
                    Picasso.get().load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                        .fit()
                        .into(imgBtm)
                    imgBtm.animate().setDuration(300).alpha(1f).start()
                }
                override fun onError(e: Exception?) {

                }
            })
    }
}