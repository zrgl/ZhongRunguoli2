package com.example.zrgl.zhrglshopping.ui.view.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zrgl.zhrglshopping.R;
import com.example.zrgl.zhrglshopping.ui.view.base.BaseActivity;
import com.example.zrgl.zhrglshopping.ui.view.base.BasePresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


  /**
   * https://www.jb51.net/article/113973.htm   帖子
   * */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private int countSeconds = 60;//倒计时秒数
    private EditText mobile_login, yanzhengma;
    private Button getyanzhengma1, login_btn;
    private Context mContext;
    private String usersuccess;
    private Handler mCountHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (countSeconds > 0) {
                --countSeconds;
                getyanzhengma1.setText("(" + countSeconds + ")后获取验证码");
                mCountHandler.sendEmptyMessageDelayed(0, 1000);
            } else {
                countSeconds = 60;
                getyanzhengma1.setText("请重新获取验证码");
            }
        }
    };

    private String userinfomsg;
    @Override
    public BasePresenter addpresenter() {
        return null;

        //presenter 用来回调数据哦
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initEvent();
        initData();
    }
    private void initView() {
        mobile_login =  findViewById(R.id.mobile_login);
        getyanzhengma1 =  findViewById(R.id.getyanzhengma1);
        yanzhengma = findViewById(R.id.yanzhengma);
        login_btn =  findViewById(R.id.login_btn);
    }
    private void initData() {
    }

    private void initEvent() {
        getyanzhengma1.setOnClickListener(this);
        login_btn.setOnClickListener(this);

    }


    @Override  //点击事件
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.getyanzhengma1:
                if (countSeconds == 60) {
                    String mobile = mobile_login.getText().toString();
                    Log.e("tag", "mobile==" + mobile);

                    getMobiile(mobile);

                } else {
                    Toast.makeText(LoginActivity.this, "不能重复发送验证码", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.login_btn:
                //   login();  //这是登录的方式
                break;
            default:
                break;
        }


    }

    //使用正则表达式判断电话号码
    public static boolean isMobileNO(String tel) {
        Pattern p = Pattern.compile("^(13[0-9]|15([0-3]|[5-9])|14[5,7,9]|17[1,3,5,6,7,8]|18[0-9])\\d{8}$");
        Matcher m = p.matcher(tel);
        System.out.println(m.matches() + "---");
        return m.matches();

    }

   /*    //请求登陆的接口
    private void login() {
        String mobile = mobile_login.getText().toString().trim(); //电话号
        String verifyCode = yanzhengma.getText().toString().trim(); //验证码

          //请求的方式呢
        RequestParams params = new RequestParams(“这里换成你的请求登录的接口”);
           x.http().post(params, new Callback.ProgressCallback<String>() {
            @Override
            public void onWaiting() {
            }
            @Override
            public void onStarted() {
            }
            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
            }
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    Log.e("tag", "登陆的result=" + jsonObject);
                    String success = jsonObject.optString("success");
                    String data = jsonObject.optString("data");
                    String msg=jsonObject.optString("msg");
                    if ("true".equals(success)) {
                        Log.e("tag","登陆的data="+data);
                        JSONObject json = new JSONObject(data);
                        token = json.optString("token");
                        userId = json.optString("userId");
                        //我这里按照我的要求写的，你们也可以适当改动
                        //获取用户信息的状态
                        getUserInfo();
                    }else{
                        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });

    }
*/
     private void getUserInfo() {
      //获取用户个人信息
    }



/*
    //获取验证码信息，进行验证码请求
    private void requestVerifyCode(String mobile) {
        RequestParams requestParams = new RequestParams(“这里是你请求的验证码接口，让后台给你，参数什么的加在后面”);
        x.http().post(requestParams, new Callback.ProgressCallback<String>() {
            @Override
            public void onWaiting() {
            }
            @Override
            public void onStarted() {
            }
            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
            }
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject2 = new JSONObject(result);
                    Log.e("tag", "jsonObject2" + jsonObject2);
                    String state = jsonObject2.getString("success");
                    String verifyCode = jsonObject2.getString("msg");
                    Log.e("tag", "获取验证码==" + verifyCode);
                    if ("true".equals(state)) {
                        Toast.makeText(LoginActivity.this, verifyCode, Toast.LENGTH_SHORT).show();
                        startCountBack();//这里是用来进行请求参数的
                    } else {
                        Toast.makeText(LoginActivity.this, verifyCode, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ex.printStackTrace();
            }
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });
    }

    */

    //获取验证码信息，判断是否有手机号码
    private void getMobiile(String mobile) {
        if ("".equals(mobile)) {
            Log.e("tag", "mobile=" + mobile);
            new AlertDialog.Builder(mContext).setTitle("提示").setMessage("手机号码不能为空").setCancelable(true).show();
        } else if (isMobileNO(mobile) == false) {
            new AlertDialog.Builder(mContext).setTitle("提示").setMessage("请输入正确的手机号码").setCancelable(true).show();
        } else {
            Log.e("tag", "输入了正确的手机号");
            //requestVerifyCode(mobile); 正则表达式判断
        }
    }


    //获取验证码信息,进行计时操作
    private void startCountBack() {
        ((Activity) mContext).runOnUiThread(new Runnable() {  //更新UI
            @Override
            public void run() {
                getyanzhengma1.setText(countSeconds + "");
                mCountHandler.sendEmptyMessage(0);
            }
        });
    }

}
