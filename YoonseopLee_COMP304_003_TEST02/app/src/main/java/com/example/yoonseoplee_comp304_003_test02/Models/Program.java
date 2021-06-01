package com.example.yoonseoplee_comp304_003_test02.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity=Student.class,
                parentColumns="studentId",
                childColumns = "studentId")
},
        indices={@Index("studentId")})

public class Program {

    @PrimaryKey(autoGenerate = true)
    private int programId;

    @ColumnInfo
    private String programName, department;

    @ColumnInfo
    private int duration, tuition, studentId;

    public int getProgramId() { return programId; }

    public void setProgramId(int programId) { this.programId = programId; }

    public String getProgramName() { return programName; }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) { this.duration = duration; }

    public String getDepartment() {  return department; }

    public void setDepartment(String department) { this.department = department; }

    public int getTuition() { return tuition; }

    public void setTuition(int tuition) {
        this.tuition = tuition;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int stdId) {
        this.studentId = stdId;
    }

    @Override
    public String toString() {
        return "Program {" +
                "programId=" + programId +
                ", programName='" + programName + '\'' +
                ", duration='" + duration + '\'' +
                ", department=" + department + '\'' +
                ", tuition='" + tuition + '\'' +
                ", studentId=" + studentId +
                "}";
    }
}
