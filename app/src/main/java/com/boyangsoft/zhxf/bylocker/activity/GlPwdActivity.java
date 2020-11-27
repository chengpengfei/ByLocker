package com.boyangsoft.zhxf.bylocker.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.boyangsoft.zhxf.bylocker.R;
import com.boyangsoft.zhxf.bylocker.activity.base.BaseActivity;
import com.boyangsoft.zhxf.bylocker.view.CustomPwdWidget;

public class GlPwdActivity extends BaseActivity {

    private TextView mTextView;
    private CustomPwdWidget customPwdWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gl_pwd);
        customPwdWidget = findViewById(R.id.pwdEdit);
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


    public void  pwd_confirm_click(View view){


        /**
         * 密码判断
         */
        String pwd = customPwdWidget.getText().toString();
        if(pwd.length()<6 || !pwd.equals("123456")){
            Toast.makeText(getApplicationContext(),"您输入的密码错误，请重新输入",Toast.LENGTH_LONG).show();
            customPwdWidget.setText("");
            customPwdWidget.setFocusable(true);
        }

        goToActivity(this, GlMainActivity.class, false);
    }


}