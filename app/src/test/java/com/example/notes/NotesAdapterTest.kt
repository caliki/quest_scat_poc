package com.example.notes

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class NotesAdapterTest {

    private lateinit var notesAdapter: NotesAdapter
    private lateinit var notesList: MutableList<Note>

    @Before
    fun setup() {
        notesList = mutableListOf()
        notesAdapter = NotesAdapter(notesList) { }
    }

    @Test
    fun itemCount_ReturnsCorrectSize() {
        notesList.add(Note("Test 1"))
        notesList.add(Note("Test 2"))
        assertEquals(2, notesAdapter.itemCount)
    }
}