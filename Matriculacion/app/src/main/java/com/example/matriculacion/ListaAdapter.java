package com.example.matriculacion;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matriculacion.data.ListaAsignatura;
import com.example.matriculacion.editlista.ListaViewHolder;

import java.util.List;

public class ListaAdapter extends RecyclerView.Adapter<ListaViewHolder> {

    private List<ListaAsignatura> mListaAsiganturas;

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ListaViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder holder, int position) {
        ListaAsignatura item = mListaAsiganturas.get(position);
        holder.bind(item);
    }
    @Override
    public int getItemCount() {
        return mListaAsiganturas == null ? 0 : mListaAsiganturas.size();
    }
    public void setItems(List<ListaAsignatura> items){
        mListaAsiganturas = items;
        notifyDataSetChanged();
    }
}
