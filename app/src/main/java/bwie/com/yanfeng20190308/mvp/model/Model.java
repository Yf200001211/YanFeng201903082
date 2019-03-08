package bwie.com.yanfeng20190308.mvp.model;

import java.io.IOException;

import bwie.com.yanfeng20190308.network.OkHttp;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Model implements IModel {
    @Override
    public void show(String url, final ShowCallback showCallback) {
        //okttp使用get请求
        OkHttp.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            showCallback.Success(response.body().string());
            }
        });

    }

    @Override
    public void shows(String url, final ShowsCallback showsCallback) {
        OkHttp.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                showsCallback.Success(response.body().string());
            }
        });
    }

}
