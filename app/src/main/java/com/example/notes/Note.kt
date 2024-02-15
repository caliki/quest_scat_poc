package com.example.notes // Replace with your package name

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Assuming Note is a data class with a single String property
data class Note(val text: String)

class NotesAdapter(private val notesList: List<Note>, private val onNoteLongClick: (Int) -> Unit) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    // Provide a reference to the views for each data item
    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val noteTextView: TextView = view.findViewById(R.id.noteTextView)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the contents of the view with that element
        val note = notesList[position]
        holder.noteTextView.text = note.text
        holder.itemView.setOnLongClickListener {
            onNoteLongClick(position)
            true
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = notesList.size
}