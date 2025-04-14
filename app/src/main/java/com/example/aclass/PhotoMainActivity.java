package com.example.aclass;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PhotoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_main);
    }

    public void onCollectionButtonClick(View view) {
        try {
            Intent intent = new Intent(this, CollectionActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            Log.e("PhotoMainActivity", "Error starting CollectionActivity", e);
            // 显示错误提示对话框
            new AlertDialog.Builder(PhotoMainActivity.this)
                    .setTitle("错误")
                    .setMessage("无法打开收藏页面，请稍后再试")
                    .setPositiveButton("确定", null)
                    .show();
        }
    }

    public void onDiscoverButtonClick(View view) {
        Intent intent = new Intent(this, DiscoverActivity.class);
        startActivity(intent);
    }

    public void onProfileButtonClick(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}