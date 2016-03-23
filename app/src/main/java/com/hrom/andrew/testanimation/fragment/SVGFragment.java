package com.hrom.andrew.testanimation.fragment;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hrom.andrew.testanimation.R;
import com.larvalabs.svgandroid.SVG;

public class SVGFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.svg_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = (ImageView) getActivity().findViewById(R.id.svg_image);
        /*imageView.setBackgroundColor(Color.WHITE);
        imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        SVG svg = SVGParser.getSVGFromResource(getResources(), R.raw.wheel);
        Drawable drawable = svg.createPictureDrawable();
        imageView.(drawable);*/
    }
}
