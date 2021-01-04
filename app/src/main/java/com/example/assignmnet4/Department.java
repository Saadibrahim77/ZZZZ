package com.example.assignmnet4;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Department {

    @PrimaryKey(autoGenerate = true)
    public int DP_ID;

    public Department(String dept_name) {
        Dept_name = dept_name;
    }

    public int getD_ID() {
        return DP_ID;
    }

    public String getDept_name() {
        return Dept_name;
    }

    public void setD_ID(int d_ID) {
        DP_ID = d_ID;
    }

    public  Department(){}
    public void setDept_name(String dept_name) {
        Dept_name = dept_name;
    }

    public String Dept_name;
}
