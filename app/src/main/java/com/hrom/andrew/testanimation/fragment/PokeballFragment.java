package com.hrom.andrew.testanimation.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.hrom.andrew.testanimation.CustomInterpolator;
import com.hrom.andrew.testanimation.R;

import java.util.Random;

public class PokeballFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pokeball, container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ImageView pokeball_1 = (ImageView) getActivity().findViewById(R.id.pokeball1);
        final ImageView pokeball_2 = (ImageView) getActivity().findViewById(R.id.pokeball2);
        ImageView pokeball_3 = (ImageView) getActivity().findViewById(R.id.pokeball3);

        Animation animSnowFlake = AnimationUtils.loadAnimation(getContext(), R.anim.main_ball);

        Random r = new Random();
        int random = r.nextInt(30);


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
                ObjectAnimator animator4 = ObjectAnimator.ofFloat(pokeball_2, "translationX", 0F, -210F);
                AnimatorSet set1 = new AnimatorSet();
                set1.play(animator4);
                set1.setDuration(3000);
                set1.start();
                Log.d("coordinate", String.valueOf(animator4.getCurrentPlayTime()));

                ObjectAnimator animator1 = ObjectAnimator.ofFloat(pokeball_1, "translationX", 0F, 210F);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(pokeball_1, "translationY", -105F, 0F);
                AnimatorSet set = new AnimatorSet();
                set.play(animator1).with(animator2);
                set.setDuration(3000);
                set.start();
                Log.d("coordinate", String.valueOf(animator2.getAnimatedValue("translationY")));
                Log.d("coordinate", String.valueOf(animator1.getAnimatedValue("translationX")));
            }
        });

        pokeball_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("coordinate", "pokeball_3");
                ValueAnimator animation = ValueAnimator.ofFloat(0f, 500f);
                animation.setDuration(3000);
                animation.start();
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
