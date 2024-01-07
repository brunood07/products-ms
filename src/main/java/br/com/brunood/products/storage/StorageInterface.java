package br.com.brunood.products.storage;

import com.amazonaws.services.s3.model.ObjectMetadata;

import java.io.File;
import java.io.IOException;

public interface StorageInterface {
    void uploadFile(String identifier, File file);
    void deleteFile(String identifier);
    ObjectMetadata getMetadata(String identifier);
    void initialize();
    byte[] downloadFile(String identifier, File file) throws IOException;
}
