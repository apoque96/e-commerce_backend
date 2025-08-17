package com.platoons.e_commerce.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageUtils {

    public ImageUtils() {
    }

    public boolean fileIsImage(MultipartFile file){
        try {
            byte[] fileBytes = file.getBytes();
            String fileSignature = getFileSignature(fileBytes);

            // Example: Checking for common image file signatures
            return fileSignature.equals("FFD8FFE000104A46") || // JPEG
                    fileSignature.equals("89504E470D0A1A0A"); // PNG
        } catch (Exception e) {
            return false;
        }
    }

    private String getFileSignature(byte[] fileBytes) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < Math.min(8, fileBytes.length); i++) {
            String hex = Integer.toHexString(fileBytes[i] & 0xFF).toUpperCase();
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
