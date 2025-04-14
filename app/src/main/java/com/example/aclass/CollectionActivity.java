package com.example.aclass;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        // 获取水果容器布局
        LinearLayout linearLayout = findViewById(R.id.fruitContainer);

        // 水果数组，包含名称和对应的图片资源ID
        String[][] fruits = {
                {"苹果", "apple"},
                {"香蕉", "banana"},
                {"葡萄", "grapes"},
                {"梨", "pear"},
                {"西瓜", "watermelon"}
        };

        // 动态添加水果按钮
        for (String[] fruit : fruits) {
            Button button = new Button(this);
            button.setText(fruit[0]); // 设置按钮文本为水果名称

            try {
                // 加载图片资源
                int resourceId = getResources().getIdentifier(fruit[1], "drawable", getPackageName());
                if (resourceId != 0) {
                    button.setBackgroundResource(resourceId); // 设置按钮背景为水果图片
                } else {
                    Log.w("CollectionActivity", "Resource not found: " + fruit[1]);
                }
            } catch (Exception e) {
                Log.e("CollectionActivity", "Error loading resource: " + fruit[1], e);
            }

            // 设置按钮点击事件
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 显示点击的水果名
                    new AlertDialog.Builder(CollectionActivity.this)
                            .setTitle("水果")
                            .setMessage("您选择了: " + fruit[0])
                            .setPositiveButton("确定", null)
                            .show();
                }
            });

            // 将按钮添加到布局中
            linearLayout.addView(button);
        }
    }
}