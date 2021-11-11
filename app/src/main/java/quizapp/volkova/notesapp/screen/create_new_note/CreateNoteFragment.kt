package quizapp.volkova.notesapp.screen.create_new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import quizapp.volkova.notesapp.MyFirebaseMessagingService
import quizapp.volkova.notesapp.R
import quizapp.volkova.notesapp.databinding.FragmentCreateNoteBinding
import quizapp.volkova.notesapp.models.NoteBody
import quizapp.volkova.notesapp.utils.APP_ACTIVITY
import quizapp.volkova.notesapp.utils.showToast

class CreateNoteFragment : Fragment() {

    private var _binding: FragmentCreateNoteBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: CreateNoteFragmentViewModel
    private lateinit var mMyFirebaseMessagingService: MyFirebaseMessagingService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreateNoteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialisation()
    }

    private fun initialisation() {
        mViewModel = ViewModelProvider(this).get(CreateNoteFragmentViewModel::class.java)
        mMyFirebaseMessagingService = MyFirebaseMessagingService()
        mBinding.addNoteBtn.setOnClickListener {
            val name = mBinding.noteTitleInput.text.toString()
            val text = mBinding.noteTextInput.text.toString()
            if(name.isEmpty()){
                showToast(getString(R.string.enter_title_toast))
            } else {
                mViewModel.insertNote(NoteBody(name = name, text = text)){
                    APP_ACTIVITY.navController.navigate(R.id.action_createNoteFragment_to_mainFragment)
                }
            }
            mMyFirebaseMessagingService.showNotification(context, "New Note Created", name)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}