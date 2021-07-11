package com.example.myapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_trial.*

class TrialActivity : AppCompatActivity() {

    var TAG :String = "TrialActivity123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trial)
        Log.v(TAG , "onCreate()")
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show()
        val btnclick = button2


        btnclick.setOnClickListener {
            val intent = Intent(this, TrialActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG , "onStart()")
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show()


    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG , "onResume()")
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG , "onPause()")
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG , "onStop()")
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(TAG , "onRestart()")
        Toast.makeText(this, "onRestart()", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG , "onDestroy()")
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show()
    }
}