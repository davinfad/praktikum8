package com.example.praktikum8;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "buku_table")
public class Buku {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "judul")
    public String mJudul;

    @ColumnInfo(name = "penulis")
    public String mPenulis;

    public Buku(@NonNull String judul, String penulis) {
        this.mJudul = judul;
        this.mPenulis = penulis;
    }

    @NonNull
    public String getJudul() {
        return this.mJudul;
    }

    @NonNull
    public String getPenulis() {
        return this.mPenulis;
    }

}
