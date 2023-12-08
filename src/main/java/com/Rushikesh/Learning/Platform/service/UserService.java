package com.Rushikesh.Learning.Platform.service;

import com.Rushikesh.Learning.Platform.model.Course;
import com.Rushikesh.Learning.Platform.model.Library;
import com.Rushikesh.Learning.Platform.model.Users;
import com.Rushikesh.Learning.Platform.repository.ICourseRepo;
import com.Rushikesh.Learning.Platform.repository.ILibraryRepo;
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
    @Autowired
    private ILibraryRepo libraryRepo;

    public String addUser(Users user) {
        userRepo.save(user);
        return "User Added Successfully..!!!";
    }

    public Users getById(Integer id) {
        Users user = userRepo.findById(id).get();
        return user;
    }

    public List<Users> getAll() {
        return userRepo.findAll();
    }

    public String joinUserNCourse(Integer userId, Integer courseId) {
        Users user = userRepo.findById(userId).get();
        Library lib = libraryRepo.findFirstBylibId(userId);
       if(lib!=null) {
           for (Course cou : lib.getCourse()) {
               if (cou.getCourseId() == courseId) {
                   return "Already subscribed...!!!";
               }
           }

       }
        user.getCourses().add(courseRepo.findById(courseId).get());
        userRepo.save(user);
        return "Added successfully";
    }

    public void deleteFromCart(Integer userId, Integer courseId) {
        Users user = userRepo.findById(userId).get();
        Course course = new Course();
        for (Course course1 : user.getCourses()) {
            if (course1.getCourseId() == courseId) {
                course = course1;
            }
        }
        user.getCourses().remove(course);
        userRepo.save(user);
    }

    public Users getByEmail(String email, String password) {
        return userRepo.findFirstByEmailAndPassword(email,password);

    }

    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }


}
