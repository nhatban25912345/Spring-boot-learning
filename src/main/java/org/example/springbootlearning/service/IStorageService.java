package org.example.springbootlearning.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface IStorageService {
    public String storageFile(MultipartFile fileName);
    public Stream<Path> loadAll();
    public byte[] load(String fileName);
    public void delete();
}
