package com.amirahmad.projects.archnoteapp2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.amirahmad.projects.archnoteapp2019.model.NoteEntity;
import com.amirahmad.projects.archnoteapp2019.ui.NotesAdapter;
import com.amirahmad.projects.archnoteapp2019.utilities.SampleData;

import java.util.ArrayList;
import java.util.List;
//import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbarNotes;
    RecyclerView recyclerViewNotes;
    List<NoteEntity> noteEntityList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbarNotes = findViewById(R.id.toolbarNotes);
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        setSupportActionBar(toolbarNotes);
        noteEntityList = SampleData.getNotes();
        recyclerViewNotes.setHasFixedSize(true);
        NotesAdapter notesAdapter = new NotesAdapter(noteEntityList);
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
                Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}
