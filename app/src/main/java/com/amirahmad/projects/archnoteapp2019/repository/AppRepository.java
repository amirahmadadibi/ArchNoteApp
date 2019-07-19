package com.amirahmad.projects.archnoteapp2019.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.TypeConverters;

import com.amirahmad.projects.archnoteapp2019.database.AppDatabase;
import com.amirahmad.projects.archnoteapp2019.model.NoteEntity;
import com.amirahmad.projects.archnoteapp2019.utilities.SampleData;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Amirahmad Adibi.
 * ArchNoteApp2019 | Copyrights 2019-07-19.
 */
public class AppRepository {
    private static  AppRepository ourInstance;
    public LiveData<List<NoteEntity>> noteEntityList;
    AppDatabase appDatabase;

    //allRoom operations must be done on background thread
    private Executor executors  = Executors.newSingleThreadExecutor();
    public static AppRepository getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new AppRepository(context);
        }
        return ourInstance;
    }

    private AppRepository(Context context) {
        appDatabase = AppDatabase.getInstance(context);
        noteEntityList = getAllNotes();
    }

    public void addSampleData() {
        executors.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.noteDao().insertAll(SampleData.getNotes());
            }
        });
    }

    private LiveData<List<NoteEntity>> getAllNotes(){
        //when ever you retrieve liveData from room does background threading automatically
        return appDatabase.noteDao().getAllNotes();
    }

    public void deleteAllNotes() {
        executors.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.noteDao().deleteAll();
            }
        });
    }
}
