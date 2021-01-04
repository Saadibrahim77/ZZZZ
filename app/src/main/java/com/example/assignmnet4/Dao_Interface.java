package com.example.assignmnet4;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao()
public interface Dao_Interface {

    @Insert()
    Completable Add_Dept(Department department);

    @Insert()
    Completable Add_Employee(Employee employee);

    @Query("select * from Department")
    Single<List<Department>>GetDept();



    @Query("select * from Employee")
    Single<List<Employee>>GetEmp();





    @Query("Select Employee.F_Name,Employee.L_Name,Employee.Address,Employee.Phone" +
            ",Employee.Email, Department.Dept_name from Employee,Department where " +
            "Employee.DP_ID=Department.DP_ID")
    Single<List<Emp_Dept>>AllUsers();
}
