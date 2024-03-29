package com.example.labs.data.service

import com.example.labs.data.entities.Note
import com.example.labs.data.repository.NoteRepository

class NoteService(private val noteRepository: NoteRepository) {

    val allNotes = noteRepository.allNotes

    suspend fun insert(note: Note) {
        if (note.description.length > 5) {
            noteRepository.insert(note)
        } else {
            throw IllegalArgumentException("Description must be more than 5 characters")
        }
    }

    suspend fun update(note: Note) {
        if (note.description.length > 5) {
            noteRepository.update(note)
        } else {
            throw IllegalArgumentException("Description must be more than 5 characters")
        }
    }

    suspend fun delete(note: Note) {
        noteRepository.delete(note)
    }



}