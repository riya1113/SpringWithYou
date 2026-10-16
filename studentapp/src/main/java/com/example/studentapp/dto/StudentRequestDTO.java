package com.example.studentapp.dto;

public class StudentRequestDTO {

    private String name;
    private int age;
    private String city;
    private String phone;

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

    public StudentRequestDTO() {
    }

    public StudentRequestDTO( String name, int age) {

        this.name = name;
        this.age = age;
    }

    public StudentRequestDTO(String name, int age, String city, String phone) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.phone = phone;
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
