package com.dmai.carreveal.presenter;

import android.text.TextUtils;

import com.dmai.carreveal.base.BasePresenter;
import com.dmai.carreveal.contract.MainContract;
import com.dmai.carreveal.model.MainModel;
import com.dmai.carreveal.model.bean.BaseBean;
import com.dmai.carreveal.model.bean.LoginBean;
import com.dmai.carreveal.view.activity.MainActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainActivity, MainModel> implements MainContract.Presenter {
    @Override
    protected MainModel createModule() {
        return new MainModel();
    }


    @Override
    public void login(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            getView().makeToast("username/password is null");
            return;
        }
        mModel.login(username, password).subscribeOn(Schedulers.io())//子线程请求网络
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(new DefaultObserver<BaseBean<LoginBean>>() {

                    @Override
                    protected void onStart() {
                        super.onStart();
                        getView().showLoading();
                    }

                    @Override
                    public void onNext(@NonNull BaseBean<LoginBean> loginBeanBaseBean) {
                        getView().onSuccess(loginBeanBaseBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getView().onFail(e, "", e.getMessage());
                        getView().dismissLoading();
                    }

                    @Override
                    public void onComplete() {
                        getView().dismissLoading();
                    }
                });
    }

    @Override
    public void insert() {
        long l = mModel.insert();
        if (l > 0) {
            getView().makeToast("数据插入成功！");
        } else {
            getView().makeToast("数据插入失败！");
        }
    }
}
