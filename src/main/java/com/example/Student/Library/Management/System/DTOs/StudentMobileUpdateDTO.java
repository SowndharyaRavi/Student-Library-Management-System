package com.example.Student.Library.Management.System.DTOs;

public class StudentMobileUpdateDTO {

    private String mobileNo;

    private int id;

    public StudentMobileUpdateDTO() {
    }

    public StudentMobileUpdateDTO(String mobileNo, int id) {
        this.mobileNo = mobileNo;
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
