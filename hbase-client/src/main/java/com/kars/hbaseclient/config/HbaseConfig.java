package com.kars.hbaseclient.config;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean({HbaseProperties.class})
public class HbaseConfig {

    private final HbaseProperties hbaseProperties;

    public HbaseConfig(HbaseProperties hbaseProperties) {
        this.hbaseProperties = hbaseProperties;
    }

    public org.apache.hadoop.conf.Configuration configuration() {
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
        hbaseProperties.getConfig().forEach(configuration::set);
        configuration.setLong("hbase.rpc.timeout", 600000);
        configuration.setLong("hbase.client.operation.timeout", 600000);
        configuration.setLong("hbase.client.scanner.timeout.period", 600000);
        configuration.setLong("hbase.regionserver.lease.period", 600000);
        // ReusablePool，RoundRobinPool，ThreadLocalPool
        configuration.set("hbase.client.ipc.pool.type","ThreadLocalPool");
        configuration.setInt("hbase.client.ipc.pool.size",10);
        return configuration;
    }
}
