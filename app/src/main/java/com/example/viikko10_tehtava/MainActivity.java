package com.example.viikko10_tehtava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private UserStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        storage  = UserStorage.getInstance();
        storage.loadUsers(context);
    }

    public void switchToAddUser(View view)  {
        Intent intent = new Intent(this, askInfoActivity.class);
        startActivity(intent);
    }

    public void switchToListUsers(View view)  {
        storage.sortUsersAlphabetically();
        Intent intent = new Intent(this, listUsersActivity.class);
        startActivity(intent);
    }
}