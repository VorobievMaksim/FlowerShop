package com.accenture.be.business;


import com.accenture.be.entity.User;
import com.accenture.be.exeptions.FlowerShopExeptions;
import com.accenture.fe.dto.RegisterUserDTO;

public interface UserBusinessService {
    User login(String username, String password) throws FlowerShopExeptions;
    User register(RegisterUserDTO registerUserDTO) throws FlowerShopExeptions;
    User logout();
}
