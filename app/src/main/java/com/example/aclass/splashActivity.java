package com.example.aclass;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        intiA(); // 确保intiA方法被调用
    }

    public void intiA(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 跳转到loginActivity
                Intent intent = new Intent(splashActivity.this, loginActivity.class);
                startActivity(intent);
                finish(); // 结束当前Activity
            }
        }, 2000); // 确保延迟时间为2000毫秒（两秒）
    }
}