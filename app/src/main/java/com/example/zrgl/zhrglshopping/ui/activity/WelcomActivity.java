package com.example.zrgl.zhrglshopping.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;


import com.example.zrgl.zhrglshopping.R;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomActivity extends Activity {

    private TextView welcome_time;
    private  int count=3;
    private Timer timer;

     private Handler handler=new Handler(){

           @Override
           public void handleMessage(Message msg) {
               super.handleMessage(msg);
                 switch (msg.what){
                     case 1:
                         Intent intent = new Intent(WelcomActivity.this, MainActivity.class);
                         startActivity(intent);
                         break;
                     case 2:
                         welcome_time.setText(count+"跳过");
                 }
           }
       };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        welcome_time = findViewById(R.id.text_welcome_time);

         //获取textview文本控件
        timer = new Timer();
         timer.scheduleAtFixedRate(new MyTask(),0,1000);

    }

    private class MyTask extends TimerTask {
        @Override
        public void run() {

            count--;
            if (count>0){
                handler.sendEmptyMessage(2);
            }else {

                handler.sendEmptyMessage(1);
                timer.cancel();
                finish();
            }

        }
    }
}
