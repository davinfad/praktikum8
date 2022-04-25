package com.example.praktikum8;

import android.content.Intent;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class BukuListAdapter extends ListAdapter<Buku, BukuViewHolder> {

    public BukuListAdapter(@NonNull DiffUtil.ItemCallback<Buku> diffCallback) {
        super(diffCallback);
    }

    @Override
    public BukuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BukuViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(BukuViewHolder holder, int position) {
        Buku current = getItem(position);
        holder.judul(current.getJudul());
        holder.penulis(current.getPenulis());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(BukuViewHolder.mContext, UpDel.class);
            intent.putExtra("posisisi", position);
        });
    }

    static class BukuDiff extends DiffUtil.ItemCallback<Buku> {

        @Override
        public boolean areItemsTheSame(@NonNull Buku oldItem, @NonNull Buku newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Buku oldItem, @NonNull Buku newItem) {
            return oldItem.getJudul().equals(newItem.getJudul());
        }
    }
}
