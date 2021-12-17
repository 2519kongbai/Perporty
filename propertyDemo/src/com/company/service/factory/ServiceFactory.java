package com.company.service.factory;

import com.company.service.impl.BuildingService;

public class ServiceFactory {
    public static Object getInstance(String name){
        switch(name){
            case "build":
                return new BuildingService();
            default:
                return null;
        }
    }
}
