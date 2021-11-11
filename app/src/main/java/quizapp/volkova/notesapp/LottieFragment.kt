package quizapp.volkova.notesapp

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import quizapp.volkova.notesapp.databinding.FragmentLottieBinding
import quizapp.volkova.notesapp.screen.start.StartFragment
import quizapp.volkova.notesapp.utils.APP_ACTIVITY

class LottieFragment : Fragment() {

        private var _binding: FragmentLottieBinding? = null
        val mBinding get() = _binding!!
        val splashScreenScope = CoroutineScope(Dispatchers.Main)
        private var i = 0
        private val handler = Handler()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentLottieBinding.inflate(layoutInflater, container, false)
            splashScreenScope.launch {
                delay(2500)
                APP_ACTIVITY.navController.navigate(R.id.action_lottieFragment_to_startFragment)
            }
            return mBinding.root
        }


}