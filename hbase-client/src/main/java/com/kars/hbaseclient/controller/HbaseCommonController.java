package com.kars.hbaseclient.controller;

import com.kars.data.result.CommonResult;
import com.kars.hbaseclient.service.HbaseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bhase")
public class HbaseCommonController {

    private final HbaseService hbaseService;

    public HbaseCommonController(HbaseService hbaseService) {
        this.hbaseService = hbaseService;
    }

    /**
     * 创建表
     * tableName:表名
     * columnFamilies:列族
     */
    @Operation(summary = "创建表")
    @GetMapping("/createTable")
    public CommonResult<Object> createTable(String tableName, String[] columnFamilies) {
        return hbaseService.createTable(tableName, columnFamilies);
    }
}
