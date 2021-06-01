package com.example.yoonseoplee_comp304_003_test02.Models;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("select * from Student")
    LiveData<List<Student>> getAllStudents();

    @Query("select * from Student where studentId = :studentId")
    Student getStudentById(int studentId);

    @Insert
    void insert(Student student);

    @Update
    void update(Student student);

    @Delete
    void delete(Student student);

}
