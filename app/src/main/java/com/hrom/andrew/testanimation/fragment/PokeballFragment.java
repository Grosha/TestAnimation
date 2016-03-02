package com.hrom.andrew.testanimation.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hrom.andrew.testanimation.CustomInterpolator;
import com.hrom.andrew.testanimation.R;

import java.util.ArrayList;
import java.util.Random;

public class PokeballFragment extends Fragment {
    private float x = 0f;
    private float y = 0f;
    private float radius = 210f;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pokeball, container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ImageView pokeball_1 = (ImageView) getActivity().findViewById(R.id.pokeball1);
        final ImageView pokeball_2 = (ImageView) getActivity().findViewById(R.id.pokeball2);
        final ImageView pokeball_3 = (ImageView) getActivity().findViewById(R.id.pokeball3);

        final Random r = new Random();
        final int random = r.nextInt(30);

        /*if (0 <= random & random < 10) {
            pokeball_1.startAnimation(animSnowFlake);
        } else if (10 <= random & random < 20) {
            pokeball_2.startAnimation(animSnowFlake);
        } else if (20 <= random & random < 30) {
            pokeball_3.startAnimation(animSnowFlake);
        }*/


        pokeball_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("coordinate", "pokeball_1");
                ObjectAnimator animator4 = ObjectAnimator.ofFloat(pokeball_3, "translationX", 0F, -420F);
                AnimatorSet set1 = new AnimatorSet();
                set1.play(animator4);
                set1.setDuration(3000);
                set1.start();
                Log.d("coordinate", String.valueOf(animator4.getCurrentPlayTime()));


                ValueAnimator animator2 = ValueAnimator.ofFloat(0F, 2 * radius);
                animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        x = (Float) animation.getAnimatedValue();
                        Log.d("coordinate", "x = " + x);
                        float newX = 0;
                        if (x <= radius) {
                            newX = radius - x;
                            Log.d("coordinate", "newX = " + newX);
                        } else if (radius < x && x <= radius * 2) {
                            newX = x - radius;
                            Log.d("coordinate", "newX = " + newX);
                        }
                        y = (float) Math.sqrt(radius * radius - newX * newX);
                        Log.d("coordinate", "y = " + y);
                        ViewCompat.setTranslationX(pokeball_1, x);
                        ViewCompat.setTranslationY(pokeball_1, y);
                    }
                });
                AnimatorSet set = new AnimatorSet();
                set.play(animator2);
                set.setDuration(3000);
                set.start();
            }
        });

        pokeball_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("coordinate", "pokeball_3");
               /* ValueAnimator animation = ValueAnimator.ofFloat(0f, 500f);
                animation.setDuration(3000);
                animation.start();*/
            }
        });

        pokeball_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("coordinate", "pokeball_2");
            }
        });
    }
}
