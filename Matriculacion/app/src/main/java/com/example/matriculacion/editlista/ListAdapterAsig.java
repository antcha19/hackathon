package com.example.matriculacion.editlista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matriculacion.R;
import com.example.matriculacion.data.ListaAsignatura;

import java.util.List;

public class ListAdapterAsig extends RecyclerView.Adapter<ListAdapterAsig.ListViewHolderAsig> {


      private List<ListaAsignatura> mListaAsignaturas;
    private ItemListener itemListener;


    @NonNull
    @Override
    public ListViewHolderAsig onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolderAsig(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_asignatura,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolderAsig holder, int position) {

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
    public void setItemListener(ItemListener listener) {
        itemListener = listener;
    }

    public interface ItemListener{
        void onClick(ListaAsignatura listaAsignatura);
        void onDeleteIconClicked(ListaAsignatura listaAsignatura);
        void onClickUpdate(ListaAsignatura listaAsignatura);
    }
    public  class ListViewHolderAsig extends RecyclerView.ViewHolder {

        private final TextView mNameText;
        private final ImageView botonborrar;
        private final ImageView botoneditar;

        public ListViewHolderAsig(@NonNull View itemView) {
            super(itemView);
            mNameText = itemView.findViewById(R.id.name_asignatura);
            botonborrar= itemView.findViewById(R.id.itemborrarasig);
            botoneditar= itemView.findViewById(R.id.itemeditasig);

            botonborrar.setOnClickListener(this::eventosasig);
            botoneditar.setOnClickListener(this::eventosasig);
        }

        public void eventosasig(View view){
            if (itemListener!=null){
                ListaAsignatura clickasig = mListaAsignaturas.get(getAdapterPosition());

                //manejo los eventos del click
                if (view.getId()== R.id.itemborrarasig){
                    itemListener.onDeleteIconClicked(clickasig);
                    return;
                }
                if (view.getId()==R.id.itemeditasig){
                    itemListener.onClickUpdate(clickasig);
                }
                itemListener.onClick(clickasig);
            }

        }


        public void bind2(ListaAsignatura item) {

            mNameText.setText( item.getCodigo()+ " "+item.getNombre());
        }




    }


}