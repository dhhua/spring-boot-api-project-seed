package com.dredh.storage;

/**
 * Created by honghua.dong1 on 17/1/3.
 */
public class StorageFileNotFoundException extends StorageException   {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
