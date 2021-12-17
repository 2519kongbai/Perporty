package com.company.service.iservice;

import com.company.dao.entity.Building;

import java.util.List;

public interface IBuildingService {
    public List<Building> findAll();

    int save(Building building);

    int delete(Building building);

    int update(Building building);

    int updatePic(String buildingNum, String filename);
}
