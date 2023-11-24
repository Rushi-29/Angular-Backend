package com.Rushikesh.Learning.Platform.service;

import com.Rushikesh.Learning.Platform.model.Course;
import com.Rushikesh.Learning.Platform.model.Users;
import com.Rushikesh.Learning.Platform.repository.ICourseRepo;
import com.Rushikesh.Learning.Platform.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ICourseRepo courseRepo;


    public String addUser(Users user) {
        userRepo.save(user);
        return "User Added Successfully..!!!";
    }

    public Users getById(Integer id) {
        return userRepo.findById(id).get();
    }

    public List<Users> getAll() {
        return userRepo.findAll();
    }

    public void joinUserNCourse(Integer userId, Integer courseId) {
        Users user = userRepo.findById(userId).get();
        user.getCourses().add(courseRepo.findById(courseId).get());
        userRepo.save(user);
    }

    public void deleteFromCart(Integer userId, Integer courseId) {
        Users user = userRepo.findById(userId).get();
        Course course = new Course();
        for(Course course1 : user.getCourses()){
            if(course1.getCourseId()==courseId){
                course=course1;
            }
        }
        user.getCourses().remove(course);
        userRepo.save(user);
    }
}
