package com.example.app10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Find_For_View extends AppCompatActivity {

    private EditText find_for;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_for_view);
        find_for = findViewById(R.id.find_for);
        find_for.requestFocus();
        find_for.callOnClick();
    }
}