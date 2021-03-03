package com.projects.userlogin

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {
    lateinit var fullname: EditText
    lateinit var phoneNumber: EditText
    lateinit var emailAddress: EditText
    lateinit var password: EditText
    lateinit var registerButton: Button
    lateinit var loginPageButton: Button
    lateinit var progressBar: ProgressBar
    private var firebaseAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        initViews()
    }

    fun initViews() {
        fullname=findViewById(R.id.fullName)
        phoneNumber=findViewById(R.id.phoneNumber)
        emailAddress=findViewById(R.id.username)
        password=findViewById(R.id.password)
        registerButton=findViewById(R.id.registerButton)
        loginPageButton=findViewById(R.id.loginPage)
        progressBar=findViewById(R.id.progressBar)
    }

    fun register(view: View)
    {
        firebaseAuth= FirebaseAuth.getInstance()
        val userEmail: String = emailAddress.getText().toString().trim({ it <= ' ' })
        val userPassword = password.text.toString().trim { it <= ' ' }

        if (TextUtils.isEmpty(userEmail)) {
            Toast.makeText(
                this@SignupActivity,
                "Enter email!",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (TextUtils.isEmpty(userPassword)) {
            Toast.makeText(
                this@SignupActivity.applicationContext,
                "Enter password!",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (userPassword.length < 6) {
            password.error = this@SignupActivity.getString(R.string.minimum_password)
        }

        progressBar.setVisibility(View.VISIBLE)

        //register user

        //register user
        firebaseAuth!!.createUserWithEmailAndPassword(userEmail, userPassword)
            .addOnCompleteListener(this@SignupActivity) { task ->
                progressBar.setVisibility(View.GONE)
                if (!task.isSuccessful) {
                    Toast.makeText(this@SignupActivity,"Registration failed:"+task.exception,Toast.LENGTH_SHORT).show()
                } else {
                    startActivity(Intent(this@SignupActivity, MainActivity::class.java))
                    Toast.makeText(this@SignupActivity,"Registration successful",Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
    }

    fun gotoLogin(view: View)
    {
        startActivity(Intent(this@SignupActivity,LoginActivity::class.java))
        finish()
    }
}