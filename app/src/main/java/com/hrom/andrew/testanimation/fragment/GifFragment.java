package com.hrom.andrew.testanimation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hrom.andrew.testanimation.R;
import com.koushikdutta.ion.Ion;

public class GifFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.gif_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView gif = (ImageView) getActivity().findViewById(R.id.gif);
        ImageView gif1 = (ImageView) getActivity().findViewById(R.id.gif1);
        ImageView gif2 = (ImageView) getActivity().findViewById(R.id.gif2);
        ImageView gif3 = (ImageView) getActivity().findViewById(R.id.gif3);
        Ion.with(gif).load("http://sprites.pokecheck.org/i/497.gif");
        Ion.with(gif1).load("http://sprites.pokecheck.org/i/628.gif");
        Ion.with(gif2).load("http://sprites.pokecheck.org/i/542.gif");
        Ion.with(gif2).animateIn(R.anim.shiny_sun);
    }
}
