package com.amirahmad.projects.archnoteapp2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.amirahmad.projects.archnoteapp2019.model.NoteEntity;
import com.amirahmad.projects.archnoteapp2019.ui.NotesAdapter;
import com.amirahmad.projects.archnoteapp2019.viewmodel.MainViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    Toolbar toolbarNotes;
    RecyclerView recyclerViewNotes;
    NotesAdapter notesAdapter;
    List<NoteEntity> noteEntityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        FloatingActionButton floatingActionButton = findViewById(R.id.fabButtonAddNewNote);
        floatingActionButton.setOnClickListener(v -> {

        });
    }

    private void initViews() {
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        toolbarNotes = findViewById(R.id.toolbarNotes);
        setSupportActionBar(toolbarNotes);
        notesAdapter = new NotesAdapter(noteEntityList);
        recyclerViewNotes.setAdapter(notesAdapter);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));


        final Observer<List<NoteEntity>> notesObserver = noteEntities -> {
            noteEntityList.clear();
            noteEntityList.addAll(noteEntities);
            notesAdapter.notifyDataSetChanged();
        };

        mainViewModel.noteEntityList.observe(this, notesObserver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionAddItem:
                addSampleData();
                break;
            case R.id.actionRemoveAllItems:
               deleteAllNotes();
                break;
            default:
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }

    private void deleteAllNotes() {
        mainViewModel.deleteAllNotes();
    }

    private void addSampleData() {
        mainViewModel.addSampleData();
    }
}
