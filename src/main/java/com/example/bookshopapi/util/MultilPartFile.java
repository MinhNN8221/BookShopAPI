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
//    public MultipartFile createMultipartFileFromUrl(File imageFile) throws IOException {
//        byte[] fileContent = Files.readAllBytes(imageFile.toPath());
//
//        // Tạo đối tượng MultipartFile với tên tệp và nội dung từ tệp hình ảnh
//        return new MockMultipartFile(
//                imageFile.getName(),     // Tên tệp
//                imageFile.getName(),     // Original filename
//                MimeTypeUtils.IMAGE_JPEG.toString(), // Loại tệp hình ảnh, tùy thuộc vào định dạng
//                fileContent              // Nội dung của tệp
//        );
//    }

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

//    public static String fileToBase64(File file) throws IOException {
//        FileInputStream fileInputStream = new FileInputStream(file);
//        byte[] bytes = new byte[(int) file.length()];
//        fileInputStream.read(bytes);
//        fileInputStream.close();
//
//        // Mã hóa dữ liệu thành chuỗi Base64
//        String base64Image = Base64.getEncoder().encodeToString(bytes);
//        return base64Image;
//    }
//
//    public static void main(String[] args) {
//        try {
//            File file = new File("/storage/emulated/0/Android/data/com.example.bookshopmanagement/files/temp_image_1697996950294.jpg7221920504830496510.jpg"); // Thay thế bằng đường dẫn đến tệp ảnh
//            String base64Image = fileToBase64(file);
//            System.out.println(base64Image);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
