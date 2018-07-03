package com.codegym.motel.service;

import com.codegym.motel.model.Picture;

import java.util.List;

public interface PictureService {

    List<Picture> getByMotelId(int motelId) throws Exception;
    boolean add(String url, int motelId) throws Exception;

}
