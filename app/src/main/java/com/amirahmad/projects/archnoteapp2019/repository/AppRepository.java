package com.amirahmad.projects.archnoteapp2019.repository;

import com.amirahmad.projects.archnoteapp2019.model.NoteEntity;
import com.amirahmad.projects.archnoteapp2019.utilities.SampleData;

import java.util.List;

/**
 * Created by Amirahmad Adibi.
 * ArchNoteApp2019 | Copyrights 2019-07-19.
 */
public class AppRepository {
    private static final AppRepository ourInstance = new AppRepository();
    public List<NoteEntity> noteEntityList;

    public static AppRepository getInstance() {
        return ourInstance;
    }

    private AppRepository() {
        noteEntityList = SampleData.getNotes();
    }
}
