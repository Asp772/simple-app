package com.example.simpleProj.service;

import com.example.simpleProj.exception.MusicSourceAccessException;

import java.util.List;

/**
 * Created by Kamarou_S on 01.08.2018.
 */
public interface MusicService {
    void logon();
    List<Object> getList();
    List<Object> getQueryResult(String query, int offset) throws MusicSourceAccessException;
}
