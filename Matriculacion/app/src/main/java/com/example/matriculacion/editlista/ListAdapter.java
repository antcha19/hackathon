package com.example.matriculacion.editlista;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matriculacion.data.ListaAlumno;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    private List<ListaAlumno> mListaAlumnos;


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ListViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ListaAlumno item = mListaAlumnos.get(position);

        holder.bind(item);

    }

    @Override
    public int getItemCount() {
        return mListaAlumnos == null ? 0 : mListaAlumnos.size();
    }

    public void setItems(List<ListaAlumno> items) {
        mListaAlumnos = items;
        notifyDataSetChanged();
    }

}
