package com.example.notesapp.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.MainActivity;
import com.example.notesapp.Model.Notes;
import com.example.notesapp.NoteDisplay;
import com.example.notesapp.R;
import com.example.notesapp.UpdateNoteActivity;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.notesViewHolder> {

    MainActivity mainActivity;
    List<Notes> notes;
    public NotesAdapter(MainActivity mainActivity, List<Notes> notes) {
        this.mainActivity = mainActivity;
        this.notes = notes;
    }

    @Override
    public notesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new notesViewHolder(LayoutInflater.from(mainActivity).inflate(R.layout.item_notes, parent, false));
    }

    @Override
    public void onBindViewHolder(NotesAdapter.notesViewHolder holder, int position) {

        Notes note = notes.get(position);

        if(note.notes_priority.equals("1")){
            holder.notesPriority.setBackgroundResource(R.drawable.green_shape);
        }else if(note.notes_priority.equals("2")){
            holder.notesPriority.setBackgroundResource(R.drawable.yellow_shape);
        }else if(note.notes_priority.equals("3")){
            holder.notesPriority.setBackgroundResource(R.drawable.red_shape);
        }

        holder.notesTitle.setText(note.notes_title);
        holder.notesSubtitle.setText(note.notes_subtitle);
        holder.notesDate.setText(note.notes_date);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(mainActivity, NoteDisplay.class);
            intent.putExtra("id",note.id);
            intent.putExtra("title", note.notes_title);
            intent.putExtra("subtitle", note.notes_subtitle);
            intent.putExtra("priority", note.notes_priority);
            intent.putExtra("notes_data", note.note);
            mainActivity.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class notesViewHolder extends RecyclerView.ViewHolder {

        TextView notesTitle, notesSubtitle, notesDate;
        View notesPriority;

        public notesViewHolder(View itemView) {
            super(itemView);
            notesTitle = itemView.findViewById(R.id.notesTitle);
            notesSubtitle = itemView.findViewById(R.id.notesSubtitle);
            notesDate = itemView.findViewById(R.id.notesDate);
            notesPriority = itemView.findViewById(R.id.notesPriority);
        }
    }
}