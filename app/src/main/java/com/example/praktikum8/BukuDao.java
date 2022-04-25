package com.example.praktikum8;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BukuDao {
    @Query("SELECT * FROM buku_table ORDER BY judul ASC")
    LiveData<List<Buku>> getAlphabetizedWords();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Buku buku);

    @Query("DELETE FROM buku_table")
    void deleteAll();
}
