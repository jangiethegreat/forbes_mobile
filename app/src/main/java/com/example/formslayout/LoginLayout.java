package com.example.formslayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.formslayout.databinding.ActivityLoginLayoutBinding;

public class LoginLayout extends AppCompatActivity {

    private ActivityLoginLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //

        Animation fade_in = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        Animation bottom_down = AnimationUtils.loadAnimation(this, R.anim.bottom_down);

        binding.topLinearLayout.setAnimation(bottom_down);

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Animation fade_in = new AlphaAnimation(0.0f, 1.0f);
                fade_in.setDuration(1000);
                fade_in.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        // Empty implementation
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        binding.cardView.setVisibility(View.VISIBLE);
                        binding.cardView5.setVisibility(View.VISIBLE);
                        binding.textView.setVisibility(View.VISIBLE);
                        binding.registerLayout.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // Empty implementation
                    }
                });

                binding.cardView.startAnimation(bottom_down);
                binding.cardView5.startAnimation(fade_in);
                binding.textView.startAnimation(fade_in);
                binding.registerLayout.startAnimation(fade_in);
            }
        };

        handler.postDelayed(runnable, 1000);


    }
}