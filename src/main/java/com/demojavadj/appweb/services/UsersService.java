package com.demojavadj.appweb.services;

import com.demojavadj.appweb.dto.RegisterDto;
import com.demojavadj.appweb.models.Users;
import java.util.List;

public interface UsersService {
    List<Users> allListUsers();
    void addUser(Users user, String roleName);
    Users getUserById(Long id);
    void deleteUser(Long id);
    void updateUser(Users user);
    Users saveUser(RegisterDto registerDto);
}
