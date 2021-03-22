package com.dmai.carreveal.model;

import com.dmai.carreveal.base.BaseModel;
import com.dmai.carreveal.contract.MainContract;
import com.dmai.carreveal.model.bean.BaseBean;
import com.dmai.carreveal.model.bean.LoginBean;
import com.dmai.carreveal.model.db.DataBaseManager;
import com.dmai.carreveal.model.http.RequestData;
import com.dmai.carreveal.model.http.RetrofitHelper;

import io.reactivex.Observable;

public class MainModel extends BaseModel implements MainContract.Model {
    @Override
    public Observable<BaseBean<LoginBean>> login(String username, String password) {
        return RetrofitHelper.getInstance().getApiService().login(RequestData.getLoginMap(username, password));
    }

    @Override
    public long insert() {
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername("liyuanbiao");
        loginBean.setPassword("123456");
        return DataBaseManager.getInstance().getDaoSession().getLoginBeanDao().insert(loginBean);
    }
}
