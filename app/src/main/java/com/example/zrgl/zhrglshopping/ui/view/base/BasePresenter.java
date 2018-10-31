package com.example.zrgl.zhrglshopping.ui.view.base;

/**
 * Created by asus on 2018/1/25.
 */

public class BasePresenter<V> {
    public V view;
    public void attachview(V view){  //链接视图
        this.view=view;
    }

    public void dettach(){
        this.view=null;
    }

}
