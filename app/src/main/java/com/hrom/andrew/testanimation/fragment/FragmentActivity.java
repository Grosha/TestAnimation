package com.hrom.andrew.testanimation.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.hrom.andrew.testanimation.R;


public class FragmentActivity extends AppCompatActivity {
    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);

        number = getIntent().getIntExtra("number", 0);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (number) {
            case 0:
                //transaction.replace(R.id.container, new GifFragment());
                break;
            case 1:
                transaction.replace(R.id.container, new GifFragment());
                break;
            case 2:
                transaction.replace(R.id.container, new SnowFragment());
                break;
            case 3:
                transaction.replace(R.id.container, new PokeballFragment());
                break;case 4:
                transaction.replace(R.id.container, new SVGFragment());
                break;
        }
        transaction.commit();
    }
}
