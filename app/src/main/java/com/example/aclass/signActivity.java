package com.example.aclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class signActivity extends AppCompatActivity {

    private EditText etNewUsername, etNewPassword;
    private UserDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sign);

        etNewUsername = findViewById(R.id.nameEditText);
        etNewPassword = findViewById(R.id.passwordEditText);
        dbHelper = new UserDbHelper(this);

        Button btnSignUp = findViewById(R.id.registerButton);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etNewUsername.getText().toString();
                String password = etNewPassword.getText().toString();

                dbHelper.addUser(username, password);
                Toast.makeText(signActivity.this, "注册成功", Toast.LENGTH_SHORT).show();

                // 记录已注册人员
                List<User> registeredUsers = dbHelper.getAllUsers();
                for (User user : registeredUsers) {
                    System.out.println("Registered User: " + user.getUsername());
                }

                finish(); // 返回登录界面
            }
        });

        // 为 select 按钮绑定点击事件
        Button btnSelect = findViewById(R.id.select);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signActivity.this, RegisteredUsersActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_registered_users, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_view_users) {
            Intent intent = new Intent(this, RegisteredUsersActivity.class);
            startActivity(intent);
            return true; // 确保返回 true 以表示事件已处理
        }
        return super.onOptionsItemSelected(item);
    }
}