package com.dmai.carreveal.model.db;

import com.dmai.carreveal.MyApplication;
import com.dmai.carreveal.model.db.greendao.DaoMaster;
import com.dmai.carreveal.model.db.greendao.DaoSession;

public class DataBaseManager {
    private static DataBaseManager dataBaseManager;
    private DaoMaster.DevOpenHelper devOpenHelper;
    private DaoSession daoSession;

    private DataBaseManager() {
        devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getContext(), "my-db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public static DataBaseManager getInstance() {
        if (dataBaseManager == null) {
            synchronized (DataBaseManager.class) {
                if (dataBaseManager == null) {
                    dataBaseManager = new DataBaseManager();
                }
            }
        }
        return dataBaseManager;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
