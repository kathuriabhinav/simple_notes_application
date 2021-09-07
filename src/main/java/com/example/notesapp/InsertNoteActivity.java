package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Toast;

import com.example.notesapp.Model.Notes;
import com.example.notesapp.ViewModel.NotesViewModel;
import com.example.notesapp.databinding.ActivityInsertNoteBinding;

import java.util.Date;

public class InsertNoteActivity extends AppCompatActivity {

    ActivityInsertNoteBinding binding;
    String title,subtitle,note;
    NotesViewModel notesViewModel;
    String priority="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        binding.upGreenPriority.setOnClickListener(view -> {
            binding.upGreenPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.upYellowPriority.setImageResource(0);
            binding.upRedPriority.setImageResource(0);
            priority="1";
        });
        binding.upYellowPriority.setOnClickListener(view -> {
            binding.upGreenPriority.setImageResource(0);
            binding.upYellowPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.upRedPriority.setImageResource(0);
            priority="2";
        });
        binding.upRedPriority.setOnClickListener(view -> {
            binding.upGreenPriority.setImageResource(0);
            binding.upYellowPriority.setImageResource(0);
            binding.upRedPriority.setImageResource(R.drawable.ic_baseline_done_24);
            priority="3";
        });

        binding.DoneNotesButton.setOnClickListener(view -> {
            title = binding.notestitle.getText().toString();
            subtitle = binding.notessubtitile.getText().toString();
            note = binding.notesdata.getText().toString();
            CreteNote(title,subtitle,note);
        });
    }

    private void CreteNote(String title, String subtitle, String note)
    {
        Date date = new Date();
        CharSequence sequence = DateFormat.format("MMMM d, yyyy", date.getTime());
        Notes notes = new Notes();
        notes.notes_title = title;
        notes.notes_subtitle = subtitle;
        notes.note =note;
        notes.notes_priority =priority;
        notes.notes_date =sequence.toString();
        notesViewModel.insertNote(notes);

        Toast.makeText(this, "Notes created successfully", Toast.LENGTH_SHORT).show();

        finish();
    }
}