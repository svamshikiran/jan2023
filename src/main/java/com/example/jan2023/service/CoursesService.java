package com.example.jan2023.service;

import com.example.jan2023.model.Courses;
import com.example.jan2023.respository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {

    @Autowired
    CourseRepository repo;

    public void addCourse(Courses course){
        repo.save(course);
    }

    public List<Courses> getAllCourses(){
        return repo.findAll();
    }

}
