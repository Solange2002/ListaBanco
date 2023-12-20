package com.example.listabanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickLogin(View view) {
        EditText txtusuario= findViewById(R.id.txtuser);
        EditText txtpass= findViewById(R.id.txtclave);
        Intent intent =new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);

    }
}
