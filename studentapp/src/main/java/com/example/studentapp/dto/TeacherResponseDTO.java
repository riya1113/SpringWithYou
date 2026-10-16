package com.example.studentapp.dto;

public class TeacherResponseDTO {

    private int id;
    private String name;
    private CourseResponseDTO courseResponseDTO;

    public TeacherResponseDTO(int id, String name, CourseResponseDTO courseResponseDTO) {
        this.id = id;
        this.name = name;
        this.courseResponseDTO=courseResponseDTO;
    }

    public TeacherResponseDTO() {
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

    public CourseResponseDTO getCourseResponseDTO() {
        return courseResponseDTO;
    }

    public void setCourseResponseDTO(CourseResponseDTO courseResponseDTO) {
        this.courseResponseDTO = courseResponseDTO;
    }
}
