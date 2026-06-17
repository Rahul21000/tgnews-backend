package com.tgnews.tgnews_api.utils;

import com.tgnews.tgnews_api.exception.ImageUploadException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class ImageUploadUtil {

    private static final String UPLOAD_DIR = "uploads/";

    public String uploadImage(MultipartFile image) {

       try{
           String fileName = UUID.randomUUID() + "_" + image.getOriginalFilename();

           Path uploadPath = Paths.get(UPLOAD_DIR);

           if (!Files.exists(uploadPath)) {
               Files.createDirectories(uploadPath);
           }

           Path filePath = uploadPath.resolve(fileName);

           Files.copy(image.getInputStream(), filePath);

           return filePath.toString();
       } catch (IOException ex){
           throw new ImageUploadException("Failed to upload image");
       }
    }
}
