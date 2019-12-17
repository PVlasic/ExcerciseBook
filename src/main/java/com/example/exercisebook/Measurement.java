package com.example.exercisebook;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.OffsetDateTime;

@Entity(tableName = "Measurement")
public class Measurement {
    @PrimaryKey(autoGenerate = true)
    private Integer Id;

    private Integer userId;


//date of taking the measurement
    //private OffsetDateTime date;

    private Double height;
    private Double weight;
    private Double shoulderWidth;
    private Double chestWidth;
    private Double waistWidth;
    private Double hipsWidth;
    private Double thighsWidth;
    private Double upperArmWidth;


    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
//    public OffsetDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(OffsetDateTime date) {
//        this.date = date;
//    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getShoulderWidth() {
        return shoulderWidth;
    }

    public void setShoulderWidth(Double shoulderWidth) {
        this.shoulderWidth = shoulderWidth;
    }

    public Double getChestWidth() {
        return chestWidth;
    }

    public void setChestWidth(Double chestWidth) {
        this.chestWidth = chestWidth;
    }

    public Double getWaistWidth() {
        return waistWidth;
    }

    public void setWaistWidth(Double waistWidth) {
        this.waistWidth = waistWidth;
    }

    public Double getHipsWidth() {
        return hipsWidth;
    }

    public void setHipsWidth(Double hipsWidth) {
        this.hipsWidth = hipsWidth;
    }

    public Double getThighsWidth() {
        return thighsWidth;
    }

    public void setThighsWidth(Double thighsWidth) {
        this.thighsWidth = thighsWidth;
    }

    public Double getUpperArmWidth() {
        return upperArmWidth;
    }

    public void setUpperArmWidth(Double upperArmWidth) {
        this.upperArmWidth = upperArmWidth;
    }



}
