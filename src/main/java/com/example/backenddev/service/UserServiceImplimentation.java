package com.example.backenddev.service;

import com.example.backenddev.model.User;
import com.example.backenddev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImplimentation implements  UserService{
@Autowired
    UserRepository userRepository;
    @Override
    public List<User> getAllUser() {

        return userRepository.findAll() ;
    }
    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null; // L'utilisateur n'a pas pu être authentifié
    }

    @Override
    public void deleteuserByid(Long id) {
       userRepository.deleteById(id);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveUser( User U) {
        return userRepository.save(U);
    }
}
