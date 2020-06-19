package com.esdut.ciremember;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private LiveData<Word> Aword;
    private String Chinese,English;
    private LiveData<List<Word>>allWordsLive;
    private WordDao wordDao;
    public WordRepository(Context context) {
//        WordDataBase wordDataBase = WordDataBase.getDataBase(application);
        WordDataBase wordDataBase = WordDataBase.getDataBase(context.getApplicationContext());
        wordDao = wordDataBase.getWordDao();
        allWordsLive = wordDao.getAllWordsLive();
    }

    public LiveData<List<Word>> getAllWordsLive() {
        return allWordsLive;
    }

    void insertWords(Word... words) {
        new InsertAsynTask(wordDao).execute(words);
    }
    void updateWords(Word... words) {
        new UpdateAsynTask(wordDao).execute(words);
    }
    void deleteWords(Word... words) {
        new DeleteAsynTask(wordDao).execute(words);
    }
    void clearWords() {
        new DeleteAllAsynTask(wordDao).execute();
    }
    LiveData<List<Word>> findWordsWithPatten(String patten) {
        return wordDao.findWordsWithPatten("%" + patten + "%");
    }
    void updateAword(String...strings) {
        new UpdateAAsynTask(wordDao).execute(strings);
    }
    /**
     * 我在测试
     * 引入了AsyncTask 后台执行
     */
    static class DeleteAllAsynTask extends AsyncTask<Void,Void,Void> {
        private WordDao wordDao;

        public DeleteAllAsynTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteALLWords();
            return null;
        }
    }

    static class DeleteAsynTask extends AsyncTask<Word,Void,Void> {
        private WordDao wordDao;

        public DeleteAsynTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.deleteWords(words);
            return null;
        }
    }

    static class UpdateAAsynTask extends AsyncTask<String,String,Void> {
        private WordDao wordDao;

        public UpdateAAsynTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

//        @Override
//        protected Void doInBackground(String Chinese,String English) {
//            wordDao.updateAword(Chinese,English);
//            return null;
//        }


        @Override
        protected Void doInBackground(String... strings) {
            wordDao.updateAword(strings[0],strings[1]);
            return null;
        }
    }

    static class UpdateAsynTask extends AsyncTask<Word,Void,Void> {
        private WordDao wordDao;

        public UpdateAsynTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.updataWords(words);
            return null;
        }
    }

    static class InsertAsynTask extends AsyncTask<Word,Void,Void> {
        private  WordDao wordDao;

        public InsertAsynTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insertWords(words);
            return null;
        }

        /**
         * 任务完成时使用
         * @param aVoid
         */
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        /**
         *
         * @param values
         */
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }
}
