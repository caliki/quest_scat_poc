package com.example.notes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Assuming you have already created a Note data class and NotesAdapter class

class MainActivity : AppCompatActivity() {

    // Initialize an empty list of notes
    private val notesList = ArrayList<Note>()

    // Initialize the adapter with the empty list
    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewNotes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the adapter and attach it to the RecyclerView
        notesAdapter = NotesAdapter(notesList) { position ->
            notesList.removeAt(position)
            notesAdapter.notifyDataSetChanged()
        }
        recyclerView.adapter = notesAdapter

        // Set up the button click listener to add a new note
        val buttonAddNote = findViewById<Button>(R.id.buttonAddNote)
        val editTextNote = findViewById<EditText>(R.id.editTextNote)
        buttonAddNote.setOnClickListener {
            val noteText = editTextNote.text.toString()
            if (noteText.isNotEmpty()) {
                // Create a new Note object and add it to the list
                val note = Note(noteText)
                notesList.add(note)

                // Notify the adapter that a new item has been added
                notesAdapter.notifyItemInserted(notesList.size - 1)

                // Clear the EditText for the next entry
                editTextNote.text.clear()
            }
        }
    }

    // Optionally, you can also handle the long click listener here or inside the adapter
    // depending on how you want to structure your code.
}