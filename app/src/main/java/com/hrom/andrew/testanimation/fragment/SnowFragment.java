package com.hrom.andrew.testanimation.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.hrom.andrew.testanimation.R;

public class SnowFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.snow_animation, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView star1 = (ImageView) getActivity().findViewById(R.id.star1);
        ImageView star2 = (ImageView) getActivity().findViewById(R.id.star2);
        ImageView star3 = (ImageView) getActivity().findViewById(R.id.star3);
        ImageView star4 = (ImageView) getActivity().findViewById(R.id.star4);
        ImageView star5 = (ImageView) getActivity().findViewById(R.id.star5);
        ImageView star6 = (ImageView) getActivity().findViewById(R.id.star6);
        ImageView star7 = (ImageView) getActivity().findViewById(R.id.star7);
        ImageView star8 = (ImageView) getActivity().findViewById(R.id.star8);

        ImageView snowFlake = (ImageView) getActivity().findViewById(R.id.snowlake);
        ImageView snowFlake1 = (ImageView) getActivity().findViewById(R.id.snowlake2);
        Animation animSnowFlake = AnimationUtils.loadAnimation(getContext(), R.anim.show_snowflake);
        animSnowFlake.setRepeatCount(Animation.INFINITE);
        Animation animSnowFlake1 = AnimationUtils.loadAnimation(getContext(), R.anim.show_snowflake2);
        animSnowFlake1.setRepeatCount(Animation.INFINITE);

        Animation blinkStar = AnimationUtils.loadAnimation(getContext(), R.anim.blink);
        blinkStar.setDuration(5500);
        Animation blinkStart_1 = AnimationUtils.loadAnimation(getContext(), R.anim.blink);
        blinkStart_1.setDuration(4000);
        Animation blibkStar_2 = AnimationUtils.loadAnimation(getContext(), R.anim.blink);
        blibkStar_2.setDuration(2500);

        star1.setAnimation(blinkStar);
        star2.setAnimation(blinkStart_1);
        star3.setAnimation(blibkStar_2);
        star4.setAnimation(blinkStar);
        star5.setAnimation(blinkStart_1);
        star6.setAnimation(blibkStar_2);
        star7.setAnimation(blinkStar);
        star8.setAnimation(blinkStart_1);

        snowFlake.setAnimation(animSnowFlake);
        snowFlake1.setAnimation(animSnowFlake1);
    }
}
