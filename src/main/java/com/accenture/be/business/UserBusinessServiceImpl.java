package com.accenture.be.business;

import com.accenture.be.access.UserDAO;
import com.accenture.be.entity.User;
import com.accenture.be.entity.enums.Role;
import com.accenture.be.exeptions.FlowerShopErrors;
import com.accenture.be.exeptions.FlowerShopExeptions;
import com.accenture.fe.dto.RegisterUserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.math.BigDecimal;

@Service
public class UserBusinessServiceImpl implements UserBusinessService {

    private UserDAO userDAO;
    private ModelMapper modelMapper;

    @Autowired
    public UserBusinessServiceImpl(UserDAO userDAO, ModelMapper modelMapper) {
        this.userDAO = userDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    public User login(@Validated String username, String password) throws FlowerShopExeptions {
        User user = userDAO.getByUsername(username);
        if (user == null) throw new FlowerShopExeptions(FlowerShopErrors.USER_IS_NOT_EXIST);
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            throw new FlowerShopExeptions(FlowerShopErrors.PASSWORD_IS_INCORRECT);
        }
    }

    @Override
    @Transactional
    public User register( RegisterUserDTO registerUserDTO) throws FlowerShopExeptions {
        if (userDAO.getByUsername(registerUserDTO.getUsername()) != null) {
            throw new FlowerShopExeptions(FlowerShopErrors.USER_IS_EXIST);
        } else {
            User user= modelMapper.map(registerUserDTO, User.class);
            user.setDiscount(0);
            user.setBalance(new BigDecimal(2000));
            user.setRole(Role.USER);
            userDAO.save(user);
            return userDAO.save(user);
        }
    }

    @Override
    public User logout() {
        return null;
    }


    //пока так =|
    private void dataChecking(RegisterUserDTO registerUserDTO) throws FlowerShopExeptions {
        if ((registerUserDTO.getUsername() != null ? registerUserDTO.getUsername().length() : 0) < 3)
            throw new FlowerShopExeptions(FlowerShopErrors.USERNAME_IS_SHORT);
        if ((registerUserDTO.getPassword() != null ? registerUserDTO.getPassword().length() : 0) < 6)
            throw new FlowerShopExeptions(FlowerShopErrors.PASSWORD_IS_SHORT);
    }
}
