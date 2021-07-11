package com.example.myapp2

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.vibrate_layout.*

class Vibrate : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vibrate_layout)
        val v = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)

        val vibbtn: ImageButton = vibratebn


        vibbtn.setOnClickListener {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(
                VibrationEffect.createOneShot(500,
                VibrationEffect.DEFAULT_AMPLITUDE))
        }
        else {
            v.vibrate(500)
        }

        }
    }
}