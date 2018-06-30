package com.example.simpleProj.controller;

import com.example.simpleProj.model.Image;
import com.example.simpleProj.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping(value = "saveImage", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveObj(@RequestParam("file") MultipartFile file, @RequestParam("filename") String filename) throws IOException
    {
       /* try {
            String imgURL = serviceFactory.getAwsService().putObject(convert(file), filename);

            String resultURL=serviceFactory.getAwsService().getAWSUrl()+"/"+serviceFactory.getAwsService().getAWSBucketName()+"/"+imgURL;



            return new ResponseEntity<>(gson.toJson(user), HttpStatus.CREATED);
        }catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);


        }catch (AmazonS3Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }*/
        return new ResponseEntity<>("good", HttpStatus.CREATED);
    }
}
