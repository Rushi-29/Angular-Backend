package com.Rushikesh.Learning.Platform.controllers;

import com.Rushikesh.Learning.Platform.model.Course;
import com.Rushikesh.Learning.Platform.model.Library;
import com.Rushikesh.Learning.Platform.model.Users;
import com.Rushikesh.Learning.Platform.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library")
@CrossOrigin("*")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @PostMapping("{id}")
    public String addToLibrary(@PathVariable Integer id){
        return libraryService.addToLibrary(id);
    }
    @GetMapping("/id/{id}")
    public List<Course> getByUser(@PathVariable Integer id){
        return libraryService.getByUser(id);
    }

    @GetMapping()
    public List<Library> getAll(){
        return libraryService.getAll();
    }
}
