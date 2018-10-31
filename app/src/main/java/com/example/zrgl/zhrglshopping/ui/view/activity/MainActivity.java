package com.example.zrgl.zhrglshopping.ui.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.example.zrgl.zhrglshopping.R;

import com.example.zrgl.zhrglshopping.ui.view.fragment.FenleiFragment2;
import com.example.zrgl.zhrglshopping.ui.view.fragment.GroupFragment3;
import com.example.zrgl.zhrglshopping.ui.view.fragment.HomeFragment1;
import com.example.zrgl.zhrglshopping.ui.view.fragment.PersonalFragment5;
import com.example.zrgl.zhrglshopping.ui.view.fragment.ShoppingcarFragment4;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar mb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mb=findViewById(R.id.bottom_tab_bar);

        mb.init(getSupportFragmentManager()) //方法一定要第一个调用，没有//这个初始化，后边什么也做不了。
                .setImgSize(64,64)
                .setFontSize(13)  // 文字尺寸
                .setTabPadding(14,2,9)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.drawable.iconhomeselect,R.drawable.iconhome,HomeFragment1.class)
                .addTabItem("分类",R.drawable.iconfenleiselect,R.drawable.iconfenlei,FenleiFragment2.class)
                .addTabItem("拼团",R.drawable.icongrouselect,R.drawable.icongroup, GroupFragment3.class)
                .addTabItem("购物车",R.drawable.iconshoppingcarselect,R.drawable.iconshopingcar,ShoppingcarFragment4.class)
                .addTabItem("我的",R.drawable.iconpersonalselect,R.drawable.iconpersonal, PersonalFragment5.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                 @Override
                 public void onTabChange(int position, String name) {
                     }
                });
     }
}
