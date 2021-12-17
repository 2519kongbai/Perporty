package com.company.service.impl;

import com.company.comm.Const;
import com.company.dao.entity.Building;
import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IBuildingDao;
import com.company.service.iservice.IBuildingService;

import java.util.List;

public class BuildingService implements IBuildingService {
    IBuildingDao buildingDado;

    public BuildingService() {
        buildingDado = (IBuildingDao) DaoFactory.getInstance(Const.BUILDING);
    }

    @Override
    public List<Building> findAll() {
        List<Building> buildings = null;
        try {
            buildings = buildingDado.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buildings;
    }

    @Override
    public int save(Building building) {
        int flag = 0;
        try {
            flag = buildingDado.save(building);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int delete(Building building) {
        int flag = 0;
        try {
            flag = buildingDado.delete(building);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int update(Building building) {
        int flag = 0;
        try {
            flag = buildingDado.update(building);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int updatePic(String buildingNum, String filename) {
        int flag = 0;
        try {
            flag = buildingDado.updatePic(buildingNum,filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
