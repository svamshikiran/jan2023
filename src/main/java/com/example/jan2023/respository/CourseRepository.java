package com.example.jan2023.respository;

import com.example.jan2023.model.Courses;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Courses, Integer> {
}
