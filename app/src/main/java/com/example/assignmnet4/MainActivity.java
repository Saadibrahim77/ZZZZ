package com.example.assignmnet4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    EditText E_Name;
    private static final String TAG = "MainActivity";
    RoomDP database;
    RecyclerView rec;
    ArrayList<Emp_Dept> list;
    ArrayList<Emp_Dept> AllUsers;
    DataEntires entires;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AllUsers = new ArrayList<>();
        entires = new DataEntires();
        E_Name = findViewById(R.id.E_Name);
        rec = findViewById(R.id.Rcy);
        rec.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rec.hasFixedSize();
        list = new ArrayList<>();
        adapter = new MyAdapter(this,list);
        rec.setAdapter(adapter);
        database = RoomDP.GetInstance(this);

        Add_Dept(); //User data
        Add_Employee(); //Department Data

        GetAllUsers();

        E_Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
             ShowList(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }


    public void GetAllUsers() {



        database.employeeDao().AllUsers()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Emp_Dept>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<Emp_Dept> emp_depts) {
                        Log.d(TAG, "onSuccess: "+emp_depts.size());
                        if(emp_depts.size()!=0){
                            for(int i=0;i<emp_depts.size();i++){
                            AllUsers.add(emp_depts.get(i)) ;
                            }

                            //Toast.makeText(MainActivity.this, emp_depts.size()+"", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });

    }
    public void ShowList(CharSequence s){

        if(!TextUtils.isEmpty(s)) {

            list.clear();
            for(int i=0;i<AllUsers.size();i++){
                if(AllUsers.get(i).F_Name.toLowerCase().startsWith(String.valueOf(s).toLowerCase())){
                    list.add(AllUsers.get(i));

                }
            }
            adapter.renewData(list);

        }
        else{
            //Toast.makeText(this, "ssasasa", Toast.LENGTH_SHORT).show();

                    for(int i=0;i<AllUsers.size();i++){
                            list.add(AllUsers.get(i));
                    }
                    Log.d(TAG, "ShowList1: "+AllUsers.size());
                    Log.d(TAG, "ShowList: "+list.size());
                    adapter.renewData(list);

                }
        }




    public void btn_Search(View view) {

     ShowList("");

    }

    public void Add_Employee() {

        for (Employee employee : entires.Add_Employees()) {
            database.employeeDao().Add_Employee(employee)
                    .subscribeOn(Schedulers.computation())
                    .subscribe(new CompletableObserver() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onComplete() {
                            //Toast.makeText(MainActivity.this, "here", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "onComplete: Added");

                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }
                    });

        }
    }

        public void Add_Dept()
    {
            for (Department department:entires.Add_Dept()) {
                database.employeeDao().Add_Dept(department)
                        .subscribeOn(Schedulers.computation())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onComplete() {
                                Log.d(TAG, "onComplete: Added1");

                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }
                        });

            }

    }
    public void btn_ShowD(View view) {
        database.employeeDao().GetDept()
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.io())
                .subscribe(new SingleObserver<List<Department>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<Department> departments) {

                        for (Department department:departments) {

                            Log.d(TAG, "onSuccessDepartments: "+department.Dept_name+" "+department.DP_ID);

                        }


                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });

    }

    public void btn_ShowE(View view) {

        database.employeeDao().GetEmp()
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.io())
                .subscribe(new SingleObserver<List<Employee>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<Employee> employees) {
                        Log.d(TAG, "Listsize: "+employees.size());

                        for (Employee E:employees) {
                            Log.d(TAG, "onSuccessEmployees: "+E.E_ID+" "+E.F_Name+" "+E.L_Name +" "+E.DP_ID);

                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });

    }





}