package com.example.yoonseoplee_comp304_003_test02.Models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProgramDao {

    @Query("select * from Program")
    List<Program> getAllPrograms();

    @Query("select * from Program where programId = :programId")
    Program getProgramById(int programId);

    @Insert
    void insert(Program program);

    @Update
    void update(Program program);

    @Delete
    void delete(Program program);

}
