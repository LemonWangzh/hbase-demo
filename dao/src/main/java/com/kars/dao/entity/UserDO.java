package com.kars.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;

@Data
@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String address;

    private LocalDateTime createTime;
}
