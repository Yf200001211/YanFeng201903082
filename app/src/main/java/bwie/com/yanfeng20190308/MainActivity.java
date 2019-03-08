package bwie.com.yanfeng20190308;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bwie.com.yanfeng20190308.mvp.presenter.Presenter;

public class MainActivity extends AppCompatActivity {

    private Button tiao;
    private EditText sou;
    private List list;
    private Button qing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tiao = findViewById(R.id.tiao);
        sou = findViewById(R.id.sou);
        qing = findViewById(R.id.qing);
        tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(intent);
                finish();
            }
        });
        list = new ArrayList<>();
        sou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = sou.getText().toString();
                list.add(text);


            }


        });
        qing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sou.getText().clear();
                list.clear();
            }
        });
    }
}
