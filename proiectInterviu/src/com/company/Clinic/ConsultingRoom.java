package com.company.Clinic;

import com.company.Persons.Doctor;
import com.company.Persons.Patient;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.List;
import java.util.*;

public class ConsultingRoom {


    int remainingTimeOpen = 720; //at first it is set to 720 minutes (12 hours), and after each procedure (depending on what was executed the)
    //remaining time decreases
    Doctor currentDoctor;
    int doctorsRemainingTime;
    int moneyEarned = 0;
    boolean hasDoctorAvailable = false;
    List<Doctor> workingDoctors;

    ConsultingRoom( List<Doctor> doctorsInCLinic){
        Doctor doctor = doctorsInCLinic.remove(0);
        currentDoctor = doctor;
        doctorsRemainingTime = doctor.getWorkingHours() *60;
        hasDoctorAvailable = true;
        workingDoctors = doctorsInCLinic;
    }
    ConsultingRoom(){
        doctorsRemainingTime = 0;
    }

    void Assign(Patient patient){
        this.currentDoctor.consultPatient(patient);
        if(this.currentDoctor.getTimeWorked() >= this.currentDoctor.getWorkingHours()*60){
            changeDoctor();
        }

    }
    void changeDoctor(){
        try {
            this.currentDoctor = workingDoctors.remove(0);
        }catch (Exception ex){
            System.out.println("no more patients left or no doctors avalibleF");
            return;
        }
        this.hasDoctorAvailable = true;
    }


    //here i thought we might need to calculate worked hours and money earned per Room not doctor. might delete later
    void Consult(String reason){
        if(reason.equals("consultation")){
            remainingTimeOpen -=30;
            doctorsRemainingTime -=30;
            moneyEarned += 50;
        }
        else if(reason.equals("prescription")){
            remainingTimeOpen -=20;
            doctorsRemainingTime -=20;
            moneyEarned += 20;
        }else {
            remainingTimeOpen -=40;
            doctorsRemainingTime -=40;
            moneyEarned += 35;
        }
        if(doctorsRemainingTime <=0)
            hasDoctorAvailable = false;
    }


}
