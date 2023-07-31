package com.kars.hbaseclient.service.impl;

import com.kars.data.exception.BusinessException;
import com.kars.data.result.CommonResult;
import com.kars.hbaseclient.config.HbaseConfig;
import com.kars.hbaseclient.service.HbaseService;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@Service
public class HbaseServiceImpl implements HbaseService {

    private final Admin admin;

    public HbaseServiceImpl(HbaseConfig hbaseConfig) throws IOException {
        try (Connection connection = ConnectionFactory.createConnection(hbaseConfig.configuration())) {
            admin = connection.getAdmin();
        }
    }

    @Override
    public CommonResult<Object> createTable(String tableName, String... columnFamilies) {
        try {
            TableName name = TableName.valueOf(tableName);
            boolean isExists = this.tableExists(tableName);
            if (isExists) {
                throw new BusinessException(tableName + "is exists!");
            }
            TableDescriptorBuilder descriptorBuilder = TableDescriptorBuilder.newBuilder(name);
            List<ColumnFamilyDescriptor> columnFamilyList = new ArrayList<>();
            for (String columnFamily : columnFamilies) {
                ColumnFamilyDescriptor columnFamilyDescriptor = ColumnFamilyDescriptorBuilder
                        .newBuilder(columnFamily.getBytes()).build();
                columnFamilyList.add(columnFamilyDescriptor);
            }
            descriptorBuilder.setColumnFamilies(columnFamilyList);
            TableDescriptor tableDescriptor = descriptorBuilder.build();
            admin.createTable(tableDescriptor);
        } catch (IOException e) {
            throw new BusinessException("create table error");
        }
        return CommonResult.success();
    }

    @Override
    public boolean tableExists(String tableName) throws IOException {
        return admin.tableExists(TableName.valueOf(tableName));
    }
}
