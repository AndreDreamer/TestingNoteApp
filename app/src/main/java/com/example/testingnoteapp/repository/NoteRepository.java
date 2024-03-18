package com.example.testingnoteapp.repository;

import android.content.Context;

import com.example.testingnoteapp.data.NoteDatabaseHelper;
import com.example.testingnoteapp.model.Note;

import java.util.List;

public class NoteRepository {
    private NoteDatabaseHelper noteDatabaseHelper;

    public NoteRepository(Context context) {
        noteDatabaseHelper = new NoteDatabaseHelper(context);
    }

    public List<Note> getAllNotes() {
        return noteDatabaseHelper.getAllNotes();
    }

    public void addNote(Note note) {
        noteDatabaseHelper.addNote(note);
    }

    public Note getNoteById(int id) {
        return noteDatabaseHelper.getNoteById(id);
    }

    public void updateNote(Note note) {
        noteDatabaseHelper.updateNote(note);
    }

    public void deleteNoteById(int id) {
        noteDatabaseHelper.deleteNoteById(id);
    }
}