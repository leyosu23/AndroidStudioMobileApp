package com.example.yoonseoplee_comp304_003_test02.Models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CourseDao {

    @Query("select * from Course")
    List<Course> getAllCourses();

    @Query("select * from Course where courseId = :courseId")
    Course getCourseById(int courseId);

    @Query("select * from Course where programId= :programId")
    List<Course> getCoursesByProgramId(int programId);

    @Insert
    void insert(Course course);

    @Update
    void update(Course course);

    @Delete
    void delete(Course course);
}
