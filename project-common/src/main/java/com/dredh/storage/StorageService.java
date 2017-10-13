package com.dredh.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by honghua.dong1 on 17/1/3.
 */
public interface StorageService {

    void init();

    void store(MultipartFile file);

    void store(MultipartFile file, String newFileName);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
