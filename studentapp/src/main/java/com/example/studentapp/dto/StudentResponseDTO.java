package com.example.studentapp.dto;

public class StudentResponseDTO {

    private int id;
    private String name;
    private int age;
    private StudentProfileResponseDTO profileResponseDTO;
    private CourseResponseDTO courseResponseDTO;


    public StudentResponseDTO() {
    }

    public StudentResponseDTO(int id, String name, int age, StudentProfileResponseDTO profileResponseDTO, CourseResponseDTO courseResponseDTO) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.profileResponseDTO=profileResponseDTO;
        this.courseResponseDTO=courseResponseDTO;
    }

    public StudentResponseDTO(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public CourseResponseDTO getCourseResponseDTO() {
        return courseResponseDTO;
    }

    public void setCourseResponseDTO(CourseResponseDTO courseResponseDTO) {
        this.courseResponseDTO = courseResponseDTO;
    }

    public StudentProfileResponseDTO getProfileResponseDTO() {
        return profileResponseDTO;
    }

    public void setProfileResponseDTO(StudentProfileResponseDTO profileResponseDTO) {
        this.profileResponseDTO = profileResponseDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
