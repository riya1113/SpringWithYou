package com.example.studentapp.service;

import com.example.studentapp.dto.CourseResponseDTO;
import com.example.studentapp.dto.TeacherRequestDTO;
import com.example.studentapp.dto.TeacherResponseDTO;
import com.example.studentapp.model.Course;
import com.example.studentapp.model.Teacher;
import com.example.studentapp.repository.CourseRepository;
import com.example.studentapp.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public TeacherService(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository=courseRepository;
    }

    public TeacherResponseDTO addTeacher(TeacherRequestDTO teacherRequestDTO)
    {
        Teacher teacher = new Teacher();
        teacher.setName(teacherRequestDTO.getName());
        teacherRepository.save(teacher);

        TeacherResponseDTO responseDTO = new TeacherResponseDTO();
        responseDTO.setId(teacher.getId());
        responseDTO.setName(teacher.getName());
        return responseDTO;
    }

    public TeacherResponseDTO assignTeacher(Integer teacherId, Integer courseId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(()->new RuntimeException("Teacher not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(()->new RuntimeException("Course not found"));

        course.getTeachers().add(teacher);
        courseRepository.save(course);
//        teacher.getCourses().add(course);
//
//        teacherRepository.save(teacher);

        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setId(course.getId());
        courseResponseDTO.setCourse(course.getCourseName());

        TeacherResponseDTO responseDTO = new TeacherResponseDTO();
        responseDTO.setId(teacher.getId());
        responseDTO.setName(teacher.getName());
        responseDTO.setCourseResponseDTO(courseResponseDTO);

        return responseDTO;

    }

    public List<CourseResponseDTO> getCoursesList(Integer id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()->new RuntimeException("Teacher not found"));
        List<CourseResponseDTO> courseResponseDTOList = new ArrayList<>();
        for(Course course: teacher.getCourses())
        {
            CourseResponseDTO dto = new CourseResponseDTO();
            dto.setId(course.getId());
            dto.setCourse(course.getCourseName());
            courseResponseDTOList.add(dto);
        }

        return courseResponseDTOList;
    }
}
