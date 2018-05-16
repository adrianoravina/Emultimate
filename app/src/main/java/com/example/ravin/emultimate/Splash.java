package com.example.ravin.emultimate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    private TextView tv;
    private ImageView iv;
    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tv = (TextView)findViewById(R.id.tv);
        iv = (ImageView)findViewById(R.id.iv);
        mProgress = (ProgressBar)findViewById(R.id.progressBar);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.splashtransition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);

        final Intent intent = new Intent(this, MainActivity.class);

        Thread timer = new Thread(){

            public void run(){
                try{
          for(int progress=0; progress < 100; progress+=20){

                  sleep(1000);
                  mProgress.setProgress(progress);


          }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }

            }
        };

        timer.start();


    }
}
