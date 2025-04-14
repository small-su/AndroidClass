package com.example.aclass;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class RegisteredUsersActivity extends AppCompatActivity {

    private ListView lvUsers;
    private UserDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_users);

        lvUsers = findViewById(R.id.lv_users);
        dbHelper = new UserDbHelper(this);

        // 获取所有已注册用户
        List<User> userList = dbHelper.getAllUsers();
        String[] userArray = new String[userList.size()];
        for (int i = 0; i < userList.size(); i++) {
            userArray[i] = "用户名: " + userList.get(i).getUsername() + ", 密码: " + userList.get(i).getPassword();
        }

        // 使用ArrayAdapter将数据绑定到ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userArray);
        lvUsers.setAdapter(adapter);
    }

}