package com.example.yoonseoplee_comp304_003_test02.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.yoonseoplee_comp304_003_test02.Models.Course;
import com.example.yoonseoplee_comp304_003_test02.Models.CourseRepository;

import java.util.List;

public class CourseViewModel extends AndroidViewModel {

    private CourseRepository courseRepository;

    public CourseViewModel(@NonNull Application application) {
        super(application);
        this.courseRepository = new CourseRepository(application);
    }

    public void insert(Course course) {
        courseRepository.insert(course);
    }

    public void update(Course course) {
        courseRepository.update(course);
    }

    public void delete(Course course) {
        courseRepository.delete(course);
    }

    public List<Course> allCourses() {
        return courseRepository.getAllCourses();
    }

    public Course getCourseById(int courseId) {
        return courseRepository.getCourseById(courseId);
    }

    public List<Course> getCoursesByProgramId(int programId) {
        return courseRepository.getCoursesByProgramId(programId);
    }

}