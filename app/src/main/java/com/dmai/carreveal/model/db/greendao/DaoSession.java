package com.dmai.carreveal.model.db.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.dmai.carreveal.model.bean.LoginBean;

import com.dmai.carreveal.model.db.greendao.LoginBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig loginBeanDaoConfig;

    private final LoginBeanDao loginBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        loginBeanDaoConfig = daoConfigMap.get(LoginBeanDao.class).clone();
        loginBeanDaoConfig.initIdentityScope(type);

        loginBeanDao = new LoginBeanDao(loginBeanDaoConfig, this);

        registerDao(LoginBean.class, loginBeanDao);
    }
    
    public void clear() {
        loginBeanDaoConfig.clearIdentityScope();
    }

    public LoginBeanDao getLoginBeanDao() {
        return loginBeanDao;
    }

}
