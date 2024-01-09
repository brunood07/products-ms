package br.com.brunood.products.usecases;

import br.com.brunood.products.storage.R2Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class DownloadProductImageUseCase {

    @Autowired
    private R2Storage r2Storage;

    public byte[] execute(String filename) throws IOException {
        var file = new File(filename);

        return this.r2Storage.downloadFile(filename, file);
    }
}
