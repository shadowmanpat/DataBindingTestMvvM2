package com.nickagas.databindingtestmvvm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    ArrayList<SimpleObject> objects;
    SimpleObjectAdapter mAdapter;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        realm=Realm.getDefaultInstance();


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
        //recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);


    }

    public void deleteLastObject(View v){
        if(objects.size()>0)
        {
            objects.remove(objects.size()-1);
            mAdapter.notifyDataSetChanged();
        }
    }

    public void saveToRealm(View v)
    {
        final EditText editText=(EditText) findViewById(R.id.editText);
        final EditText editText1=(EditText) findViewById(R.id.editText2);


        Integer.parseInt(editText1.getText().toString());
        // Asynchronously update objects on a background thread
        realm.executeTransactionAsync(new Realm.Transaction() {
                                          @Override
                                          public void execute(Realm bgRealm) {

                                              SimpleObject p = new SimpleObject();
                                              p.setAge( Integer.parseInt(editText1.getText().toString()));
                                              p.setName(editText.getText().toString());
                                          }
                                      }, new Realm.Transaction.OnSuccess() {
                                          @Override
                                          public void onSuccess() {
                                              Log.d("statem", "==========success+++++++++++");
                                          }
                                      }, new Realm.Transaction.OnError() {
                                          @Override
                                          public void onError(Throwable error) {
                                              Log.d("statem", error.getMessage());
                                          }
                                      }
        );
        refresh_views();
    }

    private void refresh_views() {

        ArrayList<SimpleObject> list = new ArrayList(realm.where(SimpleObject.class).findAll());

        mAdapter=new SimpleObjectAdapter(list);
        mAdapter.notifyDataSetChanged();
    }

}
