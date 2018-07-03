package com.codegym.motel.repository;

import com.codegym.motel.model.Picture;

import java.util.List;

public interface PictureRepository {

    List<Picture> getByMotelId(int motelId) throws Exception;
    boolean add(String url, int motelId) throws Exception;

}
