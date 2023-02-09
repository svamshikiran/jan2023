package com.example.jan2023.service;


import com.example.jan2023.model.Student;
import com.example.jan2023.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository repo;

    public List<Student> getAllStudents(){
        return repo.findAll(); //select * from student;
    }

    public Student getStudentByRollno(int rollno){
        Optional<Student> opStudent = repo.findById(rollno);
        if(opStudent.isPresent())
            return opStudent.get();
        else
            return new Student();
    }

    public void upsertStudent(Student student){// upsert - update or insert
        repo.save(student);//insert into student values();
    }

    public void deleteStudent(int rollno){
        repo.deleteById(rollno);
    }

    public List<Student> getStudentsByCity(String city){
        return repo.findByCity(city);
    }

}
