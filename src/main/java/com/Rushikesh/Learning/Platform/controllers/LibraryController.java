package com.Rushikesh.Learning.Platform.controllers;

import com.Rushikesh.Learning.Platform.model.Users;
import com.Rushikesh.Learning.Platform.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("library")
@CrossOrigin("*")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @PostMapping()
    public String addToLibrary(@RequestBody Users user){
        return libraryService.addToLibrary(user);
    }

}
