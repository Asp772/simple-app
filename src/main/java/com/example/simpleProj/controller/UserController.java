package com.example.simpleProj.controller;

import com.example.simpleProj.model.Image;
import com.example.simpleProj.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Kamarou_S on 29.06.2018.
 */
@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    private ImageService imageService;

    @Value("${spring.datasource.username}")
    private String dbusername;

    @GetMapping("get")
    public ResponseEntity<List<Image>> getMethod() {
        return new ResponseEntity<>(imageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("killDB")
    public ResponseEntity<Void> killCon() {

        System.out.println(dbusername);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
