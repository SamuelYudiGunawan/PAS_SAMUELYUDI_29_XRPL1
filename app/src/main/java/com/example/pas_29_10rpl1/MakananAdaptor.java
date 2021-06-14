package com.example.pas_29_10rpl1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MakananAdaptor extends RecyclerView.Adapter<MakananAdaptor.MakananViewHolder> {
    private List<Model> data;

    public MakananAdaptor(List<Model> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MakananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view,parent,false);
        return new MakananViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MakananViewHolder holder, int position) {
        holder.gambar.setImageResource(data.get(position).getGambar());
        holder.judul.setText(data.get(position).getJudul());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MakananViewHolder extends RecyclerView.ViewHolder{
        private ImageView gambar;
        private TextView judul;

        public MakananViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.gambar);
            judul = itemView.findViewById(R.id.title);
            itemView.setOnCreateContextMenuListener((menu, v, menuInfo) -> {
                menu.add(R.menu.context_menu, R.id.delete , 1 , "Delete").setOnMenuItemClickListener(item -> {
                    data.remove(getAdapterPosition());
                    notifyDataSetChanged();
                    return false;
                });
            });
        }
    }
}
