package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@Service
public class S3Wrapper {

    @Autowired
    private AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public List<S3ObjectSummary> list() {
        ObjectListing objectListing = amazonS3Client.listObjects(new ListObjectsRequest().withBucketName(bucket));

        List<S3ObjectSummary> s3ObjectSummaries = objectListing.getObjectSummaries();

        return s3ObjectSummaries;
    }
}