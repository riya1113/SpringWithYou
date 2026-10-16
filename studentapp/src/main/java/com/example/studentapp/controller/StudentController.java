package com.example.studentapp.controller;

import com.example.studentapp.dto.StudentRequestDTO;
import com.example.studentapp.dto.StudentResponseDTO;
import com.example.studentapp.exception.StudentNotFoundException;
import com.example.studentapp.model.Student;
import com.example.studentapp.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }

    @GetMapping("/student")
    public Student getStudent()
    {
        return studentService.getStudent();
    }

    @GetMapping("/students")
    public List<StudentResponseDTO> getStudents()
    {
        return studentService.getStudents();
    }

    @PostMapping("/student")
    public StudentResponseDTO addStudent(@RequestBody StudentRequestDTO student)
    {
        return studentService.addStudent(student);
    }

    @GetMapping("/student/{id}")
    public StudentResponseDTO getStudentById(@PathVariable int id)
    {

        return studentService.getStudentById(id);
    }

    @PutMapping("/student/{id}")
    public StudentResponseDTO updateStudentById(@PathVariable int id, @RequestBody StudentRequestDTO studentRequestDTO)
    {
        return studentService.updateStudentById(id, studentRequestDTO);
    }

    @DeleteMapping("/student/{id}")
    public StudentResponseDTO deleteStudentById(@PathVariable int id)
    {
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/students/older/than/{age}")
    public List<StudentResponseDTO> getStudentsOlderThan(@PathVariable int age)
    {

        return studentService.getStudentsOlderThan(age);
    }

    @GetMapping("/students/by/page")
    public Page<StudentResponseDTO> getStudentsByPage(@RequestParam int page, @RequestParam int size, @RequestParam String sortBy, @RequestParam String direction)
    {
        return studentService.getStudentsByPage(page, size, sortBy, direction);
    }


}
