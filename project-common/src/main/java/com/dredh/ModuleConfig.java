package com.dredh;

import com.dredh.storage.StorageProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties(StorageProperties.class)
public class ModuleConfig {
}
