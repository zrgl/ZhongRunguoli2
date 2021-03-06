package com.example.zrgl.zhrglshopping.ui.util;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zrgl.zhrglshopping.R;


public class ButtomBtn extends LinearLayout {

    private ImageView iv;
    private TextView tv;

    public ButtomBtn(Context context) {
        super(context);
        init(context);
    }
    public ButtomBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ButtomBtn(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context) {
        setOrientation(VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
        setGravity(Gravity.CENTER);
        //setPadding(UIUtils.dip2px(5),UIUtils.dip2px(5),UIUtils.dip2px(5),UIUtils.dip2px(5)); //这里注释掉的适配
        View bottomBtnView = LayoutInflater.from(context).inflate(R.layout.bottom_btn_view, this, true);
        iv = bottomBtnView.findViewById(R.id.iv);
        tv = bottomBtnView.findViewById(R.id.tv);

     }
    public void setIvAndTv(int imgRes,String tvString){
        iv.setImageResource(imgRes);
        tv.setText(tvString);
    }
    public void setTvColor(int color){
        tv.setTextColor(color);
    }


}
