package com.codegym.motel.model;

public class Location {
    private int id;
    private String county;
    private String district;
    private String street;
    private String apartmentNumber;

    public Location() {
    }

    public Location(String county, String district, String street, String apartmentNumber){
        this.county = county;
        this.district = district;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String ward) {
        this.district = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return apartmentNumber +" "+street+" "+district+" "+county;
    }
}
