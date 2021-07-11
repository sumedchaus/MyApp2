package com.example.myapp2

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WiFi: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wifi_layout)


        val btn = findViewById<ImageButton>(R.id.wifi_btn)
        val btn2 = findViewById<ImageButton>(R.id.wifi_btn2)
        val textView = findViewById<TextView>(R.id.wifi_btn_text)


        var wifi = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager


        btn.setOnClickListener {


            wifi.isWifiEnabled = !wifi.isWifiEnabled

            if (!wifi.isWifiEnabled) {
                textView.text = "Wifi is ON"
            } else {
                textView.text = "Wifi is OFF"
            }
        }
        btn2.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val panelIntent = Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY)
                startActivityForResult(panelIntent, 0)
            } else {
                // use previous solution, add appropriate permissions to AndroidManifest file (see answers above)
                (this.getSystemService(Context.WIFI_SERVICE) as? WifiManager)?.apply { isWifiEnabled = true /*or false*/ }
            }
        }
    }
}