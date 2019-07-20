package com.amirahmad.projects.archnoteapp2019.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.amirahmad.projects.archnoteapp2019.model.NoteEntity;
import com.amirahmad.projects.archnoteapp2019.repository.AppRepository;

/**
 * Created by Amirahmad Adibi.
 * ArchNoteApp2019 | Copyrights 2019-07-19.
 */
public class EditorViewModel extends AndroidViewModel {
    //mutable live data has methods that let's you change it's value at runtime. liveData is Immutable
    //after each time that you change it, it's notify all it's observers
    public MutableLiveData<NoteEntity> noteEntityMutableLiveData = new MutableLiveData<>();
    private AppRepository appRepository ;
    public EditorViewModel(@NonNull Application application) {
        super(application);
        appRepository = AppRepository.getInstance(getApplication());
    }



}
