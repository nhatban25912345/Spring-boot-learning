package org.example.springbootlearning.controller;

import org.example.springbootlearning.factory.response.GeneralResponse;
import org.example.springbootlearning.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/api/file-upload")
class FileUploadController {
    // Inject storage service here
    @Autowired
    private IStorageService storageService;

    @PostMapping
    public ResponseEntity<GeneralResponse> uploadFile(@RequestParam("file") MultipartFile file) {
        // save files to a folder => use a service
        try {
            String generatedFileName = storageService.storageFile(file);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new GeneralResponse(HttpStatus.OK, "upload file successfully", generatedFileName)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new GeneralResponse(HttpStatus.NOT_IMPLEMENTED, e.getMessage(), "")
            );
        }
    }
}
