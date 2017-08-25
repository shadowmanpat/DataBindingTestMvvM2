package com.nickagas.databindingtestmvvm;

/**
 * Created by shado on 25-Aug-17.
 */

public class SimpleObject {
    public String name;
    private int age;

    public String getAge()
    {
        return  String.valueOf(age);
    }
    public void setAge(int age){
        this.age=age;
    }
}
