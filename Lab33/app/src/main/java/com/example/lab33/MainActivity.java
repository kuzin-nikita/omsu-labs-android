package com.example.lab33;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CustomRecyclerAdapter(fillList()));
    }

    private List<String> fillList(){
        List<String> output = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            output.add("element " + i);
        }
        return Arrays.asList(this.getResources().getStringArray(R.array.cat_names));
    }
}