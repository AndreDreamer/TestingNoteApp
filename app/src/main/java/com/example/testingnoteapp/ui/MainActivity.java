package com.example.testingnoteapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testingnoteapp.R;
import com.example.testingnoteapp.model.Note;
import com.example.testingnoteapp.repository.NoteRepository;
import com.example.testingnoteapp.ui.adapter.NoteAdapter;

public class MainActivity extends AppCompatActivity {

    private NoteRepository noteRepository;
    private NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteRepository = new NoteRepository(this);

        ListView listView = findViewById(R.id.listView);
        adapter = new NoteAdapter(this, noteRepository.getAllNotes());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Note selectedNote = (Note) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, EditActivity.class);
            intent.putExtra("noteId", selectedNote.getId());
            startActivity(intent);
        });

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, EditActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();
        adapter.addAll(noteRepository.getAllNotes());
    }
}