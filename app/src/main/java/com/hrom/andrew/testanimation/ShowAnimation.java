package com.hrom.andrew.testanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class ShowAnimation extends Activity {
    private ImageView sun, clock, hour_clock;
    private Animation sunAnimation, clockAnimation, hourClockAnimation;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_animation);

        sun = (ImageView) findViewById(R.id.sun);
        clock = (ImageView) findViewById(R.id.clock);
        hour_clock = (ImageView) findViewById(R.id.hour_clock);

        sunAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.get_up);
        clockAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.run_clock);
        hourClockAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.run_clock_hour);

        sun.startAnimation(sunAnimation);
        clock.startAnimation(clockAnimation);
        hour_clock.startAnimation(hourClockAnimation);

        View.OnClickListener shineSun = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation shineSun = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shiny_sun);
                sun.startAnimation(shineSun);
            }
        };
        sun.setOnClickListener(shineSun);

    }

    public void getUp(View view) {
        sunAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.get_up);
        clockAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.run_clock);
        sun.startAnimation(sunAnimation);
        clock.startAnimation(clockAnimation);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        overridePendingTransition(R.anim.diagonal_in, R.anim.diagonal_out);
    }
}


