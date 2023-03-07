package com.example.myapplication.activities

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityPermissionsBinding

class PermissionsActivity : AppCompatActivity() {
    private val requestCameraPermission = 100
    private val requestCameraPicture = 101
    private lateinit var binding: ActivityPermissionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPermissionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPicture.setOnClickListener { getPictureFromCameraAskingPermission() }

        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK){
                    if(result?.data != null){
                        val bitmap = result.data?.extras?.get("data") as Bitmap
                        binding.imageViewPicture.setImageBitmap(bitmap)
                    }
                }
            }

    }

    private fun getPictureFromCameraAskingPermission(){
        // Añadir permiso al manifest
        // Comprobar el permiso de la camera
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Si no ha sido aceptado previamente (versiones desde la 6.0 API 23 en adelante)
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), requestCameraPermission)
        } else {
            // Si ha sido aceptado previamente (Para versiones inferiores a la 6.0)
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            when (requestCode){
                requestCameraPermission -> {
                    if(grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        // Permiso aceptado
                        Toast.makeText(this, "Permiso aceptado", Toast.LENGTH_SHORT).show()

                    } else {
                        // Permiso denegado
                        Toast.makeText(this, "You can't take a picture if you don't allow it", Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            requestCameraPicture ->{
                // Comprobar si el resultado es bueno
                if(resultCode == Activity.RESULT_OK){
                    val extras = data!!.extras
                    // Formamos el bitmap a partir de los extras
                    val imageBitMap = extras!!.get("data") as Bitmap
                    // Cargamos la foto como bitmap en el imageview
                    binding.imageViewPicture.setImageBitmap(imageBitMap)
                }else{
                    // la foto no ha sido tomada con exito
                    Toast.makeText(this, "Picture has failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }*/
}