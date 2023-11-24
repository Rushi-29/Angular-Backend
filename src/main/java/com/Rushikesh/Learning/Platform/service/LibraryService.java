package com.Rushikesh.Learning.Platform.service;

import com.Rushikesh.Learning.Platform.model.Course;
import com.Rushikesh.Learning.Platform.model.Library;
import com.Rushikesh.Learning.Platform.model.Users;
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

    public List<Library> getPurchasedCoursesByUser(Users user) {
        return libraryRepo.findByUser(user);

    }




    public String addToLibrary(Users user) {
        Library library=new Library();
        Integer Id = user.getUserId();
        Users users = userRepo.findById(Id).get();

        library.setUser(users);
        List<Course> courses = users.getCourses();
        for(Course c : courses){
            library.getCourse().add(c);
        }
        libraryRepo.save(library);
        users.getCourses().removeAll(users.getCourses());
        userRepo.save(users);

        return "Added to Library...!!!";
    }
}
