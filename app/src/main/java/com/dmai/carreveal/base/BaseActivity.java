package com.dmai.carreveal.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dmai.carreveal.MyApplication;
import com.dmai.carreveal.utils.ActivityCollecter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IView {
    protected P mPresenter;
    private Unbinder unbinder;
    protected Handler mainHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollecter.addActivity(this);
        setContentView(setLayoutId());
        unbinder = ButterKnife.bind(this);
        // 初始化Presenter
        initPresenter();
        initData();
    }

    private void initPresenter() {
        mPresenter = createPresenter();
        // 完成Presenter和view的绑定
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }


    /**
     * 注册返回主线程
     */
    protected void registerMainHandler() {
        if (mainHandler == null) {
            mainHandler = new Handler(getMainLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    onMainHandleMessage(msg);
                }
            };
        }
    }

    /**
     * 主线程数据处理
     *
     * @param msg
     */
    protected void onMainHandleMessage(Message msg) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollecter.removeActivity(this);
        // 将Presenter和view解绑
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        // 解绑ButterKnife
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    /**
     * 页面初始化数据
     */
    protected abstract void initData();

    /**
     * 创建Presenter
     */
    protected abstract P createPresenter();

    /**
     * 设置activity layout id
     */
    protected abstract int setLayoutId();

    /**
     * 弹出Toast
     */
    public void makeToast(String msg) {
        Toast.makeText(MyApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
