package com.esdut.roombasic1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Word.class},version = 5,exportSchema = false)
public abstract class WordDataBase extends RoomDatabase {
    private static WordDataBase INSTANCE;
    //保证不会冲突 syn↓ 排队机制
    static synchronized WordDataBase getDataBase(Context context) {
        if(INSTANCE == null) {
            //返回应用程序根节点的contex
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),WordDataBase.class,"word_datanase")
//                    .allowMainThreadQueries()  允许在主线程运行
                    .fallbackToDestructiveMigration()
//                    .addMigrations(MIGRATION_2_3)
                    .build();
        }
        return INSTANCE;
    }
    public abstract WordDao getWordDao();
    static final Migration MIGRATION_2_3 = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("alter table word ADD COLUMN bar_data INTEGER NOT NULL DEFAULT 1 ");
        }
    };

}
