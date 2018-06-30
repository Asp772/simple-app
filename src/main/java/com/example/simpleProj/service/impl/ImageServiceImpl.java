package com.example.simpleProj.service.impl;

import com.example.simpleProj.model.Image;
import com.example.simpleProj.repository.ImageRepository;
import com.example.simpleProj.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kamarou_S on 29.06.2018.
 */

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;


    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }
}
