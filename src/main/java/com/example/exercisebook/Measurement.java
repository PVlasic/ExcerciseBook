package com.example.exercisebook;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Measurement")
public class Measurement {
    @PrimaryKey(autoGenerate = true)
    int Id;

    @ColumnInfo(name = "userId")
    int userId;

    //date of taking the measurement!!!!!!!!!!!!!!!!!!!!!!!!!!



    @ColumnInfo(name = "height")
    int height;

    @ColumnInfo(name = "weight")
    int weight;

    @ColumnInfo(name = "shoulderWidth")
    int shoulderWidth;

    @ColumnInfo(name = "chestWidth")
    int chestWidth;

    @ColumnInfo(name = "waistWidth")
    int waistWidth;

    @ColumnInfo(name = "hipsWidth")
    int hipsWidth;

    @ColumnInfo(name = "thighsWidth")
    int thighsWidth;

    @ColumnInfo(name = "upperArmWidth")
    int upperArmWidth;


    public int getId() {
        return Id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getShoulderWidth() {
        return shoulderWidth;
    }

    public void setShoulderWidth(int shoulderWidth) {
        this.shoulderWidth = shoulderWidth;
    }

    public int getChestWidth() {
        return chestWidth;
    }

    public void setChestWidth(int chestWidth) {
        this.chestWidth = chestWidth;
    }

    public int getWaistWidth() {
        return waistWidth;
    }

    public void setWaistWidth(int waistWidth) {
        this.waistWidth = waistWidth;
    }

    public int getHipsWidth() {
        return hipsWidth;
    }

    public void setHipsWidth(int hipsWidth) {
        this.hipsWidth = hipsWidth;
    }

    public int getThighsWidth() {
        return thighsWidth;
    }

    public void setThighsWidth(int thighsWidth) {
        this.thighsWidth = thighsWidth;
    }

    public int getUpperArmWidth() {
        return upperArmWidth;
    }

    public void setUpperArmWidth(int upperArmWidth) {
        this.upperArmWidth = upperArmWidth;
    }



}
