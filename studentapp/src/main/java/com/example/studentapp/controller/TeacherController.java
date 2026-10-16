package com.example.studentapp.controller;

import com.example.studentapp.dto.CourseResponseDTO;
import com.example.studentapp.dto.TeacherRequestDTO;
import com.example.studentapp.dto.TeacherResponseDTO;
import com.example.studentapp.model.Teacher;
import com.example.studentapp.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/add")
    public TeacherResponseDTO addTeacher(@RequestBody TeacherRequestDTO teacherRequestDTO)
    {
        return teacherService.addTeacher(teacherRequestDTO);
    }

    @PostMapping("/assign/{teacherId}/course/{courseId}")
    public TeacherResponseDTO assignTeacher(@PathVariable Integer teacherId, @PathVariable Integer courseId)
    {
        return teacherService.assignTeacher(teacherId, courseId);
    }

    @GetMapping("/{id}/courses")
    public List<CourseResponseDTO> getCoursesList(@PathVariable Integer id)
    {
        return teacherService.getCoursesList(id);
    }
}
