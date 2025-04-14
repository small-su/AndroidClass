package com.example.aclass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {

    private EditText etNumber, etPassword;
    private CheckBox cbRemember;
    private SharedPreferences sharedPreferences;
    private UserDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout__login); // 加载登录界面

        etNumber = findViewById(R.id.et_number);
        etPassword = findViewById(R.id.et_password);
        cbRemember = findViewById(R.id.cb_remember);

        sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        dbHelper = new UserDbHelper(this); // 确保传入正确的上下文

        // 读取保存的账号和密码
        String savedUsername = sharedPreferences.getString("username", "");
        String savedPassword = sharedPreferences.getString("password", "");
        boolean isRemembered = sharedPreferences.getBoolean("remember", false);

        if (isRemembered) {
            etNumber.setText(savedUsername);
            etPassword.setText(savedPassword);
            cbRemember.setChecked(true);
        }

        Button loginButton = findViewById(R.id.btn_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etNumber.getText().toString();
                String password = etPassword.getText().toString();

                if (dbHelper.checkUser(username, password)) {
                    // 如果勾选了记住密码，则保存账号和密码
                    if (cbRemember.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.putBoolean("remember", true);
                        editor.apply();
                    } else {
                        // 如果没有勾选记住密码，则清除保存的账号和密码
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("username");
                        editor.remove("password");
                        editor.putBoolean("remember", false);
                        editor.apply();
                    }

                    Intent intent = new Intent(loginActivity.this, PhotoMainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(loginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 获取“去注册”按钮
        Button btnRegister = findViewById(R.id.button);
        // 为按钮设置点击事件监听器
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到注册界面
                Intent intent = new Intent(loginActivity.this, signActivity.class);
                startActivity(intent);
            }
        });
    }
}
