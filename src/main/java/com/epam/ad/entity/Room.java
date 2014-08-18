package com.epam.ad.entity;

import com.epam.ad.dao.Identified;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Askar on 04.08.2014.
 */
public class Room implements Identified<Integer> {
    private int id;
    private int roomNo;
    private  String roomType;
    private  int roomRate;
    private String roomBed;
    private List<Room> rooms=new ArrayList<Room>();


    public int getRoomNo() {
        return roomNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(int roomRate) {
        this.roomRate = roomRate;
    }

    public String getRoomBed() {
        return roomBed;
    }

    public void setRoomBed(String roomBed) {
        this.roomBed = roomBed;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }


    @Override
      public Integer getId() {
        return id;
    }
}
