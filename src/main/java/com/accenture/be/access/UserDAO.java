package com.accenture.be.access;

import com.accenture.be.entity.User;
import com.accenture.be.exeptions.FlowerShopExeptions;

import java.util.List;

public interface UserDAO {
    User save(User user);
    User update(User user);
    User getByUsername(String username) throws FlowerShopExeptions;
    User getByID(Long ID);
    List<User> getListUsers();
}
