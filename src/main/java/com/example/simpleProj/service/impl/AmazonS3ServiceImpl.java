package com.example.simpleProj.service.impl;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.example.simpleProj.service.CloudService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by Kamarou_S on 10.07.2018.
 */

@Service
public class AmazonS3ServiceImpl implements CloudService {
    /*@Autowired
    private Environment environment;
    private String AWSaccessKey;
    private String AWSSecretKey;
    private String AWSBucketName;
    private AWSCredentials Credentials;
    private AmazonS3 s3Client;

    private final Environment environment1;

    @Autowired
    public AmazonS3ServiceImpl(Environment environment) {
        this.environment1 = environment;
        System.out.println(this.getAWSaccessKey());
    }

    public String getAWSaccessKey() {
        return environment.getProperty("AWSAccessKeyId");
    }


    public String getAWSSecretKey() {
        return environment.getProperty("AWSSecretKey");
    }

    public String getAWSBucketName() {
        return environment.getProperty("AWSBucketName");
    }

    public String getAWSUrl() {
        return environment.getProperty("AWSUrl");
    }*/
    /*

    public static String md5Apache(String st) {
        String md5Hex = DigestUtils.md5Hex(st);

        return md5Hex;
    }

    public String putObject(File file, String fileName) throws AmazonServiceException {
        PutObjectResult result = null;

     *//*   AWSaccessKey = env.getProperty("AWSAccessKeyId");
        AWSSecretKey = env.getProperty("AWSSecretKey");
        AWSBucketName = env.getProperty("AWSBucketName");*//*
        //  Credentials = new BasicAWSCredentials(AWSaccessKey, AWSSecretKey);
        Credentials = new BasicAWSCredentials(getAWSaccessKey(), getAWSSecretKey());
        s3Client = new AmazonS3Client(Credentials);
        String resultURL= md5Apache(fileName);
        result = s3Client.putObject(getAWSBucketName(), resultURL, (File) file);
        //  result = s3Client.putObject(AWSBucketName, fileName, (File) file);
        return resultURL;
    }

*/

    @Override
    public String uploadFile(File file) {
        return null;
    }

    @Override
    public String testMethod() {
        System.out.println();
        System.out.println("1");
        return null;
    }
}