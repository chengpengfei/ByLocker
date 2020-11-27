package com.boyangsoft.zhxf.bylocker.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.boyangsoft.zhxf.bylocker.R;
import com.boyangsoft.zhxf.bylocker.activity.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }


    public void  lq_button_click(View view){
        Toast.makeText(getApplicationContext(),"点击了领取按钮",Toast.LENGTH_LONG).show();

    }

    public void  cc_button_click(View view){
        Toast.makeText(getApplicationContext(),"点击了存储按钮",Toast.LENGTH_LONG).show();

    }

    public void  gl_button_click(View view){
        Toast.makeText(getApplicationContext(),"点击了管理按钮",Toast.LENGTH_LONG).show();
        goToActivity(this, GlPwdActivity.class, false);
    }

}