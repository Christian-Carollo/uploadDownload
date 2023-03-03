package co.develhope.uploadDownload.service;

import lombok.SneakyThrows;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("{fileRepositoryFolder}")
    private String fileRepositoryFolder;


    @SneakyThrows
    public String upload(MultipartFile file){
        String extension = FilenameUtils.getExtension( file.getOriginalFilename());
        String newFileName = UUID.randomUUID().toString()+ "." + extension;
        String completeFileName = newFileName + extension;
        File finalFolder = new File(fileRepositoryFolder);
        File finalDestination = new File( fileRepositoryFolder + "\\" + newFileName + "." + extension);
        if (!finalDestination.exists()) {
            throw new IOException("File conflict");
        }
        if(!finalFolder.exists()){
            throw new IOException("Folder not exists");
        }
        if(!finalFolder.isDirectory()){
            throw new IOException("Folder not a directory");
        }
        file.transferTo(finalDestination);
        return completeFileName;
    }

    @SneakyThrows
    public byte[] download(String fileName){
        File fileFromRepository = new File(fileRepositoryFolder + "\\" + fileName);
        if(!fileFromRepository.exists()){
            throw new IOException("File not exists");
        }
        return IOUtils.toByteArray(new FileInputStream(fileFromRepository));

    }
}
