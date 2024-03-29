package com.example.labs.fragments.read

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.labs.R
import com.example.labs.data.entities.Note

class NoteListAdapter(
    //private val onNoteClick: (Note) -> Unit,
    private val onNoteUpdate: (Note) -> Unit,
    private val onNoteDelete: (Note) -> Unit
) : RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {

    private var notes = emptyList<Note>()

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTitle: TextView = itemView.findViewById(R.id.noteTitle)
        val noteDescription: TextView = itemView.findViewById(R.id.noteDescription)
        val noteDate: TextView = itemView.findViewById(R.id.noteDate)
        val buttonUpdate: Button = itemView.findViewById(R.id.updateButton)
        val buttonDelete: Button = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = notes[position]
        holder.noteTitle.text = currentNote.title
        holder.noteDescription.text = currentNote.description
        holder.noteDate.text = currentNote.data.toString()
        //holder.itemView.setOnClickListener { onNoteClick(currentNote) }
        holder.buttonUpdate.setOnClickListener { onNoteUpdate(currentNote) }
        holder.buttonDelete.setOnClickListener { onNoteDelete(currentNote) }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

}