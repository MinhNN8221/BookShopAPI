package com.example.bookshopapi.util;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;


public class MultilPartFile {
    public MultipartFile createMultipartFileFromUrl(String base64String, String fileName) {
        try {
            // Decode the Base64 string into a byte array
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);

            // Create a MockMultipartFile object
            MultipartFile multipartFile = new MockMultipartFile(fileName, decodedBytes);

            return multipartFile;
        } catch (Exception e) {
            // Handle exceptions, e.g., invalid base64String
            e.printStackTrace();
            return null;
        }
    }

}
