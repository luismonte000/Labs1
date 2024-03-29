package com.example.labs.data.repository

import androidx.lifecycle.LiveData
import com.example.labs.data.entities.Note
import com.example.labs.data.dao.NoteDao

class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    suspend fun update(note: Note) {
        noteDao.update(note)
    }

    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }
}