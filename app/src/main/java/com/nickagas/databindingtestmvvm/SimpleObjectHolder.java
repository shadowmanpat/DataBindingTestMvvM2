package com.nickagas.databindingtestmvvm;

import android.support.v7.widget.RecyclerView;

import com.nickagas.databindingtestmvvm.databinding.AdapterSimpleProjectBinding;

/**
 * Created by shado on 25-Aug-17.
 */

class SimpleObjectHolder extends RecyclerView.ViewHolder {

    private AdapterSimpleProjectBinding binding;

    public SimpleObjectHolder(AdapterSimpleProjectBinding _binding){
        super(_binding.getRoot());
        binding=_binding;
    }

    public void bindConnection(SimpleObject simpleObject){
        binding.setSimpleOject(simpleObject);
    }

}
