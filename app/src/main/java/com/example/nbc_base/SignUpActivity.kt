package com.example.nbc_base


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setupSignUpButton()

    }

    private fun setupSignUpButton() {
        val signUpButton = findViewById<Button>(R.id.signUpButton)

        signUpButton.setOnClickListener {
            val name = findViewById<EditText>(R.id.nameEditText).text.toString()
            val id = findViewById<EditText>(R.id.idEditText).text.toString()
            val password = findViewById<EditText>(R.id.passwordEditText).text.toString()


            if (name.isEmpty() || id.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("dataFromSignUpName",name)

            Toast.makeText(this, "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show()
            finish()

        }
    }
}