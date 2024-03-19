package com.example.nbc_base


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

//HomeActivity를 생성해 주세요.
//SignInActivity에서 받은 extra data(아이디)를 화면에 표시합니다.
//ImageView, TextView 외에 각종 Widget을 활용해 자유롭게 화면을 디자인 해주세요.
//이름, 나이, MBTI 등 자기소개등이 들어가는 위젯을 자유롭게 디자인해주세요.
//종료 버튼이 눌리면 SignInActivity로 이동하도록 구현합니다. (finish 활용)

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        takeData()

        backToMain()

    }

    private fun backToMain() {
        val endButton = findViewById<Button>(R.id.endButton)
        endButton.setOnClickListener {
            finish()
        }
    }


    @SuppressLint("SetTextI18n")
    private fun takeData() {
        val showId = findViewById<TextView>(R.id.userId)
        val showName = findViewById<TextView>(R.id.userName)
        val showAge = findViewById<TextView>(R.id.userAge)
        val showMBTI = findViewById<TextView>(R.id.userMBTI)

        val idData = intent.getStringExtra("dataFromSignInId")

        showId.text = "${getString(R.string.id)} : $idData"
        showName.text = "${getString(R.string.name)} : 스마일"
        showAge.text = "${getString(R.string.age)} : 101"
        showMBTI.text = "MBTI : INFP"

    }

}