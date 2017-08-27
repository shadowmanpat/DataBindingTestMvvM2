package com.nickagas.databindingtestmvvm;

import io.realm.RealmObject;

/**
 * Created by shado on 25-Aug-17.
 */

public class SimpleObject extends RealmObject {




    public String name;
    private int age;

    public String getAge()
    {
        return  String.valueOf(age);
    }
    public String getName() {
        return name;
    }
    public void setAge(int age){
        this.age=age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
