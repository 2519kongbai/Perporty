package com.company.test;

import com.company.comm.Const;
import com.company.dao.entity.Building;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IBuildingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildingServiceTest {
    IBuildingService buildingService;
    @BeforeEach
    void setUp() {
        buildingService = (IBuildingService) ServiceFactory.getInstance(Const.BUILDING);
    }

    @Test
    void findAll() {
        List<Building> buildings = buildingService.findAll();
        System.out.println(buildings.size());
    }

    @Test
    void save() {
        Building building = new Building(7,"1007","build_7",300,"dirty",new Date(2021-1-1),7,"null");
        System.out.println(buildingService.save(building));
    }

    @Test
    void delete() {
        Building building = new Building(7,"1007","build_7",300,"dirty",new Date(2021-1-1),7,"null");
        System.out.println(buildingService.delete(building));
    }

    @Test
    void update() {
        Building building = new Building(7,"1008","build_8",300,"dirty",new Date(2021-1-1),8,"null");
        System.out.println(buildingService.update(building));
    }
}