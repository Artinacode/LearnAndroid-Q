package com.esdut.ciremember;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class WordViewModel extends AndroidViewModel {
//    private WordDao wordDao;
    private WordRepository wordRepository;
//    private LiveData<List<Word>>allWordsLive;
    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
    }

    public LiveData<List<Word>> getAllWordsLive() {
        return wordRepository.getAllWordsLive();
    }
    LiveData<List<Word>> findWordsWithPatten(String patten) {
        return wordRepository.findWordsWithPatten(patten);
    }
    void insertWords(Word... words) {
        wordRepository.insertWords(words);
    }
    void updateWords(Word... words) {
        wordRepository.updateWords(words);
    }
    void deleteWords(Word... words) {
        wordRepository.deleteWords(words);
    }
    void clearWords() {
        wordRepository.clearWords();
    }
    void updateAWord(String... strings) {
        wordRepository.updateAword(strings);
    }


}
