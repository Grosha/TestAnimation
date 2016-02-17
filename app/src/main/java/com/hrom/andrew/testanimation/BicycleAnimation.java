package com.hrom.andrew.testanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class BicycleAnimation extends Activity{
    private ImageView wheel1,wheel2;
    private Animation bicycleWheel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bicycle);

        wheel1 = (ImageView)findViewById(R.id.wheel1);
        wheel2 = (ImageView)findViewById(R.id.wheel2);

        bicycleWheel = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.whell_round);
        wheel1.setAnimation(bicycleWheel);
        wheel2.setAnimation(bicycleWheel);
    }
}
