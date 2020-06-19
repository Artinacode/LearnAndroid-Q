package com.esdut.ciremember;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao //Database access object
public interface WordDao {
    @Insert
    void insertWords(Word... words);

    @Update
    void updataWords(Word... words);

    @Query("update WORD set chinese_meaning =:value where english_word=:english")
    void updateAword(String value, String english);

    @Delete
    void deleteWords(Word... words);

    @Query("DELETE FROM WORD")
    void deleteALLWords();

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
    LiveData<List<Word>> getAllWordsLive();

    @Query("SELECT * FROM WORD WHERE english_word LIKE :patten ORDER BY ID DESC")
    LiveData<List<Word>> findWordsWithPatten(String patten);

}
