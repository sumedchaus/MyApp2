package com.example.myapp2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.register.*

class ActivityRegister : AppCompatActivity() {

    var registerEmailAddress: String? = ""
    var registerPassword: String? = ""
    var registerFirstName: String? = ""
    var registeLastName: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        imageCloseBtn.setOnClickListener {
            finish()
        }
        CrtAccountbutton.setOnClickListener {

            

            registerEmailAddress = editTextRegisterEmailAddress.text.toString()
            registerPassword = editTextRegisterPassword.text.toString()
            registerFirstName = editTextTextPersonName6.text.toString()
            registeLastName = editTextTextPersonName5.text.toString()


            if (registerFirstName.equals("")) {
                Toast.makeText(this, "Please enter First Name ", Toast.LENGTH_SHORT).show()
            } else if (registeLastName.equals("")) {
                Toast.makeText(this, "Please enter Last Name ", Toast.LENGTH_SHORT).show()
            }else if (registerEmailAddress.equals("")) {
                Toast.makeText(this, "Please enter email address", Toast.LENGTH_SHORT).show()
            } else if (!registerEmailAddress!!.contains("@")) {
                Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show()
            } else if (!registerEmailAddress!!.contains(".")) {
                Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show()
            } else if (registerPassword.equals("")) {
                Toast.makeText(this, "Please enter Password ", Toast.LENGTH_SHORT).show()
            } else if (registerPassword!!.length < 6) {
                Toast.makeText(this, "Password is too Weak", Toast.LENGTH_SHORT).show()
            }else if (registerPassword!!.length > 6) {
                val intent = Intent(this, AccountCreated::class.java)
                startActivity(intent)
            }
        }
    }
}