package com.prayas.foodrunner

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var etMobileNumber : EditText
    lateinit var etPassword : EditText
    lateinit var btnLogin : Button
    lateinit var txtForgotPassword : TextView
    lateinit var txtSignUp : TextView
    private val validMobileNumber = mutableListOf("")
    private val validPassword = mutableListOf("")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)
        if (isLoggedIn){
            val intent = Intent(this@LoginActivity,WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "LOGIN"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtSignUp = findViewById(R.id.txtSignUp)

        btnLogin.setOnClickListener{
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            var checkMobileNumber: String = intent.getStringExtra("mobileNumber")
            var checkPassword: String = intent.getStringExtra("password")
            validMobileNumber.add(checkMobileNumber)
            validPassword.add(checkPassword)
            val intent = Intent(this@LoginActivity,UserActivity::class.java)
            if(validMobileNumber.contains(mobileNumber) && validPassword.contains(password))
            {
                intent.putExtra("mobileNumber",mobileNumber)
                intent.putExtra("password",password)
                startActivity(intent)
            }
            else{
                Toast.makeText(this@LoginActivity
                    ,"Incorrect Credentials"
                    ,Toast.LENGTH_LONG).show()
            }
        }


        txtForgotPassword.setOnClickListener {
            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        txtSignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("title", title).apply()
    }
}
