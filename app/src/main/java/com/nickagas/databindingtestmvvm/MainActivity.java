package com.nickagas.databindingtestmvvm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recv);

        ArrayList<SimpleObject> objects=new ArrayList<>();

        for(int i=0;i<10;i++){
            SimpleObject simpleObject=new SimpleObject();
            simpleObject.name="Nikolaras";
            simpleObject.setAge(i);
            objects.add(simpleObject);

        }

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        SimpleObjectAdapter mAdapter=new SimpleObjectAdapter(objects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);


    }
}
