package com.example.backenddev.controller;


import com.example.backenddev.model.User;
import com.example.backenddev.service.UserService;
import com.example.backenddev.service.UserServiceImplimentation;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    @PostMapping("/edit")
    public  User updateUser(@RequestBody User U){
        return  userService.updateUser(U);
    }



    @DeleteMapping("/delete/{id}")
    public  void deleteById(@PathVariable Long id){
        userService.deleteuserByid(id);
    }
    @GetMapping("/getalluser")
    public List<User> getList(){
        return  userService.getAllUser();
    }

    @GetMapping("/score/{id}")
    public int  getScore(@PathVariable Long id){
        return  userService.getScore(id);
    }


    @PostMapping("/login")
    public String Login(@RequestBody User password) {
        String email= password.getEmail();
        String passwo = password.getPassword();
        User utilisateur = userService.login(email, passwo);
        if (utilisateur != null) {


            return "redirect:/diagnostic";
        } else {
            return "error";
        }
    }






}
