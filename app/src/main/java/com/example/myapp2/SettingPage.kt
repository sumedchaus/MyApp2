package com.example.myapp2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.GridLayout
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SettingPage : AppCompatActivity(), ExampleAdapter.OnItemClickListner {
    private val settingList = ArrayList<SettingData>()
    private lateinit var ExampleAdapter: ExampleAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_list_view) // use all this code for recycle view // used layout of recycle view - setting list view


        prepareSettingData() // use this for creating list step 14
        ExampleAdapter = ExampleAdapter(settingList, this)


        val recyclerView: RecyclerView =
            findViewById(R.id.setting_recyclerview)  // used for finding our list view step 15   // id is <androidx.recyclerview.widget.RecyclerView
        //  android:id="@+id/setting_recyclerview"   used from setting list view
        //val layoutManager = LinearLayoutManager(applicationContext)   u can use this also for creating a linear layout manager
        //recyclerView.layoutManager = layoutManager   //
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)  // Step 16 used for positioning the item
        // for grid view use ::  recyclerView.layoutManager = GridLayoutManager(applicationContext,3)
        recyclerView.adapter = ExampleAdapter   //step 17 used for showing created list
    }


    private fun prepareSettingData() {
        settingList.add(SettingData(R.drawable.ic_baseline_about_phone, "About Phone"))
        settingList.add(SettingData(R.drawable.ic_baseline_wifi, "Wi-Fi"))
        settingList.add(SettingData(R.drawable.ic_baseline_bluetooth_24, "Bluetooth"))
        settingList.add(SettingData(R.drawable.ic_baseline_camera_24, "Camera"))
        settingList.add(SettingData(R.drawable.ic_baseline_vibration_24, "Vibration"))
        settingList.add(SettingData(R.drawable.ic_baseline_flash_light, "Flash Light"))
        settingList.add(SettingData(R.drawable.ic_baseline_system_update_24, "Trial Activity"))
        settingList.add(SettingData(R.drawable.ic_baseline_security_24, "ServiceExample"))
        settingList.add(SettingData(R.drawable.ic_baseline_sim_card_24, "Sim Card & Mobile Network"))
        settingList.add(SettingData(R.drawable.ic_baseline_vpn_key_24, "Vpn"))
        settingList.add(SettingData(R.drawable.ic_baseline_connetion_share_24, "Connection & Sharing"))
        settingList.add(SettingData(R.drawable.ic_baseline_lock_24, "Lock Screen"))
        settingList.add(SettingData(R.drawable.ic_baseline_display_24, "Display"))
        settingList.add(SettingData(R.drawable.ic_baseline_sound24, "Sound"))
        settingList.add(SettingData(
                R.drawable.ic_baseline_notifications_active_24,
                "Notifications"
            )
        )
        settingList.add(SettingData(R.drawable.ic_baseline_home_24, "Home Screen"))
        settingList.add(SettingData(R.drawable.ic_baseline_wallpaper_24, "Wallpaper"))
        settingList.add(SettingData(R.drawable.ic_baseline_password, "Password &Security"))
        settingList.add(
            SettingData(
                R.drawable.ic_baseline_battery_charging_full_24,
                "Battery & Performance"
            )
        )
        settingList.add(SettingData(R.drawable.ic_baseline_apps_24, "Apps"))
        settingList.add(
            SettingData(
                R.drawable.ic_baseline_additional_settings_ethernet_24,
                "Additional Setting"
            )
        )
        settingList.add(SettingData(R.drawable.ic_baseline_parental, "Parental Controls"))
        settingList.add(SettingData(R.drawable.ic_baseline_special, "Special Features"))
        settingList.add(SettingData(R.drawable.ic_baseline_googleacc, "Google"))
        settingList.add(SettingData(R.drawable.ic_baseline_sync_24, "Account & Sync"))
        settingList.add(SettingData(R.drawable.ic_baseline_privacy, "Privacy"))
        settingList.add(SettingData(R.drawable.ic_baseline_location_on_24, "Location"))
        settingList.add(SettingData(R.drawable.ic_baseline_feedback_24, "Services & Feedback"))


    }


    override fun onItemClick(position: Int) {       //
        Toast.makeText(this, "" + settingList[position].name, Toast.LENGTH_SHORT).show()

        if (settingList[position].name == "Wi-Fi") {
            val intent = Intent(this, WiFi::class.java)
            startActivity(intent)
        } else if (settingList[position].name == "About Phone") {
            val intent = Intent(this, About_Phone::class.java)
            startActivity(intent)
        } else if (settingList[position].name == "Bluetooth") {
            val intent = Intent(this, Bluetooth::class.java)
            startActivity(intent)
        } else if (settingList[position].name == "Camera") {
            val intent = Intent(this, Camera::class.java)
            startActivity(intent)
        } else if (settingList[position].name == "Vibration") {
            val intent = Intent(this, Vibrate::class.java)
            startActivity(intent)
        } else if (settingList[position].name == "Trial Activity") {
            val intent = Intent(this, TrialActivity::class.java)
            startActivity(intent)
        } else if (settingList[position].name == "Flash Light") {
            val intent = Intent(this, FlashLight::class.java)
            startActivity(intent)
        }else if (settingList[position].name == "ServiceExample") {
            val intent = Intent(this, ServiceExample::class.java)
            startActivity(intent)
        }
    }
}
//    private fun genrateDummyList(size: Int): ArrayList<SettingData> {
//     val list = ArrayList<SettingData>()
//
//        for (i in 0 until size) {
//            val drawable = when (i % 3) {
//                0 -> R.drawable.ic_baseline_about_phone
//                1 -> R.drawable.ic_baseline_system_update_24
//                else -> R.drawable.ic_baseline_feedback_24
//            }
//            val item = SettingData(drawable, "Item $i")
//            list += item
//        }
//        return list
//
//    }
//}