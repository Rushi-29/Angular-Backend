package com.Rushikesh.Learning.Platform.repository;

import com.Rushikesh.Learning.Platform.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
}
