package com.amirahmad.projects.archnoteapp2019.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.amirahmad.projects.archnoteapp2019.model.NoteEntity;
import com.amirahmad.projects.archnoteapp2019.utilities.SampleData;

import java.util.List;

/**
 * Created by Amirahmad Adibi.
 * ArchNoteApp2019 | Copyrights 2019-07-19.
 */
public class MainViewModel extends AndroidViewModel {
    public List<NoteEntity> noteEntityList = SampleData.getNotes();
    public MainViewModel(@NonNull Application application) {
        super(application);
    }
}
