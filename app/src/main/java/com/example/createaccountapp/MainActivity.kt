package com.example.createaccountapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.createaccountapp.fragments.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if the fragment is already loaded (in case of activity recreation)
        if (savedInstanceState == null) {
            // Load the LoginFragment initially
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment())  // Replace the container with LoginFragment
                .commit()
        }
    }
}

