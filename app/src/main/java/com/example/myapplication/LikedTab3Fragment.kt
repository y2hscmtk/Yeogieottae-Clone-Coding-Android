import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentLikedTab1Binding
import com.example.myapplication.databinding.FragmentLikedTab3Binding

//공간대여
class LikedTab3Fragment : Fragment() {
    private var _binding: FragmentLikedTab3Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        _binding = FragmentLikedTab3Binding.inflate(inflater, container, false)
        return binding.root
    }

}