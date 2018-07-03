package com.codegym.motel.service.impl;

import com.codegym.motel.model.Picture;
import com.codegym.motel.repository.PictureRepository;
import com.codegym.motel.service.PictureService;

import java.util.List;

public class PictureServiceImpl implements PictureService {

    private PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<Picture> getByMotelId(int motelId) throws Exception {
        return pictureRepository.getByMotelId(motelId);
    }

    @Override
    public boolean add(String url, int motelId) throws Exception {
        return pictureRepository.add(url, motelId);
    }
}
