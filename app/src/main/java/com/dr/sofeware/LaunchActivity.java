package com.dr.sofeware;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.dr.sofeware.databinding.ActivityLaunchBinding;
import com.dr.sofeware.databinding.ActivityMainBinding;

/**
 * @Description TODO
 * @systemUser admin
 * @Author DR.LHXY
 * @Date 11-12-2022 周六 15:53
 */
public class LaunchActivity extends Activity {

    private static final int sleepTime = 800;

    @Override
    protected void onCreate(Bundle arg0) {
        final View view = View.inflate(this, R.layout.activity_launch, null);
        setContentView(view);
        super.onCreate(arg0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                long costTime = System.currentTimeMillis() - start;
                //等待sleeptime时长
                if (sleepTime - costTime > 0) {
                    try {
                        Thread.sleep(sleepTime - costTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //进入主页面
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                finish();
            }
        }).start();
    }
}

