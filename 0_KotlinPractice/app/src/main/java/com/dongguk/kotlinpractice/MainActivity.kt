package com.dongguk.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // SAM
        // Single Abstract Method
        // 인터페이스 객체를 람다로 넣을 수 잇음
        // 함수형 인터페이스는 추상클래스가 하나인 것을 뜻함

        val view = View(this)

        // 자바 버전
        // OnClick을 위해 많은 코드가 필요하다
        /* view.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View: View) {
                    //
                }
            }
        ) */
        
        // 코틀린 버전
        // 매우 짧다
        view.setOnClickListener ( { println("안녕") } )
        view.setOnClickListener { println("안녕") }
    }
}