package com.Rushikesh.Learning.Platform.controllers;

import com.Rushikesh.Learning.Platform.model.Category;
import com.Rushikesh.Learning.Platform.model.Course;
import com.Rushikesh.Learning.Platform.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Course")
@CrossOrigin("*")
public class CourseController {

    @Autowired
    CourseService courseService;


    @PostMapping("add")
    public String addCourses(@RequestBody Course course){
        courseService.add(course);
        return "Course Added Successsfully...!!!";
    }

    @GetMapping()
    public List<Course> getCourse(){
      return  courseService.getCourse();
    }
    @GetMapping("type/{type}")
    public List<Course> getCourseByType(@PathVariable Category type){
        return  courseService.getCourseByType(type);
    }
    @GetMapping("id/{Id}")
    public Course getCourseById(@PathVariable Integer Id){
        return  courseService.getCourseById(Id);
    }

    @PutMapping("update")
    public String  update(@RequestBody Course course){
        courseService.update(course);
        return "update Successfully...!!!";
    }
    @DeleteMapping("delete/{Id}")
    public String  delete(@PathVariable Integer Id){
        courseService.delete(Id);
        return "Deleted Successfully...!!!";
    }


}
