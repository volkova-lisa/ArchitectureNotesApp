package quizapp.volkova.notesapp.screen.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import quizapp.volkova.notesapp.R
import quizapp.volkova.notesapp.databinding.FragmentMainBinding
import quizapp.volkova.notesapp.models.NoteBody
import quizapp.volkova.notesapp.utils.APP_ACTIVITY
import quizapp.volkova.notesapp.utils.Preference

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: MainFragmentViewModel

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mainAdapter: MainAdapter
    private lateinit var mObserverList: Observer<List<NoteBody>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialisation()
    }

    private fun initialisation() {
        setHasOptionsMenu(true)
        mainAdapter = MainAdapter()
        mRecyclerView = mBinding.notesList
        mRecyclerView.adapter = mainAdapter
        mObserverList = Observer {
            val list = it.asReversed()
            mainAdapter.setList(list)
        }
        mViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        mViewModel.allNotes.observe(this, mObserverList)
        mBinding.addNoteBtn.setOnClickListener{
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_createNoteFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mViewModel.allNotes.removeObserver(mObserverList)
        mRecyclerView.adapter = null
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.exit_btn -> {
                mViewModel.signOut()
                Preference.setInitUser(false)
                APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_startFragment)

            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object{
        fun click(note:NoteBody){
            val bundle = Bundle()
            bundle.putSerializable("note", note)
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_insideNoteFragment, bundle)
        }
    }
}