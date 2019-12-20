package com.example.mvvmretrofitrxjavadatabindingglide.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmretrofitrxjavadatabindingglide.R;
import com.example.mvvmretrofitrxjavadatabindingglide.view.model.DataClass;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context context ;
    ArrayList<DataClass> dataClassArrayList;

    public RecyclerAdapter(Context context, ArrayList<DataClass> dataClassArrayList) {
        this.context = context;
        this.dataClassArrayList = dataClassArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataClass dataClass = dataClassArrayList.get(position);
        holder.tv_post_id.setText(dataClass.getPostId());
        holder.id.setText(dataClass.getId());
        holder.name.setText(dataClass.getName());
        holder.email.setText(dataClass.getEmail());
        holder.body.setText(dataClass.getText());


    }

    @Override
    public int getItemCount() {
        return dataClassArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_post_id;
        TextView id,name,email,body;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_post_id = itemView.findViewById(R.id.post_id);
            id = itemView.findViewById(R.id._id);
            name = itemView.findViewById(R.id.tv_name);
            email = itemView.findViewById(R.id.tv_email);
            body = itemView.findViewById(R.id.tv_body);
        }
    }
}
