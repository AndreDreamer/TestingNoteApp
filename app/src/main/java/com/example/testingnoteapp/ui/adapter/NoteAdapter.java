package com.example.testingnoteapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.testingnoteapp.R;
import com.example.testingnoteapp.model.Note;

import java.util.List;

public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(Context context, List<Note> notes) {
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Отримуємо об'єкт Note для поточної позиції
        Note note = getItem(position);

        // Перевіряємо, чи існує вже готовий вигляд для перевикористання
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Знаходимо TextView в макеті
        TextView textViewTitle = convertView.findViewById(R.id.textViewTitle);
        TextView textViewDescription = convertView.findViewById(R.id.textViewDescription);

        // Встановлюємо текст для TextView з назвою замітки
        textViewTitle.setText(note.getTitle());
        textViewDescription.setText(note.getDescription());

        // Повертаємо вигляд, щоб він відображався в ListView
        return convertView;
    }
}