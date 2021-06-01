package com.example.yoonseoplee_comp304_003_test02.Models;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class ProgramRepository {

    private ProgramDao programDao;

    public ProgramRepository(Context context) {
        AppDatabase db = AppDatabase.getAppDatabase(context);
        programDao = db.programDao();
    }

    public void insert(final Program program) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                programDao.insert(program);
            }
        }).start();
    }

    public void update(final Program program) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                programDao.update(program);
            }
        }).start();
    }

    public void delete(final Program program) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                programDao.delete(program);
            }
        }).start();
    }

    public List<Program> getAllPrograms() {
        try {
            return new getAllProgramsAsync().execute().get();
        } catch (Exception ex) {
            Log.e("Error: ", ex.getMessage());
        }
        return null;
    }

    private class getAllProgramsAsync extends AsyncTask<Void, Void, List<Program>> {
        @Override
        protected List<Program> doInBackground(Void... voids) {
            try {
                return programDao.getAllPrograms();
            } catch (Exception ex) {
                Log.e("Error: ", ex.getMessage());
            }
            return null;
        }
    }

    public Program getProgramById(int programId) {
        try {
            return new getProgramByIdAsync().execute(programId).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private class getProgramByIdAsync extends AsyncTask<Integer, Void, Program> {
        @Override
        protected Program doInBackground(Integer... params) {
            try {
                return programDao.getProgramById(params[0]);
            } catch (Exception ex) {
                Log.e("Error: ", ex.getMessage());
            }
            return null;
        }
    }

}
