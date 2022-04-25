package com.example.praktikum8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class BukuViewHolder extends RecyclerView.ViewHolder{
    public static Context mContext;
    private final TextView bukuItemView;
    private final TextView penulisItemView;

    private BukuViewHolder(View itemView) {
        super(itemView);
        bukuItemView = itemView.findViewById(R.id.Itv_JudulBuku);
        penulisItemView = itemView.findViewById(R.id.Itv_Penulis);
    }

    public void judul(String text) {
        bukuItemView.setText(text);
    }
    public void penulis(String text) {
        penulisItemView.setText(text);
    }


    static BukuViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.buku, parent, false);
        return new BukuViewHolder(view);
    }
}
