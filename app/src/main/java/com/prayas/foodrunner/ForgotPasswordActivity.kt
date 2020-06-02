package com.prayas.foodrunner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var etRecoveryMobileNumber : EditText
    lateinit var etRecoveryEmail : EditText
    lateinit var btnNext : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        btnNext = findViewById(R.id.btnNext)
        etRecoveryEmail = findViewById(R.id.etRecoveryMobileNumber)
        etRecoveryEmail = findViewById(R.id.etRecoveryEmail)

        btnNext.setOnClickListener {
            val recMobileNumber = etRecoveryMobileNumber.text.toString()
            val recEmail = etRecoveryEmail.text.toString()
            val intent = Intent(this@ForgotPasswordActivity,RetrieveActivity::class.java)
            intent.putExtra("recMobileNumber",recMobileNumber)
            intent.putExtra("recEmail",recEmail)
            startActivity(intent)
        }
    }
}
