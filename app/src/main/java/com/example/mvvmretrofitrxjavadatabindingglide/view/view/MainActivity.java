package com.example.mvvmretrofitrxjavadatabindingglide.view.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvvmretrofitrxjavadatabindingglide.R;
import com.example.mvvmretrofitrxjavadatabindingglide.view.adapter.RecyclerAdapter;
import com.example.mvvmretrofitrxjavadatabindingglide.view.model.DataClass;
import com.example.mvvmretrofitrxjavadatabindingglide.view.viewmodel.CommentsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<DataClass> arrayList = new ArrayList<>();
    RecyclerAdapter recyclerAdapter;
    CommentsViewModel commentsViewModel;

    EditText editText;
    Button button;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                commentsViewModel = ViewModelProviders.of(MainActivity.this).get(CommentsViewModel.class);

                commentsViewModel.init(editText.getText().toString());

                commentsViewModel.getCommentsRepository().observe(MainActivity.this, new Observer<List<DataClass>>() {
                    @Override
                    public void onChanged(List<DataClass> dataClasses) {

                        List<DataClass> dataClassList = dataClasses;
                        if(databaseList().length == 0){
                            dataClassList = dataClasses;
                        } else {
                            dataClassList.clear();
                            dataClassList = dataClasses;
                        }
                        arrayList.addAll(dataClassList);
                        Log.d("!!!arraylist",String.valueOf(dataClasses.size()));
                        for(int i = 0 ; i < dataClasses.size() ; i++){
                            arrayList.add(new DataClass(dataClasses.get(1).getPostId(),dataClasses.get(i).getId(),dataClasses.get(i).getName(),
                                    dataClasses.get(i).getEmail(),dataClasses.get(i).getText()));
                        }
                        recyclerView.setAdapter(new RecyclerAdapter(MainActivity.this,arrayList));
                    }

                });


            }
        });



    }
}
