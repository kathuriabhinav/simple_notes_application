package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notesapp.Model.Notes;
import com.example.notesapp.ViewModel.NotesViewModel;
import com.example.notesapp.databinding.ActivityUpdateNoteBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Date;

public class UpdateNoteActivity extends AppCompatActivity {

    ActivityUpdateNoteBinding binding;
    String ppriority ="1";
    NotesViewModel notesViewModel;
    String stitle, ssubtitle, snotes, spriority;
    int iid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        iid = getIntent().getIntExtra("id",0);
        stitle = getIntent().getStringExtra("title");
        ssubtitle = getIntent().getStringExtra("subtitle");
        spriority = getIntent().getStringExtra("priority");
        snotes = getIntent().getStringExtra("notes_data");

        binding.upTitle.setText(stitle);
        binding.upSubtitle.setText(ssubtitle);
        binding.upNotes.setText(snotes);

        if(spriority.equals("1")){
            binding.upGreenPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.upYellowPriority.setImageResource(0);
            binding.upRedPriority.setImageResource(0);
        }
        else if(spriority.equals("2")){
            binding.upGreenPriority.setImageResource(0);
            binding.upYellowPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.upRedPriority.setImageResource(0);
        }
        else if(spriority.equals("3")){
            binding.upGreenPriority.setImageResource(0);
            binding.upYellowPriority.setImageResource(0);
            binding.upRedPriority.setImageResource(R.drawable.ic_baseline_done_24);
        }

        binding.upGreenPriority.setOnClickListener(view -> {
            binding.upGreenPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.upYellowPriority.setImageResource(0);
            binding.upRedPriority.setImageResource(0);
            ppriority ="1";
        });
        binding.upYellowPriority.setOnClickListener(view -> {
            binding.upGreenPriority.setImageResource(0);
            binding.upYellowPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.upRedPriority.setImageResource(0);
            ppriority ="2";
        });
        binding.upRedPriority.setOnClickListener(view -> {
            binding.upGreenPriority.setImageResource(0);
            binding.upYellowPriority.setImageResource(0);
            binding.upRedPriority.setImageResource(R.drawable.ic_baseline_done_24);
            ppriority ="3";
        });

        binding.UpdateNotesButton.setOnClickListener(view -> {
            String title = binding.upTitle.getText().toString();
            String subtitle = binding.upSubtitle.getText().toString();
            String note = binding.upNotes.getText().toString();
            UpdateNote(title,subtitle,note);
        });

    }

    private void UpdateNote(String title, String subtitle, String note) {

        Date date = new Date();
        CharSequence sequence = DateFormat.format("MMMM d, yyyy", date.getTime());
        Notes note1 = new Notes();

        note1.notes_title = title;
        note1.notes_subtitle = subtitle;
        note1.note =note;
        note1.id = iid;
        note1.notes_priority = ppriority;
        note1.notes_date =sequence.toString();

        notesViewModel.updateNote(note1);

        Toast.makeText(this, "Notes updated successfully", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, NoteDisplay.class);
        intent.putExtra("id",iid);
        intent.putExtra("title", title);
        intent.putExtra("subtitle", subtitle);
        intent.putExtra("priority", ppriority);
        intent.putExtra("notes_data", note);
        this.startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.delete_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.ic_delete)
        {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(UpdateNoteActivity.this);
            View view = LayoutInflater.from(UpdateNoteActivity.this).
                    inflate(R.layout.delete_bottom_sheet, (LinearLayout) findViewById(R.id.bottom_sheet));

            bottomSheetDialog.setContentView(view);

            TextView yes, no;
            yes = view.findViewById(R.id.delete_yes);
            no = view.findViewById(R.id.delete_no);


            yes.setOnClickListener(view1 -> {
                notesViewModel.deleteNote(iid);
                finish();
            });

            no.setOnClickListener(view1 -> {
                bottomSheetDialog.dismiss();
            });

            bottomSheetDialog.show();
        }
        return true;
    }
}