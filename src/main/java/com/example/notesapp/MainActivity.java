package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.notesapp.Adapter.NotesAdapter;
import com.example.notesapp.Model.Notes;
import com.example.notesapp.ViewModel.NotesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton NewNotesButton;
    NotesViewModel notesViewModel;
    RecyclerView notesRecycler;
    NotesAdapter adapter;

    TextView nofilter, hightolow, lowtohigh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NewNotesButton = findViewById(R.id.NewNotesButton);
        notesRecycler = findViewById(R.id.notesRecycler);

        nofilter = findViewById(R.id.nofilter);
        hightolow = findViewById(R.id.hightolow);
        lowtohigh = findViewById(R.id.lowtohigh);

        nofilter.setBackgroundResource(R.drawable.filter_selected_shape);

        nofilter.setOnClickListener(view -> {
            loaddata(0);
            nofilter.setBackgroundResource(R.drawable.filter_selected_shape);
            hightolow.setBackgroundResource(R.drawable.filter_un_shape);
            lowtohigh.setBackgroundResource(R.drawable.filter_un_shape);
        });

        hightolow.setOnClickListener(view -> {
            loaddata(1);
            hightolow.setBackgroundResource(R.drawable.filter_selected_shape);
            nofilter.setBackgroundResource(R.drawable.filter_un_shape);
            lowtohigh.setBackgroundResource(R.drawable.filter_un_shape);
        });

        lowtohigh.setOnClickListener(view -> {
            loaddata(2);
            lowtohigh.setBackgroundResource(R.drawable.filter_selected_shape);
            hightolow.setBackgroundResource(R.drawable.filter_un_shape);
            nofilter.setBackgroundResource(R.drawable.filter_un_shape);
        });

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);
        NewNotesButton.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, InsertNoteActivity.class));
        });
        notesViewModel.getallNotes.observe(this, new Observer<List<Notes>>() {
            @Override
            public void onChanged(List<Notes> notes) {
                setAdapter(notes);
            }
        });
    }

    private void loaddata(int i) {
        if(i==0) {
            notesViewModel.getallNotes.observe(this, new Observer<List<Notes>>() {
                @Override
                public void onChanged(List<Notes> notes) {
                    setAdapter(notes);
                }
            });
        }else if(i==1) {
            notesViewModel.getallNoteshightolow.observe(this, new Observer<List<Notes>>() {
                @Override
                public void onChanged(List<Notes> notes) {
                    setAdapter(notes);
                }
            });
        }else if(i==2){
            notesViewModel.getallNoteslowtohigh.observe(this, new Observer<List<Notes>>() {
                @Override
                public void onChanged(List<Notes> notes) {
                    setAdapter(notes);
                }
            });
        }
    }

    private void setAdapter(List<Notes> notes) {
        notesRecycler.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new NotesAdapter(MainActivity.this, notes);
        notesRecycler.setAdapter(adapter);
    }
}