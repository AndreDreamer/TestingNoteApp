package com.example.testingnoteapp.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.testingnoteapp.model.Note;
import com.example.testingnoteapp.repository.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository noteRepository;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
    }

    public List<Note> getAllNotes() {
        return noteRepository.getAllNotes();
    }

    public void addNote(Note note) {
        noteRepository.addNote(note);
    }

    public Note getNoteById(int id) {
        return noteRepository.getNoteById(id);
    }

    public void updateNote(Note note) {
        noteRepository.updateNote(note);
    }

    public void deleteNoteById(int id) {
        noteRepository.deleteNoteById(id);
    }
}