package com.example.myapp2
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.widget.ImageButton


//private const val REQUEST_CODE = 42
class Camera : AppCompatActivity() {


        private val cameraRequest = 7777
        lateinit var imageView: ImageView
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.camera_layout)

            if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED)
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), cameraRequest)
            imageView = findViewById(R.id.imageView)
            val photoButton: ImageButton = findViewById(R.id.button)
            photoButton.setOnClickListener {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, cameraRequest)
            }
        }
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == cameraRequest) {
                val photo: Bitmap = data?.extras?.get("data") as Bitmap
                imageView.setImageBitmap(photo)
            }
        }
    }




//        camera_btn.setOnClickListener {
//            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//
//            if (takePictureIntent.resolveActivity(this.packageManager) != null) {
//                startActivityForResult(takePictureIntent, REQUEST_CODE)
//            } else {
//                Toast.makeText(this, "Unable to open camera", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//            if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
//                val takenImage = data?.extras?.get("data") as Bitmap
//                imageView.setImageBitmap(takenImage)
//            } else {
//                super.onActivityResult(requestCode, resultCode, data)
//            }
//        }
//    }