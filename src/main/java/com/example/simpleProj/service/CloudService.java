package com.example.simpleProj.service;

import com.example.simpleProj.exception.CloudServiceUploadingException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * Created by Kamarou_S on 10.07.2018.
 */
public interface CloudService {
    String uploadFile(MultipartFile file) throws CloudServiceUploadingException;

    List<String> getAllFiles();

}
