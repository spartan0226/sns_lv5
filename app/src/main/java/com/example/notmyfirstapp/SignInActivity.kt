package com.example.notmyfirstapp

import android.app.Activity
import android.content.Intent
import android.content.pm.LauncherActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var id : EditText
    private lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        id = findViewById<EditText>(R.id.et_id)
        password = findViewById<EditText>(R.id.et_password)
        val sign_in = findViewById<Button>(R.id.btn_signin)
        val sign_up = findViewById<Button>(R.id.btn_signup)

        setResult()

        sign_in.setOnClickListener {
            if (id.text.isNullOrBlank() || password.text.isNullOrBlank()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (id.text.isNotBlank() && password.text.isNotBlank()) {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("id", id.text.toString())
                startActivity(intent)
            }
        }

        sign_up.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private fun setResult() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val pass_id = it.data?.getStringExtra("pass_id") ?: ""
                    val pass_word = it.data?.getStringExtra("pass_word") ?: ""
                    id.setText(pass_id)
                    password.setText(pass_word)
                }
            }
    }
}
