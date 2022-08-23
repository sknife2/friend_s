package com.example.app10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.app10.Adapter.RecycleAdapter;
import com.example.app10.util.UserBean;
import java.util.List;

public class Dynamic_View extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {
    private List<UserBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_view2);
      /* EditText editText=(EditText)findViewById(R.id.find_for);
                editText.setOnFocusChangeListener(this);*/
        //private ActivityResultLauncher<Intent> register;
        RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // RecyclerView的三部曲 03： 添加适配器，适配器需要重写
        RecycleAdapter mMyAdapter = new RecycleAdapter(Dynamic_View.this);
        mRecyclerView.setAdapter(mMyAdapter);
        /*
        ImageButton imageButton = findViewById(R.id.transport);
        imageButton.setOnClickListener(this);
        register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result != null) {
                Intent intent = result.getData();
                if ((intent != null && result.getResultCode() == Activity.RESULT_OK)) {
                    Bundle bundle = getIntent().getExtras();
                    String name = bundle.getString("message");
                }
            }
        });*/
    }
    @Override
    public void onClick(View view) {

    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if(b){
                Intent intent=new Intent(this,Find_For_View.class);
                startActivity(intent);
        }
    }

  /*  @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Comment_View.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", "svvsvsvsvs");
        intent.putExtras(bundle);
        register.launch(intent);
    }*/
}