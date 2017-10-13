package com.dredh.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by honghua.dong1 on 17/1/3.
 */
@ConfigurationProperties(prefix = "storage")
public class StorageProperties {

    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
