package com.example.sazyg.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/**
 *
 * 版权：圣爱中医馆公司 版权所有
 *
 * 作者：sa
 *
 * 版本：1.0
 *
 * 创建日期：2019/2/21
 *
 * 描述：
 *
 * 修订历史：
 *
 */
public class LaunchActivity extends AppCompatActivity {
    private static final int DELAY_TIME = 3000;// 延时时间
    private Handler myHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myHandler=new Handler();
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                go_Home();
            }
        },DELAY_TIME);
    }
    //跳转到主页面
    private void go_Home()
    {
        Intent  intent=new Intent();
        intent.setClass(LaunchActivity.this,AdsActivity.class);
        startActivity(intent);
        finish();
        //页面的切换效果
        overridePendingTransition(R.anim.fade,R.anim.hold);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myHandler=null;
    }
}
