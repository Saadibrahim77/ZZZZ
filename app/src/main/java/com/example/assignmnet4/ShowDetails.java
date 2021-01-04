package com.example.assignmnet4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        TextView name = findViewById(R.id.txt_name);
        TextView add = findViewById(R.id.txt_add);
        TextView phone = findViewById(R.id.txt_phone);
        TextView email = findViewById(R.id.txt_email);
        TextView dept = findViewById(R.id.txt_Dept);

        Emp_Dept empDept = (Emp_Dept) getIntent().getSerializableExtra("Selected_Emp");
        name.setText(empDept.F_Name + " "+ empDept.L_Name);
        add.setText(empDept.Address);
        phone.setText(empDept.Phone);
        email.setText(empDept.Email);
        dept.setText(empDept.Dept_name);


    }
}