package com.amirahmad.projects.archnoteapp2019.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amirahmad.projects.archnoteapp2019.R;
import com.amirahmad.projects.archnoteapp2019.model.NoteEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * Created by Amirahmad Adibi.
 * ArchNoteApp2019 | Copyrights 2019-07-17.
 */
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {
    private List<NoteEntity> noteEntityList;
    public NotesAdapter(List<NoteEntity> noteEntityList) {
        this.noteEntityList = noteEntityList;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.textViewNoteTitle.setText(noteEntityList.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return noteEntityList.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView textViewNoteTitle;
        FloatingActionButton floatingActionButtonEditNote;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNoteTitle = itemView.findViewById(R.id.textViewNoteTitle);
            floatingActionButtonEditNote = itemView.findViewById(R.id.fabButtonEditNote);
        }
    }
}
