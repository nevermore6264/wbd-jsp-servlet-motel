package com.codegym.motel.model;

public class MotelDisplay {

    private int id;
    private String categoryId;
    private String locationId;
    private int area;
    private float price;
    private String url;
    private String description;
    private float electricPrice;
    private float internetPrice;
    private float waterPrice;
    private String status;
    private String desCate;

    public MotelDisplay(){

    }

    public MotelDisplay(int id, String categoryId, String locationId, int area, float price, String url, String description, float electricPrice, float internetPrice, float waterPrice, String status, String desCate) {
        this.id = id;
        this.categoryId = categoryId;
        this.locationId = locationId;
        this.area = area;
        this.price = price;
        this.url = url;
        this.description = description;
        this.electricPrice = electricPrice;
        this.internetPrice = internetPrice;
        this.waterPrice = waterPrice;
        this.status = status;
        this.desCate = desCate;
    }

    public String getDesCate() {
        return desCate;
    }

    public void setDesCate(String desCate) {
        this.desCate = desCate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getElectricPrice() {
        return electricPrice;
    }

    public void setElectricPrice(float electricPrice) {
        this.electricPrice = electricPrice;
    }

    public float getInternetPrice() {
        return internetPrice;
    }

    public void setInternetPrice(float internetPrice) {
        this.internetPrice = internetPrice;
    }

    public float getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(float waterPrice) {
        this.waterPrice = waterPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
