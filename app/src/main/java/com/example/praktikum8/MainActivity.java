package com.example.praktikum8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static final int NEW_BUKU_ACTIVITY_REQUEST_CODE = 1;

    private BukuViewModel mBukuViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final BukuListAdapter adapter = new BukuListAdapter(new BukuListAdapter.BukuDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mBukuViewModel = new ViewModelProvider(this).get(BukuViewModel.class);

        mBukuViewModel.getAllBuku().observe(this, buku -> {
            adapter.submitList(buku);
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewBukuActivity.class);
            startActivityForResult(intent, NEW_BUKU_ACTIVITY_REQUEST_CODE);
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_BUKU_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Buku buku = new Buku(data.getStringExtra("judul"), data.getStringExtra("penulis"));
            mBukuViewModel.insert(buku);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}