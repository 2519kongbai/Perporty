package com.company.test;

import com.company.comm.Const;
import com.company.dao.entity.Building;
import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IBuildingDao;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildingDaoTest {
    IBuildingDao buildingDao;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        buildingDao = (IBuildingDao) DaoFactory.getInstance(Const.BUILDING);
    }

    @org.junit.jupiter.api.Test
    void findAll() throws Exception {
        List<Building> buildings = buildingDao.findAll();
        System.out.println(buildings.size());
    }

    @org.junit.jupiter.api.Test
    void save() throws Exception {
        Building building = new Building(7,"1004","build_5",120,"dirty",new Date(2020-10-10),1,"null");
        int flag = buildingDao.save(building);
        System.out.println(flag);
    }

    @org.junit.jupiter.api.Test
    void delete() throws Exception {
        Building building = new Building(7,"1004","build_5",120,"dirty",new Date(2020-10-10),1,"null");
        int flag = buildingDao.delete(building);
        System.out.println(flag);
    }

    @org.junit.jupiter.api.Test
    void update() throws Exception {
        Building building = new Building(6,"1006","build_6",250,"clean",new Date(2021-10-10),6,"null");
        int flag = buildingDao.update(building);
        System.out.println(flag);
    }
}