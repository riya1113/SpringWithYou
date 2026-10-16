package com.example.studentapp.dto;

public class CourseRequestDTO {
    private String course;

    public CourseRequestDTO(String course) {
        this.course = course;
    }

    public CourseRequestDTO() {
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
