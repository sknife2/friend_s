package com.example.app10;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app10.util.ViewUtil;

public class Test extends AppCompatActivity implements View.OnFocusChangeListener, View.OnClickListener {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        editText = findViewById(R.id.user);
        EditText editText1 = findViewById(R.id.password);
        editText.addTextChangedListener(new HideTextWatcher(editText,11));
        editText1.setOnFocusChangeListener(this);
        findViewById(R.id.alert_button).setOnClickListener(this);
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if (hasFocus) {
            String phone = editText.getText().toString();
            if (TextUtils.isEmpty(phone) || phone.length() < 11) {
                editText.requestFocus();
                Toast.makeText(this, "请输入", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("honor user");
        builder.setMessage("are you serious??????");
        builder.setPositiveButton("true", (dialogInterface, i) -> {

        });
        builder.setNegativeButton("no",(dialogInterface, i) -> {

        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private class HideTextWatcher implements TextWatcher {
        private EditText mView;
        private int mMaxLength;
        public HideTextWatcher(EditText editText, int maxLength) {
            this.mMaxLength=maxLength;
            this.mView=editText;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            String str= editable.toString();
            if(str.length()==mMaxLength){
                //隐藏输入法
                ViewUtil.hideOneInputMethod(Test.this,mView);
            }
        }
    }
}