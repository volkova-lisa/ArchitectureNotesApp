package quizapp.volkova.notesapp.note

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import quizapp.volkova.notesapp.R
import quizapp.volkova.notesapp.databinding.FragmentInsideNoteBinding
import quizapp.volkova.notesapp.models.NoteBody
import quizapp.volkova.notesapp.utils.APP_ACTIVITY

class InsideNoteFragment : Fragment() {

    private var _binding: FragmentInsideNoteBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModelInside: InsideNoteFragmentViewModel
    private lateinit var mCurrentNote: NoteBody

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInsideNoteBinding.inflate(layoutInflater, container, false)
        mCurrentNote = arguments?.getSerializable("note") as NoteBody
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialisation()
    }

    private fun initialisation() {
        setHasOptionsMenu(true)
        mBinding.noteText.text = mCurrentNote.text
        mBinding.noteName.text = mCurrentNote.name
        mViewModelInside = ViewModelProvider(this).get(InsideNoteFragmentViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.note_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.delete_btn -> {
                mViewModelInside.delete(mCurrentNote){
                    APP_ACTIVITY.navController.navigate(R.id.action_insideNoteFragment_to_mainFragment)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}