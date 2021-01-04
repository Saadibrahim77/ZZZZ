package com.example.assignmnet4;

import android.content.Context;

import java.util.ArrayList;

public class DataEntires {

    ArrayList<Employee> employees;
    ArrayList<Department> dept;

    public  ArrayList<Employee> Add_Employees() {


        employees = new ArrayList<>();
        employees.add(new Employee("Saad","Ibrahim","Cairo",
                "Saad11@gmail.com","01025301949",1));

        employees.add(new Employee("Ahmed","Ibrahim","Cairo",
                "Ahmed61@gmail.com","01025551949",2));


        employees.add(new Employee("Ahmed","Saad","Cairo",
                "Ahmed51@gmail.com","01077771949",3));


        employees.add(new Employee("Ahmed","Ali","Cairo",
                "Ahmed71@gmail.com","01025301949",1));


        employees.add(new Employee("Ahmed","Ayman","Cairo",
                "Ahmed31@gmail.com","01025301949",1));

        return  employees;

    }

    public  ArrayList<Department>Add_Dept(){
        dept = new ArrayList<>();
        dept.add(new Department("IS"));
        dept.add(new Department("CS"));
        dept.add(new Department("SC"));
        dept.add(new Department("SYS"));
        return dept;

    }

}
