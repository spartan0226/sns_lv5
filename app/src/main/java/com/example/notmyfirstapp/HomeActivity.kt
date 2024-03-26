package com.example.notmyfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_end = findViewById<Button>(R.id.btn_end)
        val my_id = findViewById<TextView>(R.id.textView6)
        val id = intent.getStringExtra("id").toString()
        my_id.text = "아이디 : $id"

        val homeImage = findViewById<ImageView>(R.id.imageView3)
        when ((0..4).random()) {
            0 -> homeImage.setImageResource(R.drawable.home1)
            1 -> homeImage.setImageResource(R.drawable.home2)
            2 -> homeImage.setImageResource(R.drawable.home3)
            3 -> homeImage.setImageResource(R.drawable.home4)
            4 -> homeImage.setImageResource(R.drawable.home5)
        }

        btn_end.setOnClickListener {
            finish()
        }
    }
}
