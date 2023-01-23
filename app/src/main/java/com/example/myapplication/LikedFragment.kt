package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class LikedFragment : Fragment(R.layout.fragment_liked) {

    companion object {
        const val TAG : String = "로그"

        //외부 접근용
        fun newInstance() : LikedFragment {
            return LikedFragment()
        }
    }

    //메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "LikedFragment - oncreate() called")
    }

    // 프래그먼트를 안고 있는 엑티비티에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    //Activity의 onCreate의 역할
    //뷰가 생성되었을때
    //프래그먼트와 레이아웃을 연결해주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        Log.d(TAG,"LikedFragment - onCreateView() called")

        //fragment_home.xml과 연결을 하기 위해
        val view = inflater.inflate(R.layout.fragment_liked,container,false)

        return view
    }

    //스와이프 뷰를 사용하기 위함
    //국내숙소, 해외숙소, 공간대여, 레저.티켓의 프레그먼트를 스와이프를 통해 교환
    private fun initViewPager() {
        //ViewPager2 Adapter 셋팅
        var viewPager2Adatper = ViewPager2Adapter(this)
        viewPager2Adatper.addFragment(Tab1Fragment())
        viewPager2Adatper.addFragment(Tab2Fragment())
        viewPager2Adatper.addFragment(Tab3Fragment())

        //Adapter 연결
        binding.vpViewpagerMain.apply {
            adapter = viewPager2Adatper

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

        //ViewPager, TabLayout 연결
        TabLayoutMediator(binding.tlNavigationView, binding.vpViewpagerMain) { tab, position ->
            Log.e("YMC", "ViewPager position: ${position}")
            when (position) {
                0 -> tab.text = "Tab1"
                1 -> tab.text = "Tab2"
                2 -> tab.text = "Tab3"
            }
        }.attach()
    }
}