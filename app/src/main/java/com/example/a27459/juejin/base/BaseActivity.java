package com.example.a27459.juejin.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(savedInstanceState);
    }

    private void initView(Bundle savedInstanceState) {
        loadViewLayout();
        processLogic(savedInstanceState);
        setListener();
    }

    /**
     * 加载布局
     */
    protected abstract void loadViewLayout();

    /**
     * 处理逻辑
     */
    protected abstract void processLogic(Bundle savedInstanceState);

    /**
     * 设置监听
     */
    protected abstract void setListener();

    }
