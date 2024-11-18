package com.demojavadj.appweb.services.impl;

import com.demojavadj.appweb.models.Role;
import com.demojavadj.appweb.models.Users;
import com.demojavadj.appweb.repository.RoleRepository;
import com.demojavadj.appweb.repository.UsersRepository;
import com.demojavadj.appweb.services.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;

    public UsersServiceImpl(UsersRepository usersRepository, RoleRepository roleRepository) {
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void addUser(Users user, String roleName) {
        Role role = roleRepository.findByName(roleName);
        if (role == null) {
            role = new Role();
            role.setName(roleName);
            roleRepository.save(role);
        }
        user.getRoles().add(role);
        usersRepository.save(user);
    }

    @Override
    public Users getUserById(Long id) {
        Optional<Users> user = usersRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Override
    public void updateUser(Users user) {
        usersRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}
