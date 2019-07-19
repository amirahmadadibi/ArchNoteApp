package com.amirahmad.projects.archnoteapp2019.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.amirahmad.projects.archnoteapp2019.model.NoteEntity;
import com.amirahmad.projects.archnoteapp2019.repository.AppRepository;

import java.util.List;

/**
 * Created by Amirahmad Adibi.
 * ArchNoteApp2019 | Copyrights 2019-07-19.
 */
public class MainViewModel extends AndroidViewModel {
    public LiveData<List<NoteEntity>> noteEntityList;
    private AppRepository appRepository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        appRepository = AppRepository.getInstance(application.getApplicationContext());
        noteEntityList = appRepository.noteEntityList;
    }

    public void addSampleData() {
        appRepository.addSampleData();
    }

    public void deleteAllNotes() {
        appRepository.deleteAllNotes();
    }
}
