package com.kars.hbaseclient.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kars.dao.entity.UserDO;
import com.kars.dao.mapper.UserMapper;
import com.kars.data.dto.UserDTO;
import com.kars.data.exception.BaseException;
import com.kars.data.vo.UserVO;
import com.kars.hbaseclient.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserVO findUserById(Long id) {
        return userMapper.findUserById(id);
    }

    @Override
    public void add(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO,userDO);
        userDO.setCreateTime(LocalDateTime.now());
        userMapper.insert(userDO);
    }

    @Override
    public void delete(Long id) {
        boolean exists = userMapper.exists(new LambdaQueryWrapper<UserDO>().eq(UserDO::getId,id));
        if (!exists){
            throw new BaseException("user not exist!");
        }
        userMapper.deleteById(id);
    }
}
