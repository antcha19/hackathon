package com.example.matriculacion.editlista;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matriculacion.data.ListaAsignatura;

import java.util.List;

public class ListAdapterAsig extends RecyclerView.Adapter<ListViewHolder> {


      private List<ListaAsignatura> mListaAsignaturas;

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ListViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

           ListaAsignatura itemasig= mListaAsignaturas.get(position);

          holder.bind2(itemasig);
    }

    @Override
    public int getItemCount() {

        return mListaAsignaturas == null ? 0 : mListaAsignaturas.size();
    }
      public void setItemsAsig(List<ListaAsignatura> items) {
        mListaAsignaturas = items;
        notifyDataSetChanged();
    }
}