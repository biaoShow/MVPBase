package com.dmai.carreveal.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V extends IView, M extends IModel> implements IPresenter<V> {
    protected M mModel;
    private WeakReference<V> weakReference;
    protected CompositeDisposable composite;

    @Override
    public void attachView(V view) {
        // 使用弱引用持有view对象，防止内存泄漏
        weakReference = new WeakReference<>(view);
        composite = new CompositeDisposable();//网络请求管理
        if (this.mModel == null) {
            this.mModel = createModule();
        }
    }

    @Override
    public void detachView() {
        if (isViewAttach()) {
            weakReference.clear();
            weakReference = null;
        }
        if (mModel != null) {
//            mModel.unSubscribe();
            mModel = null;
        }
        //清楚还未完成的网络请求
        if (composite != null) {
            composite.clear();
        }
    }

    @Override
    public boolean isViewAttach() {
        return weakReference != null && weakReference.get() != null;
    }

    protected V getView() {
        return weakReference.get();
    }

    /**
     * 由外部创建 module
     *
     * @return module
     */
    protected abstract M createModule();
}
