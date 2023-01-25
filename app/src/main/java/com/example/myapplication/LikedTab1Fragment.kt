import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentLikedTab1Binding
import kotlinx.android.synthetic.main.fragment_liked_tab1.view.*

//참고한사이트
//https://minchanyoun.tistory.com/126

//국내숙소 fragment
class LikedTab1Fragment : Fragment() {
    private var _binding: FragmentLikedTab1Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        _binding = FragmentLikedTab1Binding.inflate(inflater, container, false)

//        //접근 테스트용
//        binding.korea.setOnClickListener(){
//            it.korea.setText("test")
//        }

//        binding.textView.setOnClickListener(){
//        }

        return binding.root
    }

}