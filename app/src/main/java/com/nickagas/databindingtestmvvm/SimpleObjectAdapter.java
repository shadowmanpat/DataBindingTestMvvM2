package com.nickagas.databindingtestmvvm;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nickagas.databindingtestmvvm.databinding.AdapterSimpleProjectBinding;

import java.util.ArrayList;

/**
 * Created by shado on 25-Aug-17.
 */

public class SimpleObjectAdapter extends RecyclerView.Adapter<SimpleObjectHolder> {

    ArrayList<SimpleObject> items;

    public SimpleObjectAdapter(ArrayList<SimpleObject> items) {
        this.items = items;
    }

    @Override
    public SimpleObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterSimpleProjectBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.adapter_simple_project,parent,false);
        return new SimpleObjectHolder(binding);
    }

    @Override
    public void onBindViewHolder(SimpleObjectHolder holder, int position) {
        holder.bindConnection(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
