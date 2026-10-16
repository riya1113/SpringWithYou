package com.example.studentapp.controller;

import com.example.studentapp.dto.CourseRequestDTO;
import com.example.studentapp.dto.CourseResponseDTO;
import com.example.studentapp.dto.StudentResponseDTO;
import com.example.studentapp.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public CourseResponseDTO addCourse(@RequestBody CourseRequestDTO courseRequestDTO)
    {
        return courseService.addCourse(courseRequestDTO);
    }

    @PostMapping("/assign/course/{courseId}/student/{studentId}")
    public StudentResponseDTO assignCourse(@PathVariable int courseId, @PathVariable int studentId)
    {
        return courseService.assignCourse(courseId, studentId);
    }

    @GetMapping("/{courseId}/students")
    public List<StudentResponseDTO> getStudentsByCourse(@PathVariable int courseId)
    {
        return courseService.getStudentsByCourse(courseId);
    }

}
