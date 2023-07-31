package com.kars.hbaseclient.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties(prefix = "hbase")
@Component
@ConditionalOnProperty(prefix = "hbase.enable",value = "true")
public class HbaseProperties {

    private Map<String, String> config;

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }
}
