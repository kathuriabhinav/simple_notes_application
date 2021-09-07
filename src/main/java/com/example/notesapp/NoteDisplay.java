package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.notesapp.ViewModel.NotesViewModel;
import com.example.notesapp.databinding.ActivityNoteDisplayBinding;

public class NoteDisplay extends AppCompatActivity {

    String stitle, ssubtitle, snotes, spriority;
    int iid;

    ActivityNoteDisplayBinding binding;
    NotesViewModel notesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteDisplayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        iid = getIntent().getIntExtra("id",0);
        stitle = getIntent().getStringExtra("title");
        ssubtitle = getIntent().getStringExtra("subtitle");
        spriority = getIntent().getStringExtra("priority");
        snotes = getIntent().getStringExtra("notes_data");

        binding.displayTitle.setText(stitle);
        binding.displaySubtitle.setText(ssubtitle);
        binding.displayNotes.setText(snotes);

        if(spriority.equals("1")){
            binding.displayGreenPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.displayYellowPriority.setImageResource(0);
            binding.displayRedPriority.setImageResource(0);
        }
        else if(spriority.equals("2")){
            binding.displayGreenPriority.setImageResource(0);
            binding.displayYellowPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.displayRedPriority.setImageResource(0);
        }
        else if(spriority.equals("3")){
            binding.displayGreenPriority.setImageResource(0);
            binding.displayYellowPriority.setImageResource(0);
            binding.displayRedPriority.setImageResource(R.drawable.ic_baseline_done_24);
        }

        binding.editNotesButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, UpdateNoteActivity.class);
            intent.putExtra("id",iid);
            intent.putExtra("title", stitle);
            intent.putExtra("subtitle", ssubtitle);
            intent.putExtra("priority", spriority);
            intent.putExtra("notes_data", snotes);
            this.startActivity(intent);
            finish();
        });
    }
}