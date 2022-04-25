package com.example.praktikum8;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewBukuActivity extends AppCompatActivity {

    private EditText mEditJudulView, mEditPenulisView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        mEditJudulView = findViewById(R.id.Bet_Judul);
        mEditPenulisView = findViewById(R.id.Bet_Penulis);

        final Button button = findViewById(R.id.Bbt_Simpan);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditJudulView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String judul = mEditJudulView.getText().toString();
                String penulis = mEditPenulisView.getText().toString();

                replyIntent.putExtra("judul", judul);
                replyIntent.putExtra("penulis", penulis);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}
