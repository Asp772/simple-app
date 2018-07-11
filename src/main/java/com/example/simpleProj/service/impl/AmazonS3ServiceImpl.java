package com.example.simpleProj.service.impl;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.example.simpleProj.exception.CloudServiceUploadingException;
import com.example.simpleProj.service.CloudService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Kamarou_S on 10.07.2018.
 */

@Service
public class AmazonS3ServiceImpl implements CloudService {

    private final Environment environment;
    private final AWSCredentials credentials;
    private final AmazonS3 s3Client;

    @Autowired
    public AmazonS3ServiceImpl(Environment environment) {
        this.environment = environment;
        this.credentials = new BasicAWSCredentials(this.getAccessKey(), this.getSecretKey());
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(this.getBucketRegion())
                .withCredentials(new AWSStaticCredentialsProvider(this.credentials)).build();
    }

    private String getAccessKey() {
        return environment.getProperty("aws.key.access");
    }

    private String getSecretKey() {
        return environment.getProperty("aws.key.secret");
    }

    private String getBucketName() {
        return environment.getProperty("aws.bucket.name");
    }

    private String getBucketUrl() {
        return environment.getProperty("aws.bucket.url");
    }

    private String getBucketRegion() {
        return environment.getProperty("aws.bucket.region");
    }

    private static String md5Apache(String st) {
        String md5Hex = DigestUtils.md5Hex(st);
        return md5Hex;
    }

    private static File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        return file;
    }

    @Override
    public String uploadFile(MultipartFile file) throws CloudServiceUploadingException {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String fileName = file.getOriginalFilename();
            String folder = md5Apache(dateFormat.format(date));
            File receivedFile = convert(file);
            PutObjectResult result = s3Client.putObject(this.getBucketName() + '/' + folder, fileName, receivedFile);
            receivedFile.delete();
            s3Client.setObjectAcl(this.getBucketName(), folder + '/' + fileName, CannedAccessControlList.PublicRead);
            String resultURL = this.getBucketUrl() + this.getBucketName() + '/' + folder + '/' + fileName;
            return resultURL;
        } catch (AmazonServiceException e) {
            throw new CloudServiceUploadingException(e.getMessage());
        } catch (IOException e) {
            throw new CloudServiceUploadingException(e.getMessage());
        }
    }

    @Override
    public List<String> getAllFiles() {
        ListObjectsRequest req = new ListObjectsRequest().withBucketName(this.getBucketName());
        ObjectListing listing = s3Client.listObjects(req);
        for (String commonPrefix : listing.getCommonPrefixes()) {
            System.out.println(commonPrefix);
        }
        for (S3ObjectSummary summary : listing.getObjectSummaries()) {
            System.out.println(summary.toString());
        }
        return null;
    }

}