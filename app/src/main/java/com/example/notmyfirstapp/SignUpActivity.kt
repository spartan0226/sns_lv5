package com.example.notmyfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val my_name = findViewById<EditText>(R.id.et_name)
        val my_id2 = findViewById<EditText>(R.id.et_id2)
        val my_password2 = findViewById<EditText>(R.id.et_password2)
        val sign_up = findViewById<Button>(R.id.btn_signup2)

        sign_up.setOnClickListener {
            if (my_id2.text.isNullOrBlank() || my_name.text.isNullOrBlank() || my_password2.text.isNullOrBlank()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (my_id2.text.isNotBlank() && my_name.text.isNotBlank() && my_password2.text.isNotBlank()) {
                Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("pass_id", my_id2.text.toString())
                intent.putExtra("pass_word", my_password2.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}