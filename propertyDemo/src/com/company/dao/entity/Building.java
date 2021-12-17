package com.company.dao.entity;

import java.util.Date;

public class Building {
    private int bid;
    private String buildingNum;
    private String name;
    private int roomNum;
    private String buildingDesc;
    private Date buildHiredate;
    private int cid;
    private String pic;

    public Building() {
    }

    public Building(int bid, String buildingNum, String name, int roomNum, String buildingDesc, Date buildHiredate, int cid, String pic) {
        this.bid = bid;
        this.buildingNum = buildingNum;
        this.name = name;
        this.roomNum = roomNum;
        this.buildingDesc = buildingDesc;
        this.buildHiredate = buildHiredate;
        this.cid = cid;
        this.pic = pic;
    }

    public Building(String buildingNum, String name, int roomNum, String buildingDesc, Date buildHiredate, int cid,String pic) {
        this.buildingNum = buildingNum;
        this.name = name;
        this.roomNum = roomNum;
        this.buildingDesc = buildingDesc;
        this.buildHiredate = buildHiredate;
        this.cid = cid;
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Building{" +
                "bid=" + bid +
                ", buildingNum='" + buildingNum + '\'' +
                ", name='" + name + '\'' +
                ", roomNum=" + roomNum +
                ", buildingDesc='" + buildingDesc + '\'' +
                ", buildHiredate=" + buildHiredate +
                ", cid=" + cid +
                ", pic=" + pic +
                '}';
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getBuildingDesc() {
        return buildingDesc;
    }

    public void setBuildingDesc(String buildingDesc) {
        this.buildingDesc = buildingDesc;
    }

    public Date getBuildHiredate() {
        return buildHiredate;
    }

    public void setBuildHiredate(Date buildHiredate) {
        this.buildHiredate = buildHiredate;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
