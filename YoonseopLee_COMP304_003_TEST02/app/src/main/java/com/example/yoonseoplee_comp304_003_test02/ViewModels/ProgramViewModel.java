package com.example.yoonseoplee_comp304_003_test02.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.yoonseoplee_comp304_003_test02.Models.Program;
import com.example.yoonseoplee_comp304_003_test02.Models.ProgramRepository;

import java.util.List;

public class ProgramViewModel extends AndroidViewModel {
    private ProgramRepository programRepository;

    public ProgramViewModel(@NonNull Application application) {
        super(application);
        this.programRepository = new ProgramRepository(application);
    }

    public void insert(Program program) {
        programRepository.insert(program);
    }

    public void update(Program program) {
        programRepository.update(program);
    }

    public void delete(Program program) {
        programRepository.delete(program);
    }

    public List<Program> allPrograms() {
        return programRepository.getAllPrograms();
    }

    public Program getProgramById(int programId) {
        return programRepository.getProgramById(programId);
    }

}
