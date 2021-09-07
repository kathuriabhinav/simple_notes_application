package com.example.notesapp.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notesapp.Model.Notes;
import com.example.notesapp.Repository.NotesRepository;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {

    public NotesRepository repository;
    public LiveData<List<Notes>> getallNotes;
    public LiveData<List<Notes>> getallNoteshightolow;
    public LiveData<List<Notes>> getallNoteslowtohigh;

    public NotesViewModel(Application application) {
        super(application);
        repository = new NotesRepository(application);
        getallNotes = repository.getallNotes;
        getallNoteshightolow = repository.getallNoteshightolow;
        getallNoteslowtohigh = repository.getallNoteslowtohigh;
    }

    public void insertNote(Notes notes){
        repository.insertNotes(notes);
    }

    public void deleteNote(int id){
        repository.deleteNotes(id);
    }

    public void updateNote(Notes notes){
        repository.updateNotes(notes);
    }
}