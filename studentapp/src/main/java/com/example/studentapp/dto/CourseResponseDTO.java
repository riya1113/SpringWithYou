package com.example.studentapp.dto;

public class CourseResponseDTO {

    private int id;
    private String course;

    public CourseResponseDTO(int id, String course) {
        this.id = id;
        this.course = course;
    }

    public CourseResponseDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
