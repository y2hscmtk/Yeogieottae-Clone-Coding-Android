package com.example.myapplication

import LikedTab1Fragment
import LikedTab2Fragment
import LikedTab3Fragment
import LikedTab4Fragment
import ViewPager2Adapter
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_liked.view.*
import kotlinx.android.synthetic.main.fragment_liked_tab1.view.*

class LikedFragment : Fragment(R.layout.fragment_liked) {
    lateinit var binding: View

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

        //binding = ActivityMainBinding.inflate(layoutInflater)
        Log.d(TAG,"LikedFragment - onCreateView() called")

        binding = inflater.inflate(R.layout.fragment_liked,container,false)

        initViewPager()

        //fragment_home.xml과 연결을 하기 위해
        //val view = inflater.inflate(R.layout.fragment_liked,container,false)

        //리턴한것을 xml로 삼음
        return binding
    }

    //스와이프 뷰를 사용하기 위함
    //국내숙소, 해외숙소, 공간대여, 레저.티켓의 프레그먼트를 스와이프를 통해 교환
    private fun initViewPager() {
        //ViewPager2 Adapter 셋팅
        //체크포인트 => fragmentActivity와 fragment의 차이 연구
        var viewPager2Adatper = ViewPager2Adapter(this.requireActivity())
        //교체할 프래그먼트
        viewPager2Adatper.addFragment(LikedTab1Fragment())
        viewPager2Adatper.addFragment(LikedTab2Fragment())
        viewPager2Adatper.addFragment(LikedTab3Fragment())
        viewPager2Adatper.addFragment(LikedTab4Fragment())


        //Adapter 연결
        binding.likedViewPager.apply {
            adapter = viewPager2Adatper

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

        //ViewPager, TabLayout 연결
        TabLayoutMediator(binding.tlNavigationView, binding.likedViewPager) { tab, position ->
            Log.e("YMC", "ViewPager position: ${position}")
            when (position) {
                0 -> tab.text = "국내숙소"
                1 -> tab.text = "해외숙소"
                2 -> tab.text = "공간대여"
                3 -> tab.text = "래저,티켓"
            }
        }.attach()
    }
}