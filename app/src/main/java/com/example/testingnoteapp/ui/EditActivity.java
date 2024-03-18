package com.example.testingnoteapp.ui;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.testingnoteapp.R;
import com.example.testingnoteapp.model.Note;
import com.example.testingnoteapp.viewmodel.NoteViewModel;

public class EditActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText descriptionEditText;
    private Button saveButton;
    private Button deleteButton;
    private NoteViewModel noteViewModel;
    private Note currentNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        titleEditText = findViewById(R.id.titleEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        saveButton = findViewById(R.id.saveButton);
        deleteButton = findViewById(R.id.deleteButton);

        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        Intent intent = getIntent();
        int noteId = intent.getIntExtra("noteId", -1);

        if (noteId != -1) {
            currentNote = noteViewModel.getNoteById(noteId);
            if (currentNote != null) {
                titleEditText.setText(currentNote.getTitle());
                descriptionEditText.setText(currentNote.getDescription());
            }
        }

        saveButton.setOnClickListener(v -> {
            String title = titleEditText.getText().toString();
            String description = descriptionEditText.getText().toString();

            if (currentNote != null) {
                currentNote.setTitle(title);
                currentNote.setDescription(description);
                noteViewModel.updateNote(currentNote);
            } else {
                Note newNote = new Note(title, description);
                noteViewModel.addNote(newNote);
            }

            finish();
        });

        deleteButton.setOnClickListener(v -> {
            if (currentNote != null) {
                noteViewModel.deleteNoteById(currentNote.getId());
            }
            finish();
        });
    }
}