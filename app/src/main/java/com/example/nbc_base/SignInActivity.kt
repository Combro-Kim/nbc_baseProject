package com.example.nbc_base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

//  [1]새 프로젝트를 만들고 MainActivity의 이름을 SignInActivity로 바꿔주세요.
//  [2]로고 이미지는 원하는 이미지로 넣어주세요.
//  [3]아이디, 비밀번호를 입력 받는 EditText를 넣어주세요.(미리보기 글씨(플레이스 홀더) 포함)
//  [4]비밀번호 EditText는 입력 내용이 가려져야 합니다.(●●● 처리)
//  [5]로그인 버튼을 누르면 HomeActivity가 실행되도록 구현합니다.
// todo (Extra로 아이디를 넘겨줍니다.)
// 아이디/비밀번호 모두 입력 되어야만 로그인 버튼이 눌리도록 구현합니다.
//  (“로그인 성공”이라는  토스트 메세지 출력하도록 구현)
//  아이디/비밀번호 중 하나라도 비어 있다면
//“아이디/비밀번호를 확인해주세요” 라는 토스트 메세지가 출력되도록 구현합니다.
//  회원가입 버튼을 누르면 SignUpActivity가 실행되도록 구현합니다.

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        setupSignInButton()
        setupSignUpButton()
    }



    private fun setupSignUpButton() {
        val signUp = findViewById<Button>(R.id.signUpButton)
        signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupSignInButton() {
        val signIn = findViewById<Button>(R.id.signInButton)

        signIn.setOnClickListener {
            val id = findViewById<EditText>(R.id.idEditText).text.toString()
            val password = findViewById<EditText>(R.id.passwordEditText).text.toString()


            if (id.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "아이디|비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("dataFromSignInId",id)
            startActivity(intent)
            Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

        }
    }



}



/*
    fun defWidget(){
        val signIn = findViewById<Button>(R.id.signInButton)
        val id = findViewById<EditText>(R.id.idEditText).text.toString()
        val password = findViewById<EditText>(R.id.passwordEditText).text.toString()
        val signUp = findViewById<Button>(R.id.signUpButton)
    }
*/
