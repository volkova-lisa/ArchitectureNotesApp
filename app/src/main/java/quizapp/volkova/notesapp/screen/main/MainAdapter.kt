package quizapp.volkova.notesapp.screen.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_item.view.*
import quizapp.volkova.notesapp.R
import quizapp.volkova.notesapp.models.NoteBody

class MainAdapter:RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var mListOfNotes = emptyList<NoteBody>()

    class MainHolder(view: View) : RecyclerView.ViewHolder(view){
        val noteName: TextView = view.note_name_item
        val noteText: TextView = view.note_text_item
    }

    override fun onViewAttachedToWindow(holder: MainHolder) {
       holder.itemView.setOnClickListener{
           MainFragment.click(mListOfNotes[holder.adapterPosition])
       }
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.noteName.text = mListOfNotes[position].name
        holder.noteText.text = mListOfNotes[position].text
    }

    override fun getItemCount(): Int = mListOfNotes.size

    fun setList(list : List<NoteBody>) {
        mListOfNotes = list
        notifyDataSetChanged()
    }
}