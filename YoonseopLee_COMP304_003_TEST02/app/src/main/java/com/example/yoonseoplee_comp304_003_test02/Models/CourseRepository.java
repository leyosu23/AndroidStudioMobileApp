package com.example.yoonseoplee_comp304_003_test02.Models;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class CourseRepository {

    private CourseDao courseDao;

    public CourseRepository(Context context) {
        AppDatabase db = AppDatabase.getAppDatabase(context);
        courseDao = db.courseDao();
    }

    public void insert(final Course course) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                courseDao.insert(course);
            }
        }).start();
    }

    public void update(final Course course) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                courseDao.update(course);
            }
        }).start();
    }

    public void delete(final Course course) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                courseDao.delete(course);
            }
        }).start();
    }

    public List<Course> getAllCourses() {
        try {
            return new getAllCoursesAsync().execute().get();
        } catch (Exception ex) {
            Log.e("Error: ", ex.getMessage());
        }
        return null;
    }

    private class getAllCoursesAsync extends AsyncTask<Void, Void, List<Course>> {
        @Override
        protected List<Course> doInBackground(Void... voids) {
            try {
                return courseDao.getAllCourses();
            } catch (Exception ex) {
                Log.e("Error: ", ex.getMessage());
            }
            return null;
        }
    }

    public Course getCourseById(int courseId) {

        try {
            return new getCourseByIdAsync().execute(courseId).get();
        } catch (Exception ex) {
            Log.e("Error: ", ex.getMessage());
        }
        return null;
    }

    private class getCourseByIdAsync extends AsyncTask<Integer, Void, Course> {
        @Override
        protected Course doInBackground(Integer... params) {
            try {
                return courseDao.getCourseById(params[0]);
            } catch (Exception ex) {
                Log.e("Error: ", ex.getMessage());
            }
            return null;
        }
    }

    public List<Course> getCoursesByProgramId(int programId) {
        try {
            return new getCoursesByProgramIdAsync().execute(programId).get();
        } catch (Exception ex) {
            Log.e("Error: ", ex.getMessage());
        }
        return null;
    }

    private class getCoursesByProgramIdAsync extends AsyncTask<Integer, Void, List<Course>> {
        @Override
        protected List<Course> doInBackground(Integer... params) {
            try {
                return courseDao.getCoursesByProgramId(params[0]);
            } catch (Exception ex) {
                Log.e("Error: ", ex.getMessage());
            }
            return null;
        }
    }

}