package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val homeFragment = HomeFragment()
    val searchFragment = SearchFragment()
    val navigationFragment = NavigationFragment()
    val likedFragment = LikedFragment()
    val myPageFragment = MyPageFragment()

    companion object{
        const val TAG: String = "로그"
    }

    //메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //프래그먼트가 담겨져있는곳은 activity이므로 view는 activity로
        setContentView(R.layout.activity_main)
        //시작 프래그먼트를 home으로 설정
        replaceFragment(homeFragment)
                
        Log.d(TAG, "MainActivity - onCreate() called")

        //프래그먼트 변경을 위하여
        btm_nav.setOnItemSelectedListener { MenuItem ->
            when (MenuItem.itemId) {
                R.id.tab_home -> replaceFragment(homeFragment)
                R.id.tab_search -> replaceFragment(searchFragment)
                R.id.tab_navigation -> replaceFragment(navigationFragment)
                R.id.tab_liked -> replaceFragment(likedFragment)
                R.id.tab_myPage -> replaceFragment(myPageFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment) {
        Log.d("MainActivity","${fragment}")
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fragments_frame,fragment)
                commit()
            }
    }

}