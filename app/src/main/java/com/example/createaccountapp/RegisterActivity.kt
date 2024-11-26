package com.example.createaccountapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account2)

        val loginTextView = findViewById<TextView>(R.id.alreadyMemberTextView)
        loginTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val nextButton = findViewById<MaterialButton>(R.id.registerButton)
        nextButton.setOnClickListener {
        }
    }
}
