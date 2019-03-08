package bwie.com.yanfeng20190308;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import bwie.com.yanfeng20190308.adapter.ShopAdapter;
import bwie.com.yanfeng20190308.bean.GetBean;
import bwie.com.yanfeng20190308.bean.ShopBean;
import bwie.com.yanfeng20190308.mvp.presenter.Presenter;

public class ShowActivity extends AppCompatActivity {

    private CheckBox checkbox;
    private RecyclerView recycl;
    private TextView zong;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        //初始化控件
        checkbox = findViewById(R.id.checkbox);
        recycl = findViewById(R.id.recycl);
        zong = findViewById(R.id.zong);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShowActivity.this,LinearLayoutManager.VERTICAL,false);
        recycl.setLayoutManager(linearLayoutManager);
        presenter = new Presenter(this);
        presenter.showPre();
    }

    public void showView(final String data) {
        runOnUiThread(new Runnable() {

            private ShopBean showBean;
            private ShopAdapter shopAdapter;

            @Override
            public void run() {
                Gson gson = new Gson();
                showBean = gson.fromJson(data, ShopBean.class);
                List<ShopBean.DataBean> list = showBean.getData();

                shopAdapter = new ShopAdapter(ShowActivity.this,list);
                recycl.setAdapter(shopAdapter);
            }
        });
    }
    public void showViews(final String data) {

        runOnUiThread(new Runnable() {
            private ShopAdapter shopAdapter;
            @Override
            public void run() {
                Gson gson = new Gson();
                ShopBean getBean = gson.fromJson(data, ShopBean.class);
                List<ShopBean.DataBean> data1 = getBean.getData();
                shopAdapter = new ShopAdapter(ShowActivity.this,data1);
                recycl.setAdapter(shopAdapter);
            }
        });
    }
    //调用内存泄漏
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.daetchView();
    }


}
