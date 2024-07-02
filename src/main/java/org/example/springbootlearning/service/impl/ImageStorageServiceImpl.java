package org.example.springbootlearning.service.impl;

import org.apache.commons.io.FilenameUtils;
import org.example.springbootlearning.service.IStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class ImageStorageServiceImpl implements IStorageService {

    private final Path storageFolder = Paths.get("uploads");

    public ImageStorageServiceImpl() {
        try {
            Files.createDirectories(storageFolder);
        } catch (IOException e) {
            throw new RuntimeException("Cannot initialize storage", e);
        }
    }

    private boolean isImageFile(MultipartFile file) {
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        return Arrays.asList(new String[]{"jpg", "png", "jpeg"})
                .contains(fileExtension.trim().toLowerCase());
    }

    @Override
    public String storageFile(MultipartFile file) {
        if(file.isEmpty()) {
            throw new RuntimeException("Failed to store empty file");
        }

        if (!isImageFile(file)) {
            throw new RuntimeException("You can only upload image files");
        }

        //file must be <= 5mb
        float fileSizeInMegabytes = (float) file.getSize() / 1_000_000;
        if (fileSizeInMegabytes > 5.0f) {
            throw new RuntimeException("File must be <= 5MB");
        }

        // rename file
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        String generatedFileName = UUID.randomUUID().toString().replace("-", "");
        generatedFileName = generatedFileName + "." + fileExtension;
        Path destinationFilePath = this.storageFolder.resolve(Paths.get(generatedFileName)).normalize().toAbsolutePath();
        if(!destinationFilePath.getParent().equals(this.storageFolder.toAbsolutePath())) {
            throw new RuntimeException("The storage folder does not have the correct path");
        }
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return generatedFileName;
    }

    @Override
    public Stream<Path> loadAll() {
        return Stream.empty();
    }

    @Override
    public byte[] load(String fileName) {
        return new byte[0];
    }

    @Override
    public void delete() {

    }
}
