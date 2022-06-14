package com.example.rachrnewtechapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.example.rachrnewtechapp.MainActivity;
import com.example.rachrnewtechapp.Model.UserDto;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Utils.DatabaseUtil;

public class SplashScreenActivity extends AppCompatActivity {
    private UserDto userDto;
    private DatabaseUtil databaseUtil;
    private LottieAnimationView lottieAnimationView;
    private ImageView splashScreenImage;
    private LinearLayout ll_layout;
    private RelativeLayout rl_splashscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
 //       lottieAnimationView = (LottieAnimationView)findViewById(R.id.lottie_layer_name);

  //      splashScreenImage = (ImageView)findViewById(R.id.splashScreenImage);
        ll_layout = (LinearLayout)findViewById(R.id.ll_layout);
        rl_splashscreen = (RelativeLayout)findViewById(R.id.rl_splashscreen);
        Animation animation1 = AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.side_slide);
        ll_layout.startAnimation(animation1);

        databaseUtil = new DatabaseUtil(getApplicationContext());
        userDto = databaseUtil.fetchRegisteredDeviceData();
        databaseUtil.close();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (userDto.getUserName() == null){
                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },5000);

       /* lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                ll_layout.setVisibility(View.VISIBLE);
                lottieAnimationView.setVisibility(View.GONE);
                Animation animation1 = AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.side_slide);
                splashScreenImage.startAnimation(animation1);


            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });*/
    }
}