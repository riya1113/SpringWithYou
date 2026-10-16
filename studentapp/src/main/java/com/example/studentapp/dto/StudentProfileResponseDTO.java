package com.example.studentapp.dto;

public class StudentProfileResponseDTO {

    private int id;
    private String city;
    private String phone;

    public StudentProfileResponseDTO(int id, String city, String phone) {
        this.id = id;
        this.city = city;
        this.phone = phone;
    }

    public StudentProfileResponseDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
