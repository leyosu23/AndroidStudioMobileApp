package com.example.yoonseoplee_comp304_003_test02.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity= Program.class,
        parentColumns="programId",
        childColumns = "programId"),


        @ForeignKey(entity= Student.class,
                parentColumns="studentId",
                childColumns = "studentId")
},
        indices={@Index("programId"),@Index("studentId")})

public class Course {

    @PrimaryKey(autoGenerate = true)
    private int courseId;

    @ColumnInfo
    private String courseName, professor, department;
    private int duration, studentId, programId;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCourseName() { return courseName; }

    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getProfessor() { return professor; }

    public void setProfessor(String professor) { this.professor = professor; }

    public String getDepartment() { return department; }

    public void setDepartment(String department) { this.department = department; }

    public void setDuration(int duration) { this.duration = duration; }

    public int getDuration() { return duration; }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

}