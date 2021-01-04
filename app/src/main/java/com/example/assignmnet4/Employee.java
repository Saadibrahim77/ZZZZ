package com.example.assignmnet4;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import static androidx.room.ForeignKey.CASCADE;

@Entity
public class Employee {
    @PrimaryKey(autoGenerate = true)
    public int E_ID;

    public String F_Name;
    public String L_Name;
    public String Address;
    public String Email;
    public String Phone;

    public Employee(String f_Name, String l_Name, String address, String email, String phone, int DP_ID) {
        F_Name = f_Name;
        L_Name = l_Name;
        Address = address;
        Email = email;
        Phone = phone;
        this.DP_ID = DP_ID;
    }

    int DP_ID;

    public void setAddress(String address) {
        Address = address;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    public Employee(){

    }


    @ForeignKey(entity = Department.class, parentColumns = "DP_ID" , childColumns ="DP_ID" )

    public int getE_ID() {
        return E_ID;
    }



    public int getDP_ID() {
        return DP_ID;
    }

    public void setE_ID(int e_ID) {
        E_ID = e_ID;
    }

    public String getF_Name() {
        return F_Name;
    }

    public String getL_Name() {
        return L_Name;
    }

    public void setF_Name(String f_Name) {
        F_Name = f_Name;
    }

    public void setL_Name(String l_Name) {
        L_Name = l_Name;
    }

    public void setDP_ID(int DP_ID) {
        this.DP_ID = DP_ID;
    }



}
