package com.example.basic_ch01_bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText:EditText = findViewById(R.id.heightEditText)
        val weightEditText = findViewById<EditText>(R.id.weightEditText)
        val resultButton = findViewById<Button>(R.id.resultButton)

        resultButton.setOnClickListener {
            Log.d("MainActivity","ResultButton이 클릭되었습니다.")

            // EditText에 아무 값도 없을 경우 에러 발생하여 앱 종료 -> if문으로 확인해야한다.
            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty()) {
                Toast.makeText(this,"빈 값이 존재합니다.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener   // setOnclickListener 함수를 탈출한다
            }

            val height: Int = heightEditText.text.toString().toInt()
            val weight: Int = weightEditText.text.toString().toInt()

            Log.d("MainActivity","Height : $height , Weight : $weight")

            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)

            startActivity(intent)

        }

    }
}



/*

Ch01-2
setContentView : 뒤에 있는 레이아웃을 가져와서 뷰로 설정하겠다.
if문에서 return에 대해 공부하기










 */