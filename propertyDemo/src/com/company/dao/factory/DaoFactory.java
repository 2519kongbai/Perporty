package com.company.dao.factory;

import com.company.dao.impl.BuildingDao;

public class DaoFactory {
    public static Object getInstance(String name){
        switch(name){
            case "build":
                return new BuildingDao();
            default:
                return null;
        }
    }
}
