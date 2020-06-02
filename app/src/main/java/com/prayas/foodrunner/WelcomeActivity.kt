package com.prayas.foodrunner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {

    lateinit var txtName : TextView
    lateinit var txtMobileNumber :TextView
    lateinit var txtEmail : TextView
    lateinit var txtAddress : TextView
    lateinit var btnBackToLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        txtName = findViewById(R.id.txtName)
        txtName.text = intent.getStringExtra("name")

        txtMobileNumber = findViewById(R.id.txtMobileNumber)
        txtMobileNumber.text = intent.getStringExtra("mobileNumber")
        val mobNo = txtMobileNumber.text
        val pwd = intent.getStringExtra("password")
        txtEmail = findViewById(R.id.txtEmail)
        txtEmail.text = intent.getStringExtra("email")

        txtAddress = findViewById(R.id.txtAddress)
        txtAddress.text = intent.getStringExtra("address")

        btnBackToLogin =findViewById(R.id.btnBackToLogin)

        btnBackToLogin.setOnClickListener {
            val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
            intent.putExtra("mobileNumber", mobNo)
            intent.putExtra("password", pwd)
            startActivity(intent)
        }

    }
}
