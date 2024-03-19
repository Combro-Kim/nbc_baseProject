package com.example.nbc_base


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts


class SignInActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        setupSignInButton()
        setupSignUpButton()
        takeIdPW()
    }


    private fun setupSignUpButton() {
        val signUp = findViewById<Button>(R.id.signUpButton)
        signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private fun setupSignInButton() {
        val signIn = findViewById<Button>(R.id.signInButton)

        signIn.setOnClickListener {
            val id = findViewById<EditText>(R.id.signInIdEditText).text.toString()
            val password = findViewById<EditText>(R.id.signInPWEditText).text.toString()

            if (id.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("dataFromSignInId", id)
            startActivity(intent)
            Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

        }
    }

    private fun takeIdPW() {
        val id = findViewById<EditText>(R.id.signInIdEditText)
        val password = findViewById<EditText>(R.id.signInPWEditText)
        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {

                val signUpId = result.data?.getStringExtra("dataFromSignUpId") ?: ""
                val signUpPW = result.data?.getStringExtra("dataFromSignUpPW") ?: ""

                id.setText(signUpId)
                password.setText(signUpPW)
            }
        }
    }


}