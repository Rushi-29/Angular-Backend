package com.Rushikesh.Learning.Platform.service;

import com.Rushikesh.Learning.Platform.model.Category;
import com.Rushikesh.Learning.Platform.model.Course;
import com.Rushikesh.Learning.Platform.repository.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    ICourseRepo courseRepo;


    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    public List<Course> getCourse() {
       return  courseRepo.findAll();

    }

    public List<Course> getCourseByType(Category type) {
        return courseRepo.findByType(type);
    }

    public Course getCourseById(Integer id) {
        return courseRepo.findById(id).get();
    }

    public void update(Course course) {
       Course course1= courseRepo.findById(course.getCourseId()).get();
       if(course!=null) {
           Integer qty = course.getAvailableSlots();
           qty-=1;
           course1.setAvailableSlots(qty);
           courseRepo.save(course1);
       }
    }

    public void delete(Integer id) {
        courseRepo.deleteById(id);
    }

    public void add(Course course) {
        courseRepo.save(course);
    }
}
