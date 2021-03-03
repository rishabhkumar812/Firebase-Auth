package com.projects.userlogin

import android.content.Intent
import android.os.Bundle
import android.os.ProxyFileDescriptorCallback
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var emailAddress: EditText
    lateinit var password:EditText
    lateinit var loginButton : Button
    lateinit var newAccountButton: Button
    lateinit var progressBar: ProgressBar
    private var firebaseAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()

        //auto login process
        //move to main activity if user already sign in
        if (firebaseAuth!!.getCurrentUser() != null) {
            // User is logged in
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
        setContentView(R.layout.activity_login)
        initViews()



    }

    fun initViews()
    {
        emailAddress=findViewById(R.id.editTextTextEmailAddress)
        password=findViewById(R.id.editTextTextPassword)
        loginButton= findViewById(R.id.loginButton)
        newAccountButton=findViewById(R.id.newAccountButton)
        progressBar=findViewById(R.id.progressBar)
    }

    fun login(view: View)
    {
        firebaseAuth = FirebaseAuth.getInstance()
        val useremail: String = emailAddress.getText().toString()
        val userpassword = password.text.toString()

        if (TextUtils.isEmpty(useremail)) {
            Toast.makeText(
                this@LoginActivity.applicationContext,
                "Enter email!",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (TextUtils.isEmpty(userpassword)) {
            Toast.makeText(
                this@LoginActivity.applicationContext,
                "Enter password!",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        progressBar.setVisibility(View.VISIBLE)

        //login user

        //login user
        firebaseAuth!!.signInWithEmailAndPassword(useremail, userpassword)
            .addOnCompleteListener { task ->
                progressBar.setVisibility(View.GONE)
                if (!task.isSuccessful) {
                    if (userpassword.length < 6) {
                        password.error = this@LoginActivity.getString(R.string.minimum_password)
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            this@LoginActivity.getString(R.string.auth_failed),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    this@LoginActivity.startActivity(
                        Intent(
                            this@LoginActivity,
                            MainActivity::class.java
                        )
                    )
                    finish()
                }
            }


    }

    fun newAccount(view: View)
    {
        startActivity(Intent(this@LoginActivity,SignupActivity::class.java))
        finish()
    }
}