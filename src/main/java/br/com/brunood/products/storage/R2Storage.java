package br.com.brunood.products.storage;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

@Component
public class R2Storage implements StorageInterface {

    private final AwsClientBuilder.EndpointConfiguration endpointConfiguration;
    private final AWSStaticCredentialsProvider awsStaticCredentialsProvider;
    private final String bucket;

    private AmazonS3 client;

    private R2Storage(@Value("${r2.apiurl}") String apiUrl, @Value("${r2.accesskey}") String accessKey, @Value("${r2.secretkey}") String secretKey, @Value("${r2.bucket}") String bucket) {
        this.endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(apiUrl, "auto");
        this.awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey));
        this.bucket = bucket;
        this.initialize();
    }

    @Override
    public void initialize() {
        client = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(this.endpointConfiguration)
                .withCredentials(this.awsStaticCredentialsProvider)
                .build();
    }

    @Override
    public void uploadFile(String filename, File file) {
        this.client.putObject(new PutObjectRequest(this.bucket, filename, file));
    }

    @Override
    public void deleteFile(String filename) {
        this.client.deleteObject(new DeleteObjectRequest(this.bucket, filename));
    }

    @Override
    public ObjectMetadata getMetadata(String filename) {
        return this.client.getObject(new GetObjectRequest(this.bucket, filename)).getObjectMetadata();
    }

    @Override
    public byte[] downloadFile(String filename, File file) throws IOException {
        S3Object object = this.client.getObject(new GetObjectRequest(this.bucket, filename));


        return object.getObjectContent().readAllBytes();
    }
}
