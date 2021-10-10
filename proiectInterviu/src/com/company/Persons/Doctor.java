package com.company.Persons;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Doctor {

    String firstName;
    String lastName;
    int age;
    String identificationNumber;
    int workingHours;


    //hope i am right here
    int patientCount;
    int timeWorked;
    int moneyEarned;

    int CONSULTATION_PRICE = 50;
    int PRESCRIPTION_PRICE =20;
    int TREATMENT_PRICE = 35;

    int CONSULTATION_TIME = 50;
    int PRESCRIPTION_TIME = 20;
    int TREATMENT_TIME = 40;

    public Doctor(String fName, String lName, int age, String identificationNumber, int workingHours){
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
        this.identificationNumber = identificationNumber;
        if(workingHours <=7 && workingHours >0)
            this.workingHours = workingHours;
        else {
            System.out.println("A doctors hours can`t be greater than 7 or negative");
            System.out.println("Set them again");
            setValidWorkingHours();
        }
        int patientCount=0;
        int timeWorked=0;
        int moneyEarned=0;
    }

    public void setValidWorkingHours(){
        Scanner aux = new Scanner(System.in);
        int hours = -1;
        while(hours >=7 || hours < 0) {
            System.out.println("enter a valid hour for the doctor " + getFirstName());
            hours = aux.nextInt();
        }

        this.setWorkingHours(hours);
        System.out.println("Number of hours " + hours + " is set :)");
    }

    public void consultPatient(Patient patient){
        System.out.println("CONSULTING PATIENT!");
        patientCount++;
        if(patient.getReason().equals("consultation")){
            timeWorked += CONSULTATION_TIME;
            moneyEarned += CONSULTATION_PRICE;
        }else if(patient.getReason().equals("treatment")){
                timeWorked += TREATMENT_TIME;
                moneyEarned += TREATMENT_PRICE;
        }
        else{
            timeWorked += PRESCRIPTION_TIME;
            moneyEarned += PRESCRIPTION_PRICE;
        }
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

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }

    public int getTimeWorked() {
        return timeWorked;
    }

    public void setTimeWorked(int timeWorked) {
        this.timeWorked = timeWorked;
    }

    public int getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(int moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Last Name: " + this.lastName);
        stringBuilder.append("First Name: "+ this.firstName);
        stringBuilder.append("Age: " +this.age);
        stringBuilder.append("identification number: " + this.identificationNumber);
        stringBuilder.append("working hours: "+this.workingHours);

        return stringBuilder.toString();
    }
    public String toString2(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( this.lastName + ", ");
        stringBuilder.append( this.firstName + ", ");
        stringBuilder.append(" - " + this.identificationNumber +": ");
        stringBuilder.append(this.patientCount +" patients, ");
        stringBuilder.append(this.timeWorked +"minutes, ");
        stringBuilder.append(this.moneyEarned +"RON");

        return stringBuilder.toString();
    }
}
