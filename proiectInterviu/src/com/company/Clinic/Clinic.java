package com.company.Clinic;

import com.company.Persons.Doctor;
import com.company.Persons.Patient;

import javax.print.Doc;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Clinic {




        int currentRoomNr =0;
        List<ConsultingRoom> consultingRoomList = new ArrayList<>();
        List<Doctor> workingDoctors = new ArrayList<>(); //ATENTIE AICI IS AIA CARE SUNT DE ASSIGNAT
        List<Patient> waitingPatients = new ArrayList<>();
        List<Doctor> allDoctors = new ArrayList<>();


        public Clinic(List<Doctor> doctorsList, List<Patient> patientList){
            workingDoctors = doctorsList;
            waitingPatients = patientList;

               ConsultingRoom consultingRoom1 = new ConsultingRoom(workingDoctors);
               ConsultingRoom consultingRoom2 = new ConsultingRoom(workingDoctors);
               ConsultingRoom consultingRoom3 = new ConsultingRoom(workingDoctors);
               ConsultingRoom consultingRoom4 = new ConsultingRoom(workingDoctors);
               consultingRoomList.add(consultingRoom1);
               consultingRoomList.add(consultingRoom2);
               consultingRoomList.add(consultingRoom3);
               consultingRoomList.add(consultingRoom4);
        }

        //Testing constructor with tasks
        public Clinic(){
            workingDoctors = new ArrayList<>();
            waitingPatients = new ArrayList<>();
            GenerateRandomDoctors(7);
            GenerateRandomPatients(1000);
            List<Doctor> allDoctorCopy = new ArrayList<>();
            allDoctorCopy.addAll(workingDoctors);
            this.allDoctors = allDoctorCopy;
            System.out.println("SA CREAT CLINICA");
            ConsultingRoom consultingRoom1 = new ConsultingRoom(workingDoctors);
            ConsultingRoom consultingRoom2 = new ConsultingRoom(workingDoctors);
            ConsultingRoom consultingRoom3 = new ConsultingRoom(workingDoctors);
            ConsultingRoom consultingRoom4 = new ConsultingRoom(workingDoctors);
            consultingRoomList.add(consultingRoom1);
            consultingRoomList.add(consultingRoom2);
            consultingRoomList.add(consultingRoom3);
            consultingRoomList.add(consultingRoom4);

        }

    public List<Doctor> getWorkingDoctors() {
        return workingDoctors;
    }

    public List<Patient> getWaitingPatients() {
        return waitingPatients;
    }

    public void setWorkingDoctors(List<Doctor> workingDoctors) {
        this.workingDoctors = workingDoctors;
    }

    public List<Doctor> getAllDoctors() {
        return allDoctors;
    }

    public int FindCurrentPatient(){
            //check if there is a child left
            for(Patient p :waitingPatients){
                if(p.getCategory().equals("Child"))
                    return waitingPatients.indexOf(p);
            }
            for(Patient p :waitingPatients){
                if(p.getCategory().equals("Pupil"))
                    return waitingPatients.indexOf(p);
            }
            for(Patient p :waitingPatients){
                if(p.getCategory().equals("Student"))
                    return waitingPatients.indexOf(p);
            }

            //this or without this it should be the same

//            for(Patient p :waitingPatients){
//                if(p.getCategory() =="Adult")
//                    return waitingPatients.indexOf(p);
//            }
            return 0;
        }

        public void AssignPatient(){
            Patient currentPatient = waitingPatients.remove(FindCurrentPatient());
            consultingRoomList.get(currentRoomNr).Assign(currentPatient);
            currentRoomNr++;
            System.out.println("Patient with name" + currentPatient.getFirstName() + " was assigned to consulting room " + currentRoomNr);
            if(currentRoomNr >consultingRoomList.size()-1)
                currentRoomNr =0;
        }

    public List<ConsultingRoom> getConsultingRoomList() {
        return consultingRoomList;
    }

    public void setConsultingRoomList(List<ConsultingRoom> consultingRoomList) {
        this.consultingRoomList = consultingRoomList;
    }

    public void GenerateRandomDoctors(int numberOfDocs){

            Random rand = new Random();

            for(int i= 0;i<numberOfDocs;i++) {
                String firstName = generateRandomString(3);
                String lastName = generateRandomString(2);
                int age = 30 + rand.nextInt(36);
                String uniqueNumber = generateRandomNumber();

                while(!checkIfUnique(uniqueNumber)){
                    uniqueNumber = generateRandomNumber();
                }

                workingDoctors.add(new Doctor(firstName,lastName,age,uniqueNumber,7));
                //7 is there for workingHOurs because i had no idea if this number should be random as well
                //let us se the generated doctors details
                System.out.println(firstName +" last name: " + lastName + " age : " + age + " unique number: " + uniqueNumber );
            }
        }

        String generateRandomString(int size){
            Random rand =new Random();
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            rightLimit -=leftLimit; //this will hopefully make some sense later a bit
            String finalName="";
            char aux;
            for(int i = 0 ;i<size;i++){
                aux = (char) (leftLimit +  rand.nextInt(rightLimit));
                finalName+=aux;
            }
            return finalName;
        }
        String generateRandomNumber(){
            Random rand = new Random();
            String id = String.format("%04d", rand.nextInt(10000));
            return id;
        }
        boolean checkIfUnique(String identificationNumber) {
            for (Doctor d : workingDoctors) {
                if (d.getIdentificationNumber().equals(identificationNumber)) {
                    return false;
                }
            }
            return true;
        }

        public void GenerateRandomPatients(int nrOfPatients){
            Random rand = new Random();

            for(int i= 0;i<nrOfPatients;i++) {
                String firstName = generateRandomString(5);
                String lastName = generateRandomString(4);
                int age =rand.nextInt(86);
                int reason = rand.nextInt(3);
                //let us se the generated doctors details

                waitingPatients.add(new Patient(firstName,lastName,age,reason));
                String actualReason ="";
                if(reason ==0)
                    actualReason = "consultation";
                else if(reason==1)
                    actualReason = "treatment";
                else
                    actualReason = "prescription";
                System.out.println(firstName +" last name: " + lastName + " age : " + age + " motiv: " + actualReason );

                //if there are no ppl of certain group, add one;
                if(getNumberOfCertainAgeGroup("Child")==0){
                    waitingPatients.add(new Patient("john","someLastname",1,1));
                }
                if(getNumberOfCertainAgeGroup("Pupil")==0){
                    waitingPatients.add(new Patient("john","someLastname",5,1));
                }
                if(getNumberOfCertainAgeGroup("Student")==0){
                    waitingPatients.add(new Patient("john","someLastname",17,1));
                }
                if(getNumberOfCertainAgeGroup("Adult")==0){
                    waitingPatients.add(new Patient("john","someLastname",42,1));
                }
                //i should repeat this for the reason but i wont do it beacuse of 2 reasons. 1: there is a slim chance that form 100 patients not even 1 to be of a certain category. 2: I am lazy :)
            }
        }

        public void PrintSummary(){
            int nrChildren = 0;
            int nrPupil = 0;
            int nrStudents = 0;
            int nrAdults = 0;

            for(Patient p:waitingPatients){
                if(p.getCategory().equals("Child"))
                    nrChildren++;
                else if(p.getCategory().equals("Pupil"))
                    nrPupil++;
                else if(p.getCategory().equals("Student"))
                    nrStudents++;
                else
                    nrAdults++;
            }
            System.out.println("Children (0-1) :" + nrChildren + "Patients");
            System.out.println("Pupil (1-7) :" + nrPupil + "Patients");
            System.out.println("Students (7-18) :" + nrStudents + "Patients");
            System.out.println("Children (>18) :" + nrAdults + "Patients");
        }

        int getNumberOfCertainAgeGroup(String AgeGroup){
            int nrOfKids = 0;
            for(Patient p:waitingPatients){
                if(p.getCategory().equals(AgeGroup))
                    nrOfKids++;

            }
            return nrOfKids;
        }
        public void saveDoctors() {
            try {
                BufferedWriter bw = new BufferedWriter(
                        new FileWriter("C:\\Users\\User\\Desktop\\proiectInterviu\\Doctors.txt")
                );
                for(Doctor doctor: workingDoctors){
                    bw.write(doctor.toString() +"\n");
                }
                bw.close();

            } catch (Exception ex) {
                return;
            }
        }

        public void savePatients(){
            try {
                BufferedWriter bw = new BufferedWriter(
                        new FileWriter("C:\\Users\\User\\Desktop\\proiectInterviu\\Patients.txt")
                );
                for(Patient patient :waitingPatients){
                    bw.write(patient.toString()+ "\n");
                }
                bw.close();

            } catch (Exception ex) {
                return;
            }
        }

}
