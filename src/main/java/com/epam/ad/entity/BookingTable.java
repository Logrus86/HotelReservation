package com.epam.ad.entity;

import com.epam.ad.dao.Identified;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Askar on 06.08.2014.
 */
public class BookingTable implements Identified<Integer> {
    private int id;
    private Integer roomNo;
    private Date dateFrom;
    private Date dateTo;
    private int dayCount;
    public static List<BookingTable>tableList=new ArrayList<BookingTable>();

    public List<BookingTable> getTableList() {
        return tableList;
    }

    public void setTableList(List<BookingTable> tableList) {
        this.tableList = tableList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }
}
