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
import android.widget.Button;
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
    ImageView pokeball_1 = null;
    ImageView pokeball_2 = null;
    ImageView pokeball_3 = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pokeball, container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pokeball_1 = (ImageView) getActivity().findViewById(R.id.pokeball1);
        pokeball_2 = (ImageView) getActivity().findViewById(R.id.pokeball2);
        pokeball_3 = (ImageView) getActivity().findViewById(R.id.pokeball3);
        Button strat = (Button) view.findViewById(R.id.start);

        strat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random r = new Random();
                int first = 0, second = 0;
                int random = r.nextInt(30);

                if (0 <= random & random < 10) {
                    pokeball_1.setImageResource(R.drawable.new_ball);
                    pokeball_2.setImageResource(R.drawable.pokeball);
                    pokeball_3.setImageResource(R.drawable.pokeball);
                    first = 1;
                    second = 3;
                } else if (10 <= random & random < 20) {
                    pokeball_2.setImageResource(R.drawable.new_ball);
                    pokeball_1.setImageResource(R.drawable.pokeball);
                    pokeball_3.setImageResource(R.drawable.pokeball);
                    first = 3;
                    second = 2;
                } else if (20 <= random & random < 30) {
                    pokeball_3.setImageResource(R.drawable.new_ball);
                    pokeball_1.setImageResource(R.drawable.pokeball);
                    pokeball_2.setImageResource(R.drawable.pokeball);
                    first = 2;
                    second = 1;
                }

                animationLine(first,second);
                animationCircle(first,second);

                /*Log.d("coordinate", "start");
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
                set.start();*/
            }
        });


        pokeball_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("coordinate", "pokeball_1");
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

    public void animationCircle(int first, int second) {
        ImageView pokeball = null;
        float radius = 0f;
        if (first < second && (second - first) > 1) {
            radius = 210f;
            pokeball = pokeball_1;
        } else if (first < second && (second - first) == 1) {
            if (first == 2 && second == 3) {
                radius = 105f;
                pokeball = pokeball_2;
            } else {
                radius = 105f;
                pokeball = pokeball_1;
            }

        } else if (first > second && (first - second) > 1) {
            radius = -210f;
            pokeball = pokeball_3;

        } else if (first > second && (first - second) == 1) {
            if (first == 2 && second == 1) {
                radius = -105f;
                pokeball = pokeball_2;
            } else {
                radius = -105f;
                pokeball = pokeball_3;
            }

        }
        ValueAnimator animator = ValueAnimator.ofFloat(0F, 2 * radius);
        final ImageView finalPokeball = pokeball;
        final float finalRadius = radius;
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                x = (Float) animation.getAnimatedValue();
                Log.d("coordinate", "x = " + x);
                float newX = 0;
                if (x <= finalRadius) {
                    newX = finalRadius - x;
                    Log.d("coordinate", "newX = " + newX);
                } else if (finalRadius < x && x <= finalRadius * 2) {
                    newX = x - finalRadius;
                    Log.d("coordinate", "newX = " + newX);
                }
                y = (float) Math.sqrt(finalRadius * finalRadius - newX * newX);
                Log.d("coordinate", "y = " + y);
                ViewCompat.setTranslationX(finalPokeball, x);
                ViewCompat.setTranslationY(finalPokeball, y);
            }
        });
        AnimatorSet set = new AnimatorSet();
        set.play(animator);
        set.setDuration(3000);
        set.start();
    }

    public void animationLine(int first, int second) {
        ImageView pokeball = null;
        float diameter = 0f;
        if (first < second && (second - first) > 1) {
            diameter = -420f;
            pokeball = pokeball_3;
        } else if (first < second && (second - first) == 1) {
            if (first == 2 && second == 3) {
                diameter = -210f;
                pokeball = pokeball_3;
            } else {
                diameter = 210f;
                pokeball = pokeball_2;
            }

        } else if (first > second && (first - second) > 1) {
            diameter = 420f;
            pokeball = pokeball_1;

        } else if (first > second && (first - second) == 1) {
            if (first == 2 && second == 1) {
                diameter = -210f;
                pokeball = pokeball_1;
            } else {
                diameter = 210f;
                pokeball = pokeball_2;
            }

        }
        Log.d("coordinate", "start");
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(pokeball, "translationX", 0F, diameter);
        AnimatorSet set1 = new AnimatorSet();
        set1.play(animator4);
        set1.setDuration(3000);
        set1.start();
        Log.d("coordinate", String.valueOf(animator4.getCurrentPlayTime()));
    }
}
