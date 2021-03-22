package com.dmai.carreveal.base;

import com.dmai.carreveal.model.http.ApiService;
import com.dmai.carreveal.model.http.RetrofitHelper;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class BaseModel implements IModel {
//    private CompositeSubscription mCompositeSubscription;
    protected ApiService apiService;

    public BaseModel() {
        //初始化网络框架
        apiService = RetrofitHelper.getInstance().getApiService();
    }

//    @Override
//    public void unSubscribe() {
//        if (mCompositeSubscription != null && !mCompositeSubscription.isUnsubscribed()) {
//            mCompositeSubscription.clear();
//            mCompositeSubscription.unsubscribe();
//        }
//    }
//
//    @Override
//    public void addSubscribe(Subscription subscription) {
//        if (mCompositeSubscription == null) {
//            mCompositeSubscription = new CompositeSubscription();
//        }
//        mCompositeSubscription.add(subscription);
//    }
}
