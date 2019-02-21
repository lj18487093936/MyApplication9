package com.example.sazyg.myapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * 版权：圣爱中医馆公司 版权所有
 * <p>
 * 作者：sa
 * <p>
 * 版本：1.0
 * <p>
 * 创建日期：2019/2/21
 * <p>
 * 描述：广告页
 * <p>
 * 修订历史：
 */
public class AdsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvAds;//跳过广告按钮
    private CountDownTimer countDownTimer;//计时器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        initView();
        countDownTimer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvAds.setText("跳过广告" + (millisUntilFinished / 1000) + "秒");
            }

            @Override
            public void onFinish() {
                //倒计时结束的时候跳转到登录界面
                Intent intent = new Intent(AdsActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }

    /**
     * 初始化页面
     */
    private void initView() {
        tvAds = findViewById(R.id.tv_ads);
        tvAds.setOnClickListener(this);
    }

    /**
     * 页面的点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_ads://点击跳过广告页面
                countDownTimer.cancel();
                Intent intent = new Intent(AdsActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    /**
     * 页面销毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();   //释放CountDownTimer
    }
}