package com.example.MyHealth.retroapi.retromod;

public class IDcheck {
    private String nationalID;
    private String firstName;
    private String lastName;
    private String otherName;


    public String getNationalIDNumber() {
        return nationalID;
    }

    public void setNationalIDNumber(String nationalIDNumber) {
        this.nationalID = nationalIDNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }
}
