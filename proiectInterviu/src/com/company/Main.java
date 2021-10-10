package com.company;

import com.company.Clinic.Clinic;
import com.company.Persons.Doctor;
import com.company.Persons.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

      //  Doctor doc = new Doctor("plm", "plm2",80,"plm111",80);
        List<String> testList  = new ArrayList<>();


        Clinic clinic = new Clinic();

        clinic.PrintSummary();
        clinic.saveDoctors();
        for(Doctor d: clinic.getWorkingDoctors()){
            System.out.println(d.toString());
        }
        clinic.savePatients();
        //saving Docs is saveDoctors

        for(int i=0;i<100;i++)
            clinic.AssignPatient();





        for(Doctor d : clinic.getAllDoctors()){
            System.out.println(d.toString2());
        }
    }



}
