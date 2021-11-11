package quizapp.volkova.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import quizapp.volkova.notesapp.databinding.ActivityMainBinding
import quizapp.volkova.notesapp.utils.APP_ACTIVITY
import quizapp.volkova.notesapp.utils.Preference

class MainActivity : AppCompatActivity() {

    lateinit var mToolbar: Toolbar
    lateinit var navController: NavController
    private var _binding: ActivityMainBinding? = null
    val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        //чтобы получать контекст в любом месте приложения
        APP_ACTIVITY = this

        mToolbar= mBinding.toolbar
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setSupportActionBar(mToolbar)

        title = getString(R.string.title)

        Preference.getPreference(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        //это нужно чтобы избежать утечки памяти!! запомнить*
        _binding = null
    }
}