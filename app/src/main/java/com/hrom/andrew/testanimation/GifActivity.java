package com.hrom.andrew.testanimation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;

public class GifActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gif_layout);

        ImageView gif = (ImageView)findViewById(R.id.gif);
        ImageView gif1 = (ImageView)findViewById(R.id.gif1);
        ImageView gif2 = (ImageView)findViewById(R.id.gif2);
        ImageView gif3 = (ImageView)findViewById(R.id.gif3);
        Ion.with(gif).load("http://sprites.pokecheck.org/i/497.gif");
        Ion.with(gif1).load("http://sprites.pokecheck.org/i/628.gif");
        Ion.with(gif2).load("http://sprites.pokecheck.org/i/542.gif");
        Ion.with(gif2).animateIn(R.anim.shiny_sun);
    }
}
