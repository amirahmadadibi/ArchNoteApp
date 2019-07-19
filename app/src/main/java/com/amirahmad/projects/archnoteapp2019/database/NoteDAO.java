package com.amirahmad.projects.archnoteapp2019.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.amirahmad.projects.archnoteapp2019.model.NoteEntity;

import java.util.List;

/**
 * Created by Amirahmad Adibi.
 * ArchNoteApp2019 | Copyrights 2019-07-17.
 */

@Dao
public interface NoteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(NoteEntity noteEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<NoteEntity> noteEntities);

    @Delete
    void deleteNote(NoteEntity noteEntity);


    @Query("select * from notes where id=:id")
    NoteEntity getNoteById(int id);

    @Query("select * from notes order by date desc")
    LiveData<List<NoteEntity>> getAllNotes();

    @Query("delete from notes")
    int deleteAll();

    @Query("select count(*) from notes")
    int getCount();

}
