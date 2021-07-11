package com.example.myapp2

import android.bluetooth.BluetoothAdapter
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Bluetooth: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bluetooth_layout)


        val btnBt = findViewById<ImageButton>(R.id.BtBtn)
        val tvBt = findViewById<TextView>(R.id.BtTv)

        // Declaring Bluetooth adapter
        val mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

        // On button Click
        btnBt.setOnClickListener {

            // Enable or disable the Bluetooth and display
            // the state in Text View
            if (mBluetoothAdapter.isEnabled) {
                mBluetoothAdapter.disable()
                tvBt.text = "Bluetooth is OFF"
                btnBt.colorFilter

            } else {
                mBluetoothAdapter.enable()
                tvBt.text = "Bluetooth is ON"
            }
        }
    }
}