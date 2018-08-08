package com.example.simpleProj.controller;

import com.example.simpleProj.exception.MusicSourceAccessException;
import com.example.simpleProj.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Kamarou_S on 08.08.2018.
 */
@RequestMapping("/api/music")
@RestController
public class AudioController {
    @Autowired
    private MusicService musicService;

    @GetMapping("find")
    public ResponseEntity<List<Object>> findBy(@RequestParam("by") String findParam, @RequestParam("offset") int offset) {

        try {
            List<Object> list = musicService.getQueryResult(findParam, offset);
            if (list == null || list.size() == 0)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (MusicSourceAccessException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
