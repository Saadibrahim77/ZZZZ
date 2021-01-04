package com.example.assignmnet4;


import androidx.room.Embedded;
import androidx.room.Relation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Emp_Dept implements Serializable {
   public String F_Name;
   public String L_Name;
   public String Dept_name;
   public String Phone;
   public String Address;
   public String Email;

   public Emp_Dept() {
   }

   public Emp_Dept(String f_Name, String l_Name, String dept_name, String phone, String address, String email) {
      F_Name = f_Name;
      L_Name = l_Name;
      Dept_name = dept_name;
      Phone = phone;
      Address = address;
      Email = email;
   }

   public String getF_Name() {
      return F_Name;
   }

   public void setF_Name(String f_Name) {
      F_Name = f_Name;
   }

   public String getL_Name() {
      return L_Name;
   }

   public void setL_Name(String l_Name) {
      L_Name = l_Name;
   }

   public String getDept_name() {
      return Dept_name;
   }

   public void setDept_name(String dept_name) {
      Dept_name = dept_name;
   }

   public String getPhone() {
      return Phone;
   }

   public void setPhone(String phone) {
      Phone = phone;
   }

   public String getAddress() {
      return Address;
   }

   public void setAddress(String address) {
      Address = address;
   }

   public String getEmail() {
      return Email;
   }

   public void setEmail(String email) {
      Email = email;
   }
}
