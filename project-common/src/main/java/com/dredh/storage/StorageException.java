package com.dredh.storage;

/**
 * Created by honghua.dong1 on 17/1/3.
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
