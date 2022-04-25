package com.example.praktikum8;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BukuRepository {
    private BukuDao mBukuDao;
    private LiveData<List<Buku>> mAllBuku;

    BukuRepository(Application application) {
        BukuRoomDatabase db = BukuRoomDatabase.getDatabase(application);
        mBukuDao = db.bukuDao();
        mAllBuku = mBukuDao.getAlphabetizedWords();
    }

    LiveData<List<Buku>> getAllBuku() {
        return mAllBuku;
    }

    void insert(Buku buku) {
        BukuRoomDatabase.databaseWriteExecutor.execute(() -> {
            mBukuDao.insert(buku);
        });
    }

}