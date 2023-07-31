package com.kars.hbaseclient.controller;

import com.kars.data.dto.UserDTO;
import com.kars.data.result.CommonResult;
import com.kars.data.vo.UserVO;
import com.kars.hbaseclient.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mysql")
public class MysqlController {

    private final UserService userService;


    public MysqlController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public CommonResult<UserVO> getUserById(@PathVariable Long id){
        return CommonResult.success(userService.findUserById(id));
    }

    @PostMapping("/user/add")
    public CommonResult<Object> addUser(@RequestBody UserDTO userDTO){
        userService.add(userDTO);
        return CommonResult.success();
    }


    @DeleteMapping("/user/{id}")
    public CommonResult<Object> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return CommonResult.success();
    }
}
