package bwie.com.yanfeng20190308.mvp.model;

import javax.security.auth.callback.Callback;

//契约
public interface IModel {
    void show(String url, ShowCallback showCallback);

    interface ShowCallback{
        void Success(String data);

    }
    void shows(String url,ShowsCallback showsCallback);
    interface ShowsCallback{
        void Success(String data);
    }
}

