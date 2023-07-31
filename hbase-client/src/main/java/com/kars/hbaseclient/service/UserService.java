package com.kars.hbaseclient.service;

import com.kars.data.dto.UserDTO;
import com.kars.data.vo.UserVO;

public interface UserService {

    UserVO findUserById(Long id);

    void add(UserDTO userDTO);

    void delete(Long id);
}
