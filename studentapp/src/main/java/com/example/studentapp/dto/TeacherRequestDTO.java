package com.example.studentapp.dto;

public class TeacherRequestDTO {

    private String name;

    public TeacherRequestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
