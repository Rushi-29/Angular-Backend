package com.Rushikesh.Learning.Platform.service;

import com.Rushikesh.Learning.Platform.model.Course;
import com.Rushikesh.Learning.Platform.model.Library;
import com.Rushikesh.Learning.Platform.model.Users;
import com.Rushikesh.Learning.Platform.repository.ILibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private ILibraryRepo libraryRepo;

    public List<Library> getPurchasedCoursesByUser(Users user) {
        return libraryRepo.findByUser(user);
    }


    public void purchaseCourse(Users user, Course course) {
        Library library = new Library();
        library.setUser(user);
        library.setCourse((List<Course>) course);
        libraryRepo.save(library);
    }
}
