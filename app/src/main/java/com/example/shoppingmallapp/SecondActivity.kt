package com.example.shoppingmallapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val txtDetail = findViewById<TextView>(R.id.textViewDetail)
        val txtTotal = findViewById<TextView>(R.id.textViewTotal)

        val i = intent.extras
        if (i != null) {
            txtTotal.text = i.getInt("123").toString()
            txtDetail.text = i.getString("abc").toString()
        }
    }
}