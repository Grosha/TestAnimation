package com.hrom.andrew.testanimation;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.hrom.andrew.testanimation.fragment.FragmentActivity;

public class MainActivity extends Activity {
    private ImageView image, image1;
    private Animation animation, animation1;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.imageView);
        image1 = (ImageView) findViewById(R.id.imageView2);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);

    }

    public void clockwise(View view) {
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
        image.startAnimation(animation);
    }

    public void zoom(View view) {
        animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        image.startAnimation(animation1);
    }

    public void fade(View view) {
        animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        image.startAnimation(animation1);
    }

    public void blink(View view) {
        animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(animation1);
    }

    public void move(View view) {
        animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image.startAnimation(animation1);
    }

    public void slide(View view) {
        animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        image.startAnimation(animation1);
    }

    public void test2(View view) {
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.test2);
        animation.setDuration(3000);
        image.startAnimation(animation);
    }

    public void circle(View view) {
        animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.circle);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.circle);
        animation.setDuration(3000);
        animation1.setDuration(3000);
        image.startAnimation(animation1);
        image1.startAnimation(animation);
    }

    public void openAnimationActivity(View view) {
        //this.finish();
        Intent intent = new Intent(MainActivity.this, ShowAnimation.class);
        startActivity(intent);
        overridePendingTransition(R.anim.diagonal_in, R.anim.diagonal_out);
    }

    public void openBicycleAnimationActivity(View view) {
        Intent intent = new Intent(MainActivity.this, BicycleAnimation.class);
        startActivity(intent);

        int cx = (view.getLeft() + view.getRight()) / 2;
        int cy = view.getTop();
        int finalRadius = Math.max(view.getWidth(), view.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
        view.setBackgroundColor(Color.BLUE);
        anim.start();
    }

    public void getUp(View view) {
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.get_up);
        image.startAnimation(animation);
    }

    public void onGif(View view) {
        Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
        intent.putExtra("number", 1);
        startActivity(intent);
    }

    public void onGame(View view) {
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent);
    }

    public void onSnow(View view) {
        Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
        intent.putExtra("number", 2);
        startActivity(intent);
    }

    public void onPokeball(View view) {
        Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
        intent.putExtra("number", 3);
        startActivity(intent);
    }

    public void shoProgress(View v) {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }
}