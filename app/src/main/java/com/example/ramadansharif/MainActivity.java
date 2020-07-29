package com.example.ramadansharif;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    private int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progress = findViewById(R.id.progressId);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });
        thread.start();
    }
    public void doWork(){

        for(p=5;p<=100;p=p+2){
            try {
                Thread.sleep(50);
                progress.setProgress(p);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void startApp(){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
        finish();
    }
}
