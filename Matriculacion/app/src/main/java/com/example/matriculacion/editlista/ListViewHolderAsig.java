package com.example.matriculacion.editlista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matriculacion.R;
import com.example.matriculacion.data.ListaAsignatura;


public class ListViewHolderAsig extends RecyclerView.ViewHolder {

    private final TextView mNameText;

    public ListViewHolderAsig(@NonNull View itemView) {
        super(itemView);
        mNameText = itemView.findViewById(R.id.name);
    }

    public void bind(ListaAsignatura item) {

        mNameText.setText(item.getCodigo() +" "+ item.getNombre());

    }
    public static ListViewHolderAsig create(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shopping_list_item, parent, false);
        return new ListViewHolderAsig(v);
    }
}
