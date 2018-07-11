package com.example.simpleProj.controller;

import com.example.simpleProj.exception.CloudServiceUploadingException;
import com.example.simpleProj.model.Image;
import com.example.simpleProj.service.CloudService;
import com.example.simpleProj.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sergei Komarov on 30.06.2018.
 */
@RequestMapping("/api")
@RestController
public class ImageController {


    @Autowired
    private ImageService imageService;

    @Autowired
    private CloudService cloudService;

    @PostMapping(value = "saveFile", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveObj(@RequestParam("file") MultipartFile file) {
        try {
            String result = cloudService.uploadFile(file);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (CloudServiceUploadingException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Image>> getAll() {
        List<Image> list = imageService.findAll();

        return new ResponseEntity<List<Image>>(list, HttpStatus.OK);
    }
}
