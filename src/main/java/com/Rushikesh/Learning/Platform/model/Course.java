package com.Rushikesh.Learning.Platform.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = Course.class,property = "courseId")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseId;
    private String  courseName;
    private String  author;
    private String duration;
    private String  price;
    private String  description;
    private Double rating;
    private Category type;
    private Integer availableSlots=5;


    @JsonIgnore
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL )
    private List<Users> usersList;


}
