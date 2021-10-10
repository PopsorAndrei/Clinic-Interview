package com.company.Persons;

import jdk.jfr.Category;

import java.util.Calendar;

public class Patient {

    String firstName;
    String lastName;
    int age;
    String reason;
    String category;

    public Patient(String fName, String lName, int age, int reason) {

        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
        if (reason == 0)
            this.reason = "consultation";
        else if (reason == 1)
            this.reason = "treatment";
        else
            this.reason = "prescription";

        //assigning the category;

        if (age <= 1) {
            category = "Child";
        } else if (age <= 7)
            category = "Pupil";
        else if (age <= 18)
            category = "Student";
        else
            category = "Adult";

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(int reason) {
        if (reason == 1)
            this.reason = "consultation";
        else if (reason == 2)
            this.reason = "treatment";
        else
            this.reason = "prescription";
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" Last Name: " + this.lastName);
        stringBuilder.append(" First Name: " + this.firstName);
        stringBuilder.append(" Age: " + this.age);
        stringBuilder.append(" Reason: " + this.reason);


        return stringBuilder.toString();
    }
}
