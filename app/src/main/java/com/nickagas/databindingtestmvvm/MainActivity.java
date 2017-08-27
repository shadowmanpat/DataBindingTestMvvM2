package com.nickagas.databindingtestmvvm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<SimpleObject> objects;
    SimpleObjectAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recv);


         objects=new ArrayList<>();

        for(int i=0;i<10;i++){
            SimpleObject simpleObject=new SimpleObject();
            simpleObject.name="Nikolaras";
            simpleObject.setAge(i);
            objects.add(simpleObject);

        }

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter=new SimpleObjectAdapter(objects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);


    }

    public void deleteLastObject(View v){
        if(objects.size()>0)
        {
            objects.remove(objects.size()-1);
            mAdapter.notifyDataSetChanged();
        }
    }
}
