package com.Rushikesh.Learning.Platform.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = Users.class,property = "userId")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String email;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private LocalDate birthDate;

//    @JsonIgnore
    @ManyToMany
    private List<Course> courses;

}
