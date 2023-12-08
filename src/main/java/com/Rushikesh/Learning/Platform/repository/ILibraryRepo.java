package com.Rushikesh.Learning.Platform.repository;

import com.Rushikesh.Learning.Platform.model.Library;
import com.Rushikesh.Learning.Platform.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILibraryRepo extends JpaRepository<Library, Integer> {
    List<Library> findByUser(Users user);

    Library findFirstByUser(Users users);

    Library findFirstBylibId(Integer userId);

//    Library findFirstByCourse(Integer courseId);
}
