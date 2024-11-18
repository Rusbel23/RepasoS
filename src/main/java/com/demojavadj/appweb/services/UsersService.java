package com.demojavadj.appweb.services;

import com.demojavadj.appweb.models.Users;
import java.util.List;

public interface UsersService {
    List<Users> getAllUsers();
    void addUser(Users user, String roleName);
    Users getUserById(Long id);
    void deleteUser(Long id);
    void updateUser(Users user);
}
