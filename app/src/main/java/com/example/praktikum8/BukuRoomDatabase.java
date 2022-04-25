package com.example.praktikum8;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Buku.class}, version = 1, exportSchema = false)
abstract class BukuRoomDatabase extends RoomDatabase {

    abstract com.example.praktikum8.BukuDao bukuDao();

    private static volatile BukuRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static BukuRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BukuRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BukuRoomDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {

                com.example.praktikum8.BukuDao dao = INSTANCE.bukuDao();
                dao.deleteAll();

                Buku buku = new Buku("Harry Potter and The Prisoners of Azkaban", "JK. Rowling");
                dao.insert(buku);
                buku = new Buku("Harry Potter and The Goblet of Fire", "JK. Rowling");
                dao.insert(buku);
            });
        }
    };
}
