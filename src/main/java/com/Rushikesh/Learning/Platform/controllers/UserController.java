package com.Rushikesh.Learning.Platform.controllers;

import com.Rushikesh.Learning.Platform.model.Users;
import com.Rushikesh.Learning.Platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public Boolean addUser(@RequestBody Users user){
       return userService.addUser(user);
    }
    @GetMapping("{id}")
    public Users getById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @GetMapping("user")
    public List<Users> getAll(){
        return  userService.getAll();
    }
    @GetMapping("{userId}/{courseId}")
    public String joinUserNCourse(@PathVariable Integer userId,@PathVariable Integer courseId){
        userService.joinUserNCourse(userId,courseId);
        return "joined Successfully...!!!";
    }

    @DeleteMapping("courses/{userId}/{courseId}")
    public String deleteFromCart(@PathVariable Integer userId, @PathVariable Integer courseId){
        userService.deleteFromCart(userId,courseId);
        return "Deleted from Cart";
    }

}
