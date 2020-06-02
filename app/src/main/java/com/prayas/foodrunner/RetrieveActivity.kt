package com.prayas.foodrunner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RetrieveActivity : AppCompatActivity() {

    lateinit var txtRetrieveMobileNumber : TextView
    lateinit var txtRetrieveEmail : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrieve)

        txtRetrieveMobileNumber = findViewById(R.id.txtRetrieveMobileNumber)
        txtRetrieveMobileNumber.text = intent.getStringExtra("recMobileNumber")

        txtRetrieveEmail = findViewById(R.id.txtRetrieveEmail)
        txtRetrieveEmail.text = intent.getStringExtra("recEmail")
    }
}
