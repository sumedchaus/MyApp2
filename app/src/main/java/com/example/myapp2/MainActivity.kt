package com.example.myapp2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ListView
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity(){

    var editEmailAddress: String? = ""  // need to create variable for using xml code in kt code
    var editTextPassword: String? = ""
    private val sharedPrefFile = "kotlinsharedpreference"
    var sharedPreferences: SharedPreferences? = null
    var editor:SharedPreferences.Editor? =  null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // used for set  view which u want to view

         sharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
         editor =  sharedPreferences?.edit()


        editTextTextEmailAddress.setText("sumedchaus77@gmail.com")
        editTextTextPassword.setText("sumedchaus")

        var rememberMe = findViewById<CheckBox>(R.id.remember)


          if (sharedPreferences?.getBoolean("isChecked", false)!!){

              val intent = Intent(this@MainActivity, SettingPage::class.java)
              startActivity(intent)
          }



        imgBtnPlus.setOnClickListener {  //  set on click listner is used to opertae button
            val intent =
                Intent(this@MainActivity, ActivityRegister::class.java) // use for calling next page
            startActivity(intent)
        }


        btnLogin.setOnClickListener{
            editEmailAddress = editTextTextEmailAddress.text.toString() // syntex for convertig the xml code in to string
              editTextPassword = editTextTextPassword.text.toString()
//            val sharedNameValue = sharedPreferences.getString("name_key","defaultname")


            if (editEmailAddress?.equals("")!!) {
                Toast.makeText(this, resources.getString(R.string.str_please_enter_email_address), Toast.LENGTH_SHORT).show()
            } else if (!editEmailAddress?.contains("@")!!) { //  contains is used to check the following letter
                Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show()
            } else if (!editEmailAddress?.contains(".")!!) {
                Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show()
            } else if (editTextPassword?.equals("")!!) {
                Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show()
            } else if (editTextPassword?.length!! < 6) {
                Toast.makeText(this, "Password is too Weak", Toast.LENGTH_SHORT).show()
            } else if (editEmailAddress?.contains("sumedchaus77@gmail.com")!! && (editTextPassword?.contains("sumedchaus")!!)) {


                if(rememberMe.isChecked){

                    editor?.putString("email_address",editEmailAddress)
                    editor?.putString("password",editTextPassword)
                    editor?.putBoolean("isChecked",true)
                    editor?.apply()
                    editor?.commit()
                }

                val intent = Intent(this@MainActivity, SettingPage::class.java)
                startActivity(intent)
            }


        }
    }

//    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
//            if((CheckBox)po)
//    }
}








