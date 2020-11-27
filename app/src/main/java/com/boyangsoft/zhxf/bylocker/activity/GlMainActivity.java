package com.boyangsoft.zhxf.bylocker.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.boyangsoft.zhxf.bylocker.R;
import com.boyangsoft.zhxf.bylocker.activity.base.BaseActivity;
import com.boyangsoft.zhxf.bylocker.view.CustomPwdWidget;

public class GlMainActivity extends BaseActivity {

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


    public void  gl_main_data_click(View view){



    }

    public void  gl_main_sync_click(View view){



    }

    public void  gl_main_host_click(View view){



    }


}