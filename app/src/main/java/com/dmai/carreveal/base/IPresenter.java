package com.dmai.carreveal.base;

public interface IPresenter<V extends IView> {
    /**
     * 绑定view
     * @param view view
     */
    void attachView(V view);

    /**
     * 分离view
     */
    void detachView();
    /**
     * 判断view是否已经销毁
     * @return true 未销毁
     */
    boolean isViewAttach();
}
