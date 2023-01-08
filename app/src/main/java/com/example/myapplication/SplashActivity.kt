package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

/*
Handler의 목적은 특정 시간동안 SplashActivity 화면을 보여주도록 하기 위해서 필요
Splash 화면을 2초동안 보여준 뒤 MainActivitiy로 이동하게 구현
Splash 화면은 앱 처음 시작에 딱 1번만 보여지는 화면이므로 화면전환후 finish()를 해줘야 함
 */


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Handler를 더이상 사용할수 없음 => Looper를 import해야함?
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        },DURATION)
    }
    companion object {
        private const val DURATION : Long = 1500
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}