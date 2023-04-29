package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
         userRepository.save(user);
    }

    public String deleteUser(@PathVariable(value = "id")Long userId){
        User user=userRepository.findById(userId).orElseThrow();
        userRepository.delete(user);
        return "User deleted";
    }


    public User getUser(Long id){
       return userRepository.findById(id).orElseThrow();
    }

    public boolean verifyUser(String username,String password){
        List<User>users=userRepository.findAll();
        for(User user:users){
            if(username.equals(user.getName())&&password.equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

    public void changeRole(Role role,Long id){
        User user=userRepository.findById(id).orElseThrow();
        String username=user.getName();
        user.setName(username);
    }

    public String findUserName(String name){
        return userRepository.findName(name);
    }

    public ArrayList<String> getAllRoles(Long id){
        User user=userRepository.findById(id).orElseThrow();
        Set<Role>roles=user.getRoles();
        ArrayList<String>rolelist=new ArrayList<>();
        for(Role role:roles){
            rolelist.add(role.getRole());
        }
        return rolelist;
    }
}
