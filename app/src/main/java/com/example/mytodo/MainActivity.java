package com.example.mytodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                startfun();
            }
        },1000);



    }

    private void startfun() {
        Intent shp=new Intent(this, Screen_a.class);
        startActivity(shp);
    }
}