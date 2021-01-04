package com.example.assignmnet4;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.holder> {

    ArrayList<Emp_Dept>emp_depts;
    Context context;
    public MyAdapter(Context context,ArrayList<Emp_Dept> emp_depts){
        this.emp_depts = new ArrayList<>(emp_depts);
        this.context =context;
    }
    @NonNull
    @Override
    public MyAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=  LayoutInflater.from(context).inflate(R.layout.mylayout,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.holder holder, int position) {
        holder.textView.setText(emp_depts.get(position).F_Name+" "+emp_depts.get(position).L_Name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ShowDetails.class);
                intent.putExtra("Selected_Emp",emp_depts.get(position));
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return emp_depts.size();
    }

   public void renewData(ArrayList<Emp_Dept> emp_depts){
        this.emp_depts.clear();
        this.emp_depts = new ArrayList<>(emp_depts);
        Log.d("MyAdapter","sizeof"+this.emp_depts.size());
        notifyDataSetChanged();
   }

    class holder extends RecyclerView.ViewHolder{


        TextView textView;
        public holder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView1);
        }
    }

}
