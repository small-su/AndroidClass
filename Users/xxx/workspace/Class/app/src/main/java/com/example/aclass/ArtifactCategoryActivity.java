package com.example.aclass;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class ArtifactCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artifact_category);

    }

    public void onHomeIconClick(View view) {
        // 跳转到首页
        Intent intent = new Intent(ArtifactCategoryActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void onCollectionIconClick(View view) {
        // 跳转到收藏页
        Intent intent = new Intent(ArtifactCategoryActivity.this, CollectionActivity.class);
        startActivity(intent);
    }

    public void onDiscoverIconClick(View view) {
        // 跳转到发现页
        Intent intent = new Intent(ArtifactCategoryActivity.this, DiscoverActivity.class);
        startActivity(intent);
    }

    public void onProfileIconClick(View view) {
        // 跳转到个人主页
        Intent intent = new Intent(ArtifactCategoryActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}