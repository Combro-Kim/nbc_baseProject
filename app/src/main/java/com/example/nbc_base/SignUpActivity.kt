package com.example.nbc_base


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


//SignpActivity를 생성해 주세요.
//타이틀 이미지는 원하는 이미지로 넣어주세요.
//이름, 아이디, 비밀번호 모두 입력 되었을 때만 회원가입 버튼이 눌리도록 구현합니다.
//셋 중 하나라도 비어있으면 “입력되지 않은 정보가 있습니다” 라는
//토스트 메세지를 출력하도록 구현합니다.
//비밀번호 EditText는 입력 내용이 가려져야 합니다.(●●● 처리)
//회원가입 버튼이 눌리면 SignInActivity로 이동하도록 구현합니다. (finish 활용)

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

            Toast.makeText(this, "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show()
            finish()

        }
    }
}