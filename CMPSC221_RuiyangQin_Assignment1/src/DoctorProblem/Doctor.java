/*
Author: Ruiyang Qin
Date: Sept. 18, 2017
CMPSC 221, Assignment 1 Question7
Description: make some information about doctors
 */
package DoctorProblem;

import java.util.Scanner;
import java.util.ArrayList;

public class Doctor extends SalariedEmployee{
    private String specilty;
    private double visitFee;

    public String getSpecilty() {
        return specilty;
    }

    public void setSpecilty(String specilty) {
        this.specilty = specilty;
    }

    public double getVisitFee() {
        return visitFee;
    }

    public void setVisitFee(double visitFee) {
        this.visitFee = visitFee;
    }

    public Doctor(String specilty, double visitFee) {

        this.specilty = specilty;
        this.visitFee = visitFee;
    }

    public boolean equals(Doctor otherDoctor){
        return (getName().equals(otherDoctor.getName())
        &&getHireDate().equals(otherDoctor.getHireDate())
        &&getSalary()==otherDoctor.getSalary()
        &&specilty==otherDoctor.specilty
        &&visitFee==otherDoctor.visitFee);
    }

    public String toString(){
        return specilty+" "+visitFee;
    }

    public static void main(String[] args) {
        Doctor d = new Doctor("Dermatologist",300.0);
        Doctor d1 = new Doctor("Dermatologist",300.0);
        if(d.equals(d1)){
            System.out.println("Two doctors are the same!");
        }else{
            System.out.println("Two doctors are not the same!");
        }
        System.out.println("Doctor1: "+d.toString());
        System.out.println("Doctor2: "+d1.toString());
    }
}




















