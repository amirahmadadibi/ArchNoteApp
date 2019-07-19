package com.amirahmad.projects.archnoteapp2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.amirahmad.projects.archnoteapp2019.model.NoteEntity;
import com.amirahmad.projects.archnoteapp2019.ui.NotesAdapter;
import com.amirahmad.projects.archnoteapp2019.utilities.SampleData;
import com.amirahmad.projects.archnoteapp2019.viewmodel.MainViewModel;

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
        mainViewModel  = ViewModelProviders.of(this).get(MainViewModel.class);
        initViews();

    }

    private void initViews() {
        toolbarNotes = findViewById(R.id.toolbarNotes);
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        setSupportActionBar(toolbarNotes);
        noteEntityList = SampleData.getNotes();
        recyclerViewNotes.setHasFixedSize(true);
        notesAdapter = new NotesAdapter(noteEntityList);
        recyclerViewNotes.setAdapter(notesAdapter);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
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
                noteEntityList.addAll(SampleData.getNotes());
                notesAdapter.notifyDataSetChanged();
                break;
            case R.id.actionRemoveAllItems:
                noteEntityList.removeAll(noteEntityList);
                notesAdapter.notifyDataSetChanged();
                break;
            default:
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}
