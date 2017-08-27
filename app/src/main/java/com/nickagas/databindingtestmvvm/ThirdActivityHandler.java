package com.nickagas.databindingtestmvvm;

import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by shado on 27-Aug-17.
 */

public class ThirdActivityHandler {
    public void onClickButton(View view) {
        if(view instanceof Button){
            Log.i("state","pushed");
            int times = 0;
            times += 1;

            ((Button) view).setText("Clicked " + times + " times");
            view.setTag(times);
        }
    }
}
