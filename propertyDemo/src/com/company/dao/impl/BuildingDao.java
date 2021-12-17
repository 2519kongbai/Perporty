package com.company.dao.impl;

import com.company.dao.Util.DBUtil;
import com.company.dao.entity.Building;
import com.company.dao.idao.IBuildingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BuildingDao implements IBuildingDao {
    @Override
    public List<Building> findAll() throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select bid,buildingNum,name,roomNum,buildingDesc,buildHiredate,cid,pic from db_building";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        // java.lang.NullPointerException
        // 在此处创建列表对象时，直接给其赋了null 使得产生了空指针异常
        List<Building> buildings = new ArrayList<>();
        while(rs.next()){
            buildings.add(new Building(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDate(6),rs.getInt(7),rs.getString(8)));
        }
        DBUtil.close(null,ps,con);
        return buildings;
    }

    @Override
    public int save(Building building) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "insert into db_building(bid,buildingNum,name,roomNum,buildingDesc,buildHiredate,cid) values (?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,building.getBid());
        ps.setString(2,building.getBuildingNum());
        ps.setString(3,building.getName());
        ps.setInt(4,building.getRoomNum());
        ps.setString(5,building.getBuildingDesc());
        // java.lang.ClassCastException: java.util.Date cannot be cast to java.sql.Date
        // 时间出现问题，显示java util date 无法转换成 java sql date
        ps.setDate(6, new java.sql.Date(building.getBuildHiredate().getTime()));
        ps.setInt(7,building.getCid());
        int flag = ps.executeUpdate();
        DBUtil.close(null,ps,con);
        return flag;
    }

    @Override
    public int delete(Building building) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "delete from db_building where bid=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,building.getBid());
        int flag = ps.executeUpdate();
        DBUtil.close(null,ps,con);
        return flag;
    }

    @Override
    public int update(Building building) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "update db_building set buildingNum=?,name=?,roomNum=?,buildingDesc=?,buildHiredate=?,cid=? where bid=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,building.getBuildingNum());
        ps.setString(2,building.getName());
        ps.setInt(3,building.getRoomNum());
        ps.setString(4,building.getBuildingDesc());
        ps.setDate(5, new java.sql.Date(building.getBuildHiredate().getTime()));
        ps.setInt(6,building.getCid());
        ps.setInt(7,building.getBid());
        int flag = ps.executeUpdate();
        DBUtil.close(null,ps,con);
        return flag;
    }

    @Override
    public int updatePic(String buildingNum, String filename) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "update db_building set pic=? where buildingNum=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,filename);
        ps.setString(2,buildingNum);
        int flag = ps.executeUpdate();
        System.out.println(flag);
        DBUtil.close(null,ps,con);
        return flag;
    }
}
