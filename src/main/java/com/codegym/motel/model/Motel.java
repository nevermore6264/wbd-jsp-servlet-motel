package com.codegym.motel.model;

public class Motel {
    private int id;
    private int categoryId;
    private int userId;
    private int locationId;
    private int area;
    private float price;
    private String description;
    private float electricPrice;
    private float internetPrice;
    private float waterPrice;
    private int status;

    public Motel() {
    }

    public Motel(int categoryId, int userId, int locationId, int area, float price, String description, float electricPrice, float internetPrice, float waterPrice, int status) {
        this.categoryId = categoryId;
        this.userId = userId;
        this.locationId = locationId;
        this.area = area;
        this.price = price;
        this.description = description;
        this.electricPrice = electricPrice;
        this.internetPrice = internetPrice;
        this.waterPrice = waterPrice;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Motel{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", userId=" + userId +
                ", locationId=" + locationId +
                ", area=" + area +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", electricPrice=" + electricPrice +
                ", internetPrice=" + internetPrice +
                ", waterPrice=" + waterPrice +
                ", status=" + status +
                '}';
    }
}