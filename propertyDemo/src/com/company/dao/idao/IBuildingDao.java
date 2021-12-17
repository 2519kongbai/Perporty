package com.company.dao.idao;

import com.company.dao.entity.Building;

import java.util.List;

public interface IBuildingDao {
    List<Building> findAll()throws Exception;

    int save(Building building)throws Exception;

    int delete(Building building)throws Exception;

    int update(Building building)throws Exception;

    int updatePic(String buildingNum, String filename)throws Exception;
}
