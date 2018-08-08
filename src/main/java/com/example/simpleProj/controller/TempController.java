package com.example.simpleProj.controller;

import com.example.simpleProj.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Kamarou_S on 01.08.2018.
 */
@RequestMapping("/api")
@RestController
public class TempController {
    @Autowired
    private MusicService musicService;

    @GetMapping("auth")
    public ResponseEntity<List<Object>> auth() {
        return new ResponseEntity<>(musicService.getList(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> testMethod(){
        return new ResponseEntity<String>("testMethod works",HttpStatus.OK);
    }
}
