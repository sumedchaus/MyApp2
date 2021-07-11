package com.example.myapp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.my_service_layout.*

class ServiceExample :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_service_layout)
        val servicebutton: Button = findViewById(R.id.servicebtn)
        servicebutton.setOnClickListener { startService(Intent(applicationContext, MyService::class.java)) }
    }
}