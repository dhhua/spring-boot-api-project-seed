package com.dredh.controller;

import com.dredh.common.RestResponse;
import com.dredh.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class FileUploadController {
    @Autowired
    private final StorageService storageService;
    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/fileList")
    public RestResponse listUploadedFiles() throws IOException {
        List<String> dataList = storageService
                                .loadAll()
                                .map(path ->
                                        MvcUriComponentsBuilder
                                        .fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
                                        .build().toString())
                                .collect(Collectors.toList());
        return RestResponse.build(dataList);
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @PostMapping(value = "/upload", produces = "application/json")
    public RestResponse handleFileUpload(@RequestParam("file") MultipartFile file) {
        String originName = file.getOriginalFilename();
        String fileType = originName.substring(originName.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + fileType;
        storageService.store(file, newFileName);
        return RestResponse.build("/files/"+newFileName);
    }
}