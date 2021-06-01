package com.example.yoonseoplee_comp304_003_test02.Models;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentRepository {

    private StudentDao studentDao;
    private LiveData<List<Student>> allStudents;

    public StudentRepository(Context context) {
        AppDatabase db = AppDatabase.getAppDatabase(context);
        studentDao = db.studentDao();
        allStudents = studentDao.getAllStudents();
    }

    public void insert(final Student student) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                studentDao.insert(student);
            }
        }).start();
    }

    public void update(final Student student) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                studentDao.update(student);
            }
        }).start();
    }

    public void delete(final Student student) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                studentDao.delete(student);
            }
        }).start();
    }

    public LiveData<List<Student>> allStudents() {
        return allStudents;
    }

    public Student getStudentById(int studentId) {
        try {
            return new getStudentByIdAsync().execute(studentId).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private class getStudentByIdAsync extends AsyncTask<Integer, Void, Student> {
        @Override
        protected Student doInBackground(Integer... params) {
            try {
                return studentDao.getStudentById(params[0]);
            } catch (Exception ex) {
                Log.e("Error: ", ex.getMessage());
            }
            return null;
        }
    }

}
