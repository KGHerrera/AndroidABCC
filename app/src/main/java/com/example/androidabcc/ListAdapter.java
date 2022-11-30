package com.example.androidabcc;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import entidades.Alumno;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Alumno> fData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<Alumno> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.fData = itemList;
    }

    @Override
    public int getItemCount(){return fData.size(); }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.lista_elementos, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(fData.get(position));
    }

    public void setItems(List<Alumno> items){ fData = items; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, nombre, direccion, telefono;

        ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idAlumnoTextView);
            nombre = itemView.findViewById(R.id.nombreTextView);
        }

        void bindData(final Alumno item){
            id.setText(String.valueOf(item.getNunControl()));
            nombre.setText(item.getNombre());
        }
    }



}
