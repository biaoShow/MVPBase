package com.dmai.carreveal.base;


import rx.Subscription;

public interface IModel {

    //Rxjava避免内存泄漏
    void unSubscribe();

    void addSubscribe(Subscription subscription);
}
