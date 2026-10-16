package com.example.studentapp.service;

import com.example.studentapp.dto.StudentProfileResponseDTO;
import com.example.studentapp.dto.StudentRequestDTO;
import com.example.studentapp.dto.StudentResponseDTO;
import com.example.studentapp.exception.StudentNotFoundException;
import com.example.studentapp.model.Student;
import com.example.studentapp.model.StudentProfile;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;



    Student s1 = new Student(1, "Abhi", 22);
    Student s2 = new Student(2, "Sumesh", 22);
    Student s3 = new Student(3, "Veena", 22);

    List<Student> studentList = new ArrayList<>();

    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository=studentRepository;

//        studentList.add(s1);
//        studentList.add(s2);
//        studentList.add(s3);

    }

    public List<StudentResponseDTO> getStudents()
    {
        List<Student> students = studentRepository.findAll();
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



    public Student getStudent()
    {

        return s1;
    }

    public StudentResponseDTO addStudent(StudentRequestDTO student)
    {
        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setAge(student.getAge());

        StudentProfile profile = new StudentProfile();
        profile.setCity(student.getCity());
        profile.setPhone(student.getPhone());

        student1.setProfile(profile);
        profile.setStudent(student1);

        studentRepository.save(student1);

        StudentProfileResponseDTO profileResponseDTO = new StudentProfileResponseDTO(
                student1.getProfile().getId(),
                student1.getProfile().getCity(),
                student1.getProfile().getPhone()
        );

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student1.getId());
        studentResponseDTO.setName(student1.getName());
        studentResponseDTO.setAge(student1.getAge());
        studentResponseDTO.setProfileResponseDTO(profileResponseDTO);


        return studentResponseDTO;
    }


    public StudentResponseDTO getStudentById(int id) {
        Student student1 = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found"));
        StudentProfileResponseDTO profileResponseDTO = new StudentProfileResponseDTO(
                student1.getProfile().getId(),
                student1.getProfile().getCity(),
                student1.getProfile().getPhone()
        );

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student1.getId());
        studentResponseDTO.setName(student1.getName());
        studentResponseDTO.setAge(student1.getAge());
        studentResponseDTO.setProfileResponseDTO(profileResponseDTO);
        return studentResponseDTO;
    }

    public StudentResponseDTO updateStudentById(int id, StudentRequestDTO stud) {

        Student student1 = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found"));

        student1.setName(stud.getName());
        student1.setAge(stud.getAge());

        studentRepository.save(student1);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student1.getId());
        studentResponseDTO.setName(student1.getName());
        studentResponseDTO.setAge(student1.getAge());
        return studentResponseDTO;

    }

    public StudentResponseDTO
    deleteStudentById(int id) {
        Student student1 = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found"));
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student1.getId());
        studentResponseDTO.setName(student1.getName());
        studentResponseDTO.setAge(student1.getAge());
        studentRepository.delete(student1);
        return studentResponseDTO;
    }

    public List<StudentResponseDTO> getStudentsOlderThan(int age) {

        List<StudentResponseDTO> studentResponseDTOList = new ArrayList<>();
        List<Student> students = studentRepository.findStudentsOlderThan(age);

        for( Student student: students)
        {
            StudentResponseDTO dto = new StudentResponseDTO();
            dto.setName(student.getName());
            dto.setAge(student.getAge());
            studentResponseDTOList.add(dto);
        }
        return studentResponseDTOList;


    }

    //how to convert page of type student to student response dto
    public Page<StudentResponseDTO> getStudentsByPage(int page, int size, String sortBy, String direction) {

        Sort sort;

        if(direction.equalsIgnoreCase("desc"))
        {
            sort = Sort.by(sortBy).descending();
        }
        else
        {
            sort = Sort.by(sortBy).ascending();
        }
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Student> studentPage= studentRepository.findAll(pageable);

        Page<StudentResponseDTO> response = studentPage.map(student -> new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getAge()
        ));

        return response;
    }
}
