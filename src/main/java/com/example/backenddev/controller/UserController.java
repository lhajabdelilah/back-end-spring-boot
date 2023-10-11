package com.example.backenddev.controller;


import com.example.backenddev.model.User;
import com.example.backenddev.service.UserService;
import com.example.backenddev.service.UserServiceImplimentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService ;

    @GetMapping("/list/{id}")
    public  User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping("/add")
    public  User saveUser(@RequestBody User U){
        return  userService.saveUser(U);
    }


    @DeleteMapping("/delete/{id}")
    public  void deleteById(@PathVariable Long id){
        userService.deleteuserByid(id);
    }
    @GetMapping("/getalluser")
    public List<User> getList(){
        return  userService.getAllUser();
    }

    @PostMapping("/login")
    public String Login(@RequestParam("email") String email, @RequestParam("password") String password) {
        User utilisateur = userService.login(email, password);
        if (utilisateur != null) {
            return "redirect:/diagnostic";
        } else {
            return "error";
        }
    }






}
