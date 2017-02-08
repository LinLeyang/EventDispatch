package com.penta.eventdispatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

/**
 * @author linyueyang
 *         <p>
 *         该工程使用了butterknife控件进行View绑定
 *         <p>
 *         工程目的是为了方便理解 OnTouch OnTouchEvent OnClick的调用关系
 *         <p>
 *         OnTouch 》 OnTouchEvent 》OnClick
 *         <p>
 *         拦截的标识就是返回值是否为true（true表示拦截）
 *         <p>
 *         前者拦截 后者就不会调用
 *         <p>
 *         Tips：OnTouchEvent必须要调用super方法才能调用到OnClick
 */
public class MainActivity extends AppCompatActivity {


    @BindView(R.id.TextView)
    TextView TextView;
    @BindView(R.id.ViewGroup2)
    LinearLayout ViewGroup2;
    @BindView(R.id.ViewGroup1)
    RelativeLayout ViewGroup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnTouch({R.id.TextView, R.id.ViewGroup2, R.id.ViewGroup1})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()) {
            case R.id.TextView:
                Log.e("TextView", "onTouch_" + motionEvent.getAction());
                break;
            case R.id.ViewGroup2:
                Log.e("ViewGroup2", "onTouch_" + motionEvent.getAction());
                break;
            case R.id.ViewGroup1:
                Log.e("ViewGroup1", "onTouch_" + motionEvent.getAction());
                break;
        }
        return false;
    }

    @OnClick({R.id.TextView, R.id.ViewGroup2, R.id.ViewGroup1})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.TextView:
                Log.e("TextView", "onClick");
                break;
            case R.id.ViewGroup2:
                Log.e("ViewGroup2", "onClick");
                break;
            case R.id.ViewGroup1:
                Log.e("ViewGroup1", "onClick");
                break;
        }
    }
}
