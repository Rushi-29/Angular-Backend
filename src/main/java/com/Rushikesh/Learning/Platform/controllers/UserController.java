package com.Rushikesh.Learning.Platform.controllers;

import com.Rushikesh.Learning.Platform.model.Course;
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
    public String addUser(@RequestBody Users user){
       return userService.addUser(user);
    }
    @GetMapping("email/{email}/{password}")
    public Users getByEmail(@PathVariable String email,@PathVariable String password){
        return userService.getByEmail(email,password);
    }
    @GetMapping("{id}")
    public Users getById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @GetMapping("user")
    public List<Users> getAll(){
        return  userService.getAll();
    }

//    @GetMapping()
//    public List<Course> getCourseById(Integer id){
//        return userService.getCourseById(id);
//    }
    @GetMapping("{userId}/{courseId}")
    public String joinUserNCourse(@PathVariable Integer userId,@PathVariable Integer courseId){
      return  userService.joinUserNCourse(userId,courseId);

    }

    @DeleteMapping("courses/{userId}/{courseId}")
    public String deleteFromCart(@PathVariable Integer userId, @PathVariable Integer courseId){
        userService.deleteFromCart(userId,courseId);
        return "Deleted from Cart";
    }
    @DeleteMapping("Id/{id}")
    public String deleteById(@PathVariable Integer id){
        userService.deleteById(id);
        return "Deleted Successfully...!!!";
    }


}
