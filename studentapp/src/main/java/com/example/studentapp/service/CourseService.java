package com.example.studentapp.service;

import com.example.studentapp.dto.CourseRequestDTO;
import com.example.studentapp.dto.CourseResponseDTO;
import com.example.studentapp.dto.StudentProfileResponseDTO;
import com.example.studentapp.dto.StudentResponseDTO;
import com.example.studentapp.exception.StudentNotFoundException;
import com.example.studentapp.model.Course;
import com.example.studentapp.model.Student;
import com.example.studentapp.repository.CourseRepository;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    private final StudentRepository studentRepository;

    public CourseResponseDTO addCourse(CourseRequestDTO courseRequestDTO) {

        Course course = new Course();
        course.setCourseName(courseRequestDTO.getCourse());
        courseRepository.save(course);

        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setId(course.getId());
        courseResponseDTO.setCourse(course.getCourseName());
        return courseResponseDTO;
    }

    public StudentResponseDTO assignCourse(int courseId, int studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new StudentNotFoundException("Student not found"));

        Course course = courseRepository.findById(courseId).orElseThrow(()-> new RuntimeException("Course not found"));

        student.setCourse(course);
        studentRepository.save(student);

        CourseResponseDTO courseResponseDTO = new CourseResponseDTO(
                student.getCourse().getId(),
                student.getCourse().getCourseName()
        );

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setAge(student.getAge());
        studentResponseDTO.setCourseResponseDTO(courseResponseDTO);


        return studentResponseDTO;

    }

    public List<StudentResponseDTO> getStudentsByCourse(int courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()-> new RuntimeException("Course not found"));

        List<Student> students = course.getStudents();

        List<StudentResponseDTO> studentResponseDTOList = new ArrayList<>();

        for(Student student: students)
        {
            StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
            studentResponseDTO.setId(student.getId());
            studentResponseDTO.setName(student.getName());
            studentResponseDTO.setAge(student.getAge());
            studentResponseDTOList.add(studentResponseDTO);
        }

        return studentResponseDTOList;

    }
}
