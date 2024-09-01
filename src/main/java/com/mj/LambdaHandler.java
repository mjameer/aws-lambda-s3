package com.mj;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class LambdaHandler implements RequestHandler<S3Event, String> {

    @Override
    public String handleRequest(S3Event s3event, Context context) {

        LambdaLogger lambdaLogger = context.getLogger();
        try {
            //check if are getting any record
            if(s3event.getRecords().isEmpty()){
                lambdaLogger.log("No records found");
                return "No records found";
            }

            //process the records
            for(S3EventNotification.S3EventNotificationRecord record: s3event.getRecords()){
                String srcBucket = record.getS3().getBucket().getName();
                String srcKey = record.getS3().getObject().getUrlDecodedKey();

                //1. we create S3 client
                //2. invoking GetObject
                //3. processing the InputStream from S3
                lambdaLogger.log("Processing file from S3 bucket: " + srcBucket + ", key: " + srcKey);
                // Download the CSV file from S3
                S3Client s3Client = S3Client.builder().build();

                // Download the CSV file from S3
                GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                        .bucket(srcBucket)
                        .key(srcKey)
                        .build();
                GetObjectResponse getObjectResponse = s3Client.getObject(getObjectRequest).response();

                // Obtain the input stream of the S3 object
                try (var s3Object = s3Client.getObject(getObjectRequest);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(s3Object, StandardCharsets.UTF_8))) {

                    String line;
                    while ((line = reader.readLine()) != null) {
                        processLine(line, lambdaLogger);
                    }
                }

                lambdaLogger.log("Successfully processed the file.");


                return "Ok";
            }
            return "Ok";

        } catch (Exception e) {
            lambdaLogger.log("Error occurred in Lambda:" + e.getMessage());
            return "Error occurred in Lambda:" + e.getMessage();
        }
    }


    private void processLine(String line, LambdaLogger lambdaLogger) {
        // Implement your CSV processing logic here
        // For example, split the line by commas and process fields
        String[] fields = line.split(",");
        for (String field : fields) {
            lambdaLogger.log("Field: " + field);
        }
    }

    private HeadObjectResponse getHeadObject(S3Client s3Client, String bucket, String key) {
        HeadObjectRequest headObjectRequest = HeadObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .build();
        return s3Client.headObject(headObjectRequest);
    }
}