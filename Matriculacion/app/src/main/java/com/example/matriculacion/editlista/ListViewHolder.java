package com.example.matriculacion.editlista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matriculacion.R;
import com.example.matriculacion.data.ListaAlumno;
import com.example.matriculacion.data.ListaAsignatura;

public class ListViewHolder extends RecyclerView.ViewHolder {

    private final TextView mNameText;

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        mNameText = itemView.findViewById(R.id.name);
    }

    public void bind(ListaAlumno item) {

        mNameText.setText(item.getName() + item.getApellidos());

    }
    public void bind2(ListaAsignatura item) {

        mNameText.setText(item.getNombre());
    }

    public static ListViewHolder create(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shopping_list_item, parent, false);
        return new ListViewHolder(v);
    }
}
