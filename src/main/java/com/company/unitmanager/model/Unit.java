package com.company.unitmanager.model;

public class Unit {
    private String name;
    private String address;
    private int id;

    public Unit(String name, String city) {
        this.name = name;
        this.address = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
