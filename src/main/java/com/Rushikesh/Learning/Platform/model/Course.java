package com.Rushikesh.Learning.Platform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseId;
    private String  courseName;
    private String  author;
    private String duration;
    private String  price;
    private String  description;
    private Integer rating;
    private String type;
    private String imageUrl;
    @JsonIgnore
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<Users> usersList;


}
