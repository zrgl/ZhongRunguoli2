package com.example.zrgl.zhrglshopping.ui.view.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public abstract class BaseActivity<V,P extends BasePresenter<V>> extends AppCompatActivity {
    public P presenter;
    public abstract P addpresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //presenter连接view与model
        presenter=addpresenter();
        //连接视图
        presenter.attachview((V) this);
    }
        //销毁视图
    @Override
    protected void onDestroy() {
        super.onDestroy();
         presenter.dettach();
    }
}
