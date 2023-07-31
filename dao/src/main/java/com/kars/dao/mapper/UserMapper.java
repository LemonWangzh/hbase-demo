package com.kars.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kars.dao.entity.UserDO;
import com.kars.data.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<UserDO> {

    UserVO findUserById(@Param("id") Long id);

}
