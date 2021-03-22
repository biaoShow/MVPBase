package com.dmai.carreveal.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IView, M extends IModel> implements IPresenter<V> {
    protected M mModel;
    private WeakReference<V> weakReference;

    @Override
    public void attachView(V view) {
        // 使用弱引用持有view对象，防止内存泄漏
        weakReference = new WeakReference<>(view);
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
            mModel.unSubscribe();
            mModel = null;
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
