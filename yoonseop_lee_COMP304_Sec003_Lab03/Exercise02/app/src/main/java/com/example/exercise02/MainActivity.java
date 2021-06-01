package com.example.exercise02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView _moonImageView;
    private ImageView _earthImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this._earthImageView = findViewById(R.id.earthImgView);
        this._moonImageView = findViewById(R.id.moonImgView);

        findViewById(R.id.startAnimBtn).setOnClickListener(v -> this._startAnimation());
        findViewById(R.id.stopAnimBtn).setOnClickListener(v -> this._stopAnimation());
    }

    //helper methods
    private void _startAnimation() {
        Toast.makeText(this, getResources().getString(R.string.starting_anim_txt), Toast.LENGTH_SHORT).show();
        this._earthImageView.setImageResource(R.drawable.earth);
        this._moonImageView.setImageResource(R.drawable.moon);

        // Load the appropriate animation
        Animation earthAnim = AnimationUtils.loadAnimation(this, R.anim.earth_spin);
        Animation moonAnim = AnimationUtils.loadAnimation(this, R.anim.moon_anim);

        earthAnim.setRepeatCount(Animation.INFINITE);
        moonAnim.setRepeatMode(Animation.RESTART);
        moonAnim.setRepeatCount(Animation.INFINITE);
        this._moonImageView.startAnimation(moonAnim);
        this._earthImageView.startAnimation(earthAnim);
    }

    private void _stopAnimation() {
        Toast.makeText(this, getResources().getString(R.string.stopping_anim_txt), Toast.LENGTH_SHORT).show();
        this._earthImageView.clearAnimation();
        this._moonImageView.clearAnimation();
    }
}
