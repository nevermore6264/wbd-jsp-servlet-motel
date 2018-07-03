package com.codegym.motel.model;

public class Picture {
    private int motelId;
    private String url;

    public Picture(){
    }

    public Picture(int motelId, String url) {
        this.motelId = motelId;
        this.url = url;
    }

    public int getMotelId() {
        return motelId;
    }

    public void setMotelId(int motelId) {
        this.motelId = motelId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "motelId=" + motelId +
                ", url='" + url + '\'' +
                '}';
    }
}
