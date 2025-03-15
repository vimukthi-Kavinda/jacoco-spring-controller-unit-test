package com.example.jacoco.dto;

public class RequestDto {
    private String name;
    private String address;

    public RequestDto(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public RequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
