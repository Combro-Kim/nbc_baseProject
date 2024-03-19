package com.example.nbc_base


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        takeData()

    }

    private fun takeData() {
        val idData = intent.getStringExtra("dataFromSignInId")
        val showId = findViewById<TextView>(R.id.takeIdTextView)
        showId.text = idData
    }


}