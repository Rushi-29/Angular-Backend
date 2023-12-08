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
public class LibraryService {

    @Autowired
    private ILibraryRepo libraryRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ICourseRepo courseRepo;

    public List<Library> getPurchasedCoursesByUser(Users user) {
        return libraryRepo.findByUser(user);

    }




    public String addToLibrary(Integer userId) {
        Users users;
        Library library=libraryRepo.findFirstBylibId(userId);
        if(library!=null) {
             users = userRepo.findById(library.getUser().getUserId()).get();
//            library.setUser(users);
            List<Course> courses = users.getCourses();
            for(Course c : courses){
                library.getCourse().add(c);
                Course course1= courseRepo.findById(c.getCourseId()).get();
                if(c!=null) {
                    Integer qty = course1.getAvailableSlots();
                    qty-=1;
                    course1.setAvailableSlots(qty);
                    courseRepo.save(course1);
                }
            }
        }
        else {
             users = userRepo.findById(userId).get();
            library= new Library();
            library.setUser(users);
            List<Course> courses = users.getCourses();
            for(Course c : courses){
                library.getCourse().add(c);
                Course course1= courseRepo.findById(c.getCourseId()).get();
                if(c!=null) {
                    Integer qty = course1.getAvailableSlots();
                    qty -= 1;
                    course1.setAvailableSlots(qty);
                    courseRepo.save(course1);
                }
            }
            library.setLibId(userId);
        }
        libraryRepo.save(library);
        users.getCourses().removeAll(users.getCourses());
        userRepo.save(users);
        return "Added to Library...!!!";
    }

    public List<Course> getByUser(Integer id) {
        Users user1 = userRepo.findById(id).get();
        Library lib = libraryRepo.findById(user1.getUserId()).get();
        List<Course> courseList = lib.getCourse();
        return courseList;
    }

    public List<Library> getAll(){
        return libraryRepo.findAll();
    }
}
