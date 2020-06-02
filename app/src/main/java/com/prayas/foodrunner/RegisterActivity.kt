package com.prayas.foodrunner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    lateinit var etRegisterName : EditText
    lateinit var etRegisterMobileNumber : EditText
    lateinit var etRegisterEmail : EditText
    lateinit var etRegisterAddress : EditText
    lateinit var etRegisterPassword : EditText
    lateinit var etRegisterConfirmPassword : EditText
    lateinit var btnRegister : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        title = "Registration"

        etRegisterName = findViewById(R.id.etRegisterName)
        etRegisterMobileNumber = findViewById(R.id.etRegisterMobileNumber)
        etRegisterEmail = findViewById(R.id.etRegisterEmail)
        etRegisterAddress = findViewById(R.id.etRegisterAddress)
        etRegisterPassword = findViewById(R.id.etRegisterPassword)
        etRegisterConfirmPassword = findViewById(R.id.etRegisterConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener{
            val name = etRegisterName.text.toString()
            val mobNumber = etRegisterMobileNumber.text.toString()
            val email = etRegisterEmail.text.toString()
            val address = etRegisterAddress.text.toString()
            val password = etRegisterPassword.text.toString()
            val confirmedPassword = etRegisterConfirmPassword.text.toString()

            val intent = Intent(this@RegisterActivity,WelcomeActivity::class.java)
            intent.putExtra("name",name)
            intent.putExtra("mobileNumber",mobNumber)
            intent.putExtra("email",email)
            intent.putExtra("address",address)
            if (password.equals(confirmedPassword)){
                intent.putExtra("password",password)
                startActivity(intent)
            }else{
                Toast.makeText(this@RegisterActivity
                    ,"the confirmed password doesn't match"
                    ,Toast.LENGTH_LONG).show()
            }
        }

    }
}
