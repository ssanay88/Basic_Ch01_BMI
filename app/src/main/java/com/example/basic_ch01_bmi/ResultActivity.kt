package com.example.basic_ch01_bmi

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity: AppCompatActivity() {

    // 엑티비티가 시작될 때 호출되는 함수
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "height : $height , weight : $weight")

        // bmi :  (몸무게) / (신장)^2[m단위]
        val bmi = weight / (height.toDouble() / 100).pow(2.0)
        val resultText = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상 체중"
            else -> "저체중"
        }

        val resultValue = findViewById<TextView>(R.id.BmiValue)
        val resultMessage = findViewById<TextView>(R.id.ResultMessage)

        resultValue.text = bmi.toString()
        resultMessage.text = resultText

    }

}