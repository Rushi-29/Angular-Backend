package com.Rushikesh.Learning.Platform.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = Library.class,property = "libId")
public class Library {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer libId;

    @OneToOne
    private Users user;
    @ManyToMany(cascade=CascadeType.ALL)
    private List<Course> course=new ArrayList<>();
 }
