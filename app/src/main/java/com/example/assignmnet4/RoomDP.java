package com.example.assignmnet4;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.jar.Attributes;

@Database(entities = {Employee.class,Department.class,}, version = 1)
public abstract class RoomDP extends  RoomDatabase{

    public static RoomDP instance;
    public abstract Dao_Interface employeeDao();

    public static  synchronized RoomDP GetInstance(Context context){

        if(instance==null){
            instance = Room.databaseBuilder
                    (context.getApplicationContext(),RoomDP.class,"RoomDP")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return  instance;

    }
}