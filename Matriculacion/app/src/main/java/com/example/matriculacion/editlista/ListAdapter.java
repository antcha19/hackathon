package com.example.matriculacion.editlista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matriculacion.R;
import com.example.matriculacion.data.ListaAlumno;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<ListaAlumno> mListaAlumnos;
    private ItemListener itemListener;


    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListAdapter.ListViewHolder(LayoutInflater.from(
                parent.getContext())
                .inflate(R.layout.list_item_alumno,parent,false)
        );
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
    public void setItemListenerAlumno(ListAdapter.ItemListener listener) {

        itemListener = listener;
    }
    public interface ItemListener{
        void onClick(ListaAlumno listaAlumno);
        void onDeleteIconClicked(ListaAlumno listaAlumno);
        void UpdateIconClick(ListaAlumno listaAlumno);
    }
    public  class ListViewHolder extends RecyclerView.ViewHolder {

        private final TextView mNameText;
        private final ImageView botonborrar;
        private final ImageView botonupdate;
      //  private final ImageView btndetalle;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            mNameText = itemView.findViewById(R.id.name);
            botonborrar = itemView.findViewById(R.id.borraritemalum);
            botonupdate = itemView.findViewById(R.id.updateitemalum);

            //escuchar el item de borrar
            botonborrar.setOnClickListener(this::eventos);
            botonupdate.setOnClickListener(this::eventos);

        }

        public void bind(ListaAlumno item) {

           // mNameText.setText(item.getId()+" "+item.getName() +" "+ item.getApellidos());
                mNameText.setText(item.getName()+" "+item.getApellidos()+"\n"+item.getId());
        }

        public void eventos(View view){
            if (itemListener!=null){
                ListaAlumno click = mListaAlumnos.get(getAdapterPosition());

                if (view.getId()==R.id.borraritemalum){
                    itemListener.onDeleteIconClicked(click);
                    return;
                }
                if(view.getId()==R.id.updateitemalum){
                    itemListener.UpdateIconClick(click);
                }
                itemListener.onClick(click);
            }
        }

    }


}
