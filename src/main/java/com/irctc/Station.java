/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.irctc;

/**
 *
 * @author santh
 */
public class Station {
    private String name;
    private String code;
    private int Id=0;
    private int Priority;
    private String stationName;

    public Station(String name, String code) {
        this.name = name;
        this.code = code;
    }
    
 public Station() {
        
    }
 
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int Priority) {
        this.Priority = Priority;
    }
    
}
