package com.kars.hbaseclient.service;

import com.kars.data.result.CommonResult;

import java.io.IOException;

public interface HbaseService {

    //创建表
    CommonResult<Object> createTable(String tableName, String... columnFamilies);

    boolean tableExists(String tableName) throws IOException;

}
