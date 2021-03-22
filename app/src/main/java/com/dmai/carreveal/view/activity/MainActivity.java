package com.dmai.carreveal.view.activity;


import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.dmai.carreveal.R;
import com.dmai.carreveal.base.BaseActivity;
import com.dmai.carreveal.contract.MainContract;
import com.dmai.carreveal.model.bean.BaseBean;
import com.dmai.carreveal.model.bean.LoginBean;
import com.dmai.carreveal.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {
    private static final String TAG = "MainActivity";
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_test)
    Button btnTest;
    @BindView(R.id.but_insert)
    Button butInsert;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        //密文显示
        etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    @Override
    public void showLoading() {
        Log.e(TAG, "showLoading");
    }

    @Override
    public void dismissLoading() {
        Log.e(TAG, "dismissLoading");
    }

    @Override
    public void onFail(Throwable ex, String code, String msg) {
        Log.e(TAG, msg);
    }

    @Override
    public void onNetError() {
        Log.e(TAG, "onNetError");
    }

    @Override
    public void onSuccess(BaseBean<LoginBean> bean) {
        Log.e(TAG, "onSuccess");
    }

    @OnClick({R.id.btn_test, R.id.but_insert})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test:
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                mPresenter.login(username, password);
                break;
            case R.id.but_insert:
                mPresenter.insert();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}