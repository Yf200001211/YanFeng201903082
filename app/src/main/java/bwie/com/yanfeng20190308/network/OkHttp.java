package bwie.com.yanfeng20190308.network;

import android.util.Log;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;

import static okhttp3.internal.Internal.instance;

public class OkHttp {

    private static OkHttp instance;
    private static OkHttpClient okHttpClient;
    private static FormBody build;
    private  static Request request;

    //拦截器
    private Interceptor getAppinterceptor(){
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Log.i("-----","拦截前");
                Response proceed = chain.proceed(request);
                Log.i("-----","拦截后");
                return proceed;
            }
        };
        return interceptor;
    }
    //单利
    private static OkHttp getInstance(){
        if (Internal.instance==null){
        synchronized (OkHttp.class){
            if (null== Internal.instance){
                instance = new OkHttp();
            }
        }
        }
        return instance;
    }
    //get
    public static void doGet(String url, Callback callback){
        okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
    //post
    public static void doPost(String url,String name,String pwd,Callback callback){
         okHttpClient = new OkHttpClient();
        build = new FormBody.Builder()
                .add("name", name)
                .add("pwd", pwd)
                .build();
        request = new Request.Builder().
                post(build).
                build();
        okHttpClient.newCall(request).enqueue(callback);
    }

}
