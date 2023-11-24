package com.Rushikesh.Learning.Platform.repository;

import com.Rushikesh.Learning.Platform.model.Category;
import com.Rushikesh.Learning.Platform.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICourseRepo extends JpaRepository<Course, Integer> {
    List<Course> findByType(Category type);
}
