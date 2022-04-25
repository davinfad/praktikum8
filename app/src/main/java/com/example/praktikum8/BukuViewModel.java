package com.example.praktikum8;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class BukuViewModel extends AndroidViewModel {
    private BukuRepository mRepository;

    private final LiveData<List<Buku>> mAllBuku;

    public BukuViewModel(Application application) {
        super(application);
        mRepository = new BukuRepository(application);
        mAllBuku = mRepository.getAllBuku();
    }

    LiveData<List<Buku>> getAllBuku() {
        return mAllBuku;
    }

    void insert(Buku buku) {
        mRepository.insert(buku);
    }
}
