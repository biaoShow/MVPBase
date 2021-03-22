package com.dmai.carreveal.contract;

import com.dmai.carreveal.model.bean.BaseBean;
import com.dmai.carreveal.model.bean.LoginBean;

import io.reactivex.Observable;


public interface MainContract {
    interface Model {
        Observable<BaseBean<LoginBean>> login(String username, String password);//登录接口

        long insert();
    }

    interface View {
        void onSuccess(BaseBean<LoginBean> bean);//网络请求成功
    }

    interface Presenter {
        void login(String username, String password);

        void insert();
    }
}
