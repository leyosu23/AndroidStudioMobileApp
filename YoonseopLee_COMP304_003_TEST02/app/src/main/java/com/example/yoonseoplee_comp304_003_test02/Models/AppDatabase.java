package com.example.yoonseoplee_comp304_003_test02.Models;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class, Program.class, Course.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract StudentDao studentDao();
    public abstract ProgramDao programDao();
    public abstract CourseDao courseDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "course-database")
                            .fallbackToDestructiveMigration()
                            .createFromAsset("databases/course-database")
                            .build();
        }
        return INSTANCE;
    }
}
