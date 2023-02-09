package com.example.jan2023.controller;

import com.example.jan2023.model.Student;
import com.example.jan2023.service.StudentService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service; //Dependency Injection

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @ApiResponse(responseCode = "200", description = "THIS IS SUCCESSFUL RESPONSE")
    @ApiResponse(responseCode = "400", description = "THIS IS THE RESPONSE CODE FOR WRONG INPUT, SO PLEASE CHECK THE ROLLNO ONCE AND RESEND")
    @GetMapping("/get/{rollno}")
    public ResponseEntity<Object> getStudentByRollno(@PathVariable("rollno") int roll){

        Student student = service.getStudentByRollno(roll);
        if(student.getRollno() == 0){
            return new ResponseEntity<>("STUDENT DOESN'T EXIST", HttpStatus.BAD_REQUEST);
        }
        else
            return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student){
        service.upsertStudent(student);
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody Student student){
        service.upsertStudent(student);
    }

    @DeleteMapping("/delete/{rollno}")
    public void deleteStudent(@PathVariable("rollno") int rollno){
        service.deleteStudent(rollno);
    }

    @GetMapping("/getbycity/{city}")
    public List<Student> getByCity(@PathVariable("city") String city){
        return service.getStudentsByCity(city);
    }

}
