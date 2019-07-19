package com.amirahmad.projects.archnoteapp2019.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.amirahmad.projects.archnoteapp2019.model.NoteEntity;

/**
 * Created by Amirahmad Adibi.
 * ArchNoteApp2019 | Copyrights 2019-07-17.
 */


@Database(entities = {NoteEntity.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_Name = "NoteDatabase.db";

    private static volatile AppDatabase instance;
    private static final Object LOCK = new Object();
    //for each dao
    public abstract NoteDAO noteDao();
    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,DATABASE_Name).build();
                }
            }
        }
        return instance;
    }
}
