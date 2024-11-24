package com.example.createaccountapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account1)

        val registerTextView = findViewById<TextView>(R.id.newMemberTextView)
        registerTextView.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val nextButton = findViewById<MaterialButton>(R.id.nextButton)
        nextButton.setOnClickListener {
        }
    }
}
