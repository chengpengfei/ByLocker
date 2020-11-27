package com.boyangsoft.zhxf.bylocker.activity.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



/**
 * 所有Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = getClass().getSimpleName();

    private ProgressDialog mProgressDialog;
    public int screenW = 0;//屏幕分辨率w
    public int screenH = 0;//屏幕分辨率w
    //public DemoConfig demoConfig;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateConfig();
        init();
    }


    public void updateConfig() {
        /**
        demoConfig = SharedPrefUtils.getObject(getApplicationContext(), "BY_FACE_CONFIG", DemoConfig.class);
        if (demoConfig == null) {
            demoConfig = new DemoConfig();
        }
         **/
    }


    public void init() {
        //获取屏幕分辨率
        /**
        screenW = DisplayUtil.getDisplayMetrics(getApplicationContext()).widthPixels;
        screenH = DisplayUtil.getDisplayMetrics(getApplicationContext()).heightPixels;
        initView();
        initData();
        initEvent();
        hideBottomUIMenu();
         **/
    }


    @Override
    protected void onResume() {
        hideBottomUIMenu();
        updateConfig();
        updateAppOrientation();
        super.onResume();
    }


    public void updateAppOrientation() {

        //if (demoConfig.AppOrientation != DemoConfig.AUTO) {
            //设置横竖屏
            /**
            if (getRequestedOrientation() != demoConfig.AppOrientation) {
                setRequestedOrientation(demoConfig.AppOrientation);
            }
             **/
        //}

    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initEvent();

    /**
     * 显示ShortToast
     *
     * @param context
     * @param content
     */
    public void showShortToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示LongToast
     *
     * @param context
     * @param content
     */
    protected void showLongToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_LONG).show();
    }

    /**
     * 显示进度对话框不可手动取消
     */
    protected void showProgressDialog(Context context, String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, ProgressDialog.THEME_HOLO_LIGHT);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setMessage(message);
        }
        mProgressDialog.show();
    }

    /**
     * 显示进度对话框可手动取消
     */
    protected void showCancelableProgressDialog(Context context, String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, ProgressDialog.THEME_HOLO_LIGHT);
            mProgressDialog.setCancelable(true);
            mProgressDialog.setCanceledOnTouchOutside(true);
            mProgressDialog.setMessage(message);
        }
        mProgressDialog.show();
    }

    /**
     * 取消显示进度对话框
     */
    protected void dismissProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }


    protected void hideBottomUIMenu() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE);//API19
        } else {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
            );
        }
    }

    protected void goToActivity(Activity activity, Class<?> cls, boolean finish, int... requestCode) {
        Intent intent = new Intent(activity, cls);
        if (requestCode.length != 0) startActivityForResult(intent, requestCode[0]);
        else activity.startActivity(intent);
        if (finish) activity.finish();
    }

    protected void hideView(boolean isShow, View... views) {
        if (views != null) {
            for (View v : views) {
                if (v == null) continue;
                v.setVisibility(!isShow ? View.VISIBLE : View.GONE);
            }
        }
    }

    public int getDisplayOrientation(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int degrees = 0;
        switch (rotation) {
            case Surface.ROTATION_0:
                degrees = 0;
                break;
            case Surface.ROTATION_90:
                degrees = 90;
                break;
            case Surface.ROTATION_180:
                degrees = 180;
                break;
            case Surface.ROTATION_270:
                degrees = 270;
                break;
        }
        return degrees;
    }
}
