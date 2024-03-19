package com.example.nbc_base


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random
import kotlin.random.nextInt

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        takeData()
        randomImage()
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
        showName.text = "${getString(R.string.name)} : 포켓몬마스터"
        showAge.text = "${getString(R.string.age)} : 27"
        showMBTI.text = "MBTI : INFP"

    }

    private fun randomImage() { //when 사용 차이 ?
        val imageList = arrayListOf(
            R.drawable.icon_pokemon1,
            R.drawable.icon_pokemon2,
            R.drawable.icon_pokemon3,
            R.drawable.icon_pokemon4,
            R.drawable.icon_pokemon5,
            R.drawable.icon_pokemon6,
            R.drawable.icon_pokemon7
        )
        val randomNum = Random.nextInt(0..6)
        val image = findViewById<ImageView>(R.id.logoImageView)
        image.setImageResource(imageList[randomNum])
    }

}