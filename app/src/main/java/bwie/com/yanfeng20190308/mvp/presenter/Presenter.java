package bwie.com.yanfeng20190308.mvp.presenter;

import java.lang.ref.Reference;

import bwie.com.yanfeng20190308.ShowActivity;
import bwie.com.yanfeng20190308.api.Api;
import bwie.com.yanfeng20190308.mvp.model.IModel;
import bwie.com.yanfeng20190308.mvp.model.Model;

public class Presenter<T> implements IPresenter {
    private Reference<T> tReference;
    ShowActivity showActivity;
    private Model model;

    public Presenter(ShowActivity showActivity) {
        this.showActivity = showActivity;
        model = new Model();
    }

    @Override
    public void showPre() {
        model.show(Api.SHOW, new IModel.ShowCallback() {
            @Override
            public void Success(String data) {
                showActivity.showView(data);
            }
        });
    }

    @Override
    public void showsPre() {
        model.show(Api.SHOWS, new IModel.ShowCallback() {
            @Override
            public void Success(String data) {
                showActivity.showViews(data);
            }
        });
    }

    //内存泄漏
    public void daetchView(){
        if (tReference!=null){
            tReference.clear();
            tReference=null;
        }
    }
}
