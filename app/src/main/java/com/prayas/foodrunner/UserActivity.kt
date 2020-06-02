package com.prayas.foodrunner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserActivity : AppCompatActivity() {

    lateinit var txtUserMobileNumber : TextView
    lateinit var txtUserPassword : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        txtUserMobileNumber = findViewById(R.id.txtUserMobileNumber)
        txtUserMobileNumber.text = intent.getStringExtra("mobileNumber")
        txtUserPassword = findViewById(R.id.txtUserPassword)
        txtUserPassword.text = intent.getStringExtra("password")
    }
}
