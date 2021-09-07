package com.example.notesapp.Dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notesapp.Model.Notes;

import java.util.List;

@Dao
public interface NotesDao
{
    @Query("SELECT * FROM notes_database")
    LiveData<List<Notes>> getallNotes();

    @Query("SELECT * FROM notes_database ORDER BY notes_priority DESC")
    LiveData<List<Notes>> getallNoteshightolow();

    @Query("SELECT * FROM notes_database ORDER BY notes_priority ASC")
    LiveData<List<Notes>> getallNoteslowtohigh();

    @Insert
    void insertNotes(Notes... notes);

    @Query("DELETE FROM notes_database WHERE id=:id")
    void  deleteNotes(int id);

    @Update
    void updateNotes(Notes notes);
}
