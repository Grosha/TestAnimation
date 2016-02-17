package com.hrom.andrew.testanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class GameActivity extends Activity{
    private ImageView red_bol,plane;
    private Animation fire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        plane = (ImageView)findViewById(R.id.plane);
        red_bol = (ImageView)findViewById(R.id.bol);

        /*fire = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.action_red_bol);
        red_bol.setAnimation(fire);*/

        View.OnClickListener shineSun = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation fire = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.action_red_bol);
                red_bol.startAnimation(fire);
            }
        };
        plane.setOnClickListener(shineSun);
    }
}
