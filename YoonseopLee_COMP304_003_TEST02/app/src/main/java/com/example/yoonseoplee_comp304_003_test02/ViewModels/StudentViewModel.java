package com.example.yoonseoplee_comp304_003_test02.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.yoonseoplee_comp304_003_test02.Models.Student;
import com.example.yoonseoplee_comp304_003_test02.Models.StudentRepository;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {

    private StudentRepository studentRepository;
    private LiveData<List<Student>> allStudents;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        this.studentRepository = new StudentRepository(application);
        this.allStudents = studentRepository.allStudents();
    }

    public void insert(Student student) {
        studentRepository.insert(student);
    }

    public void update(Student student) {
        studentRepository.update(student);
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }

    public LiveData<List<Student>> allStudents() {
        return allStudents;
    }

    public Student getStudentById(int studentId) {
        return studentRepository.getStudentById(studentId);
    }

    public boolean checkLogin(int studentId, String password) {

        for (int i = 0; i < allStudents.getValue().size(); i++) {
            if (allStudents.getValue().get(i).getStudentId() == studentId &&
                    allStudents.getValue().get(i).getPassword().equals(password)) {
                return true;

            }
        }
        return false;
    }
}
