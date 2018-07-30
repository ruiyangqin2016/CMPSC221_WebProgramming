/*
Author: Ruiyang Qin
Date: Sept. 18, 2017
CMPSC 221, Assignment 1 Question2
Description: operating the mileage and calculate gas comsuming
 */
package DrivingProblem;

import java.util.Scanner;

public class Odometer {

    //Global variable
    private double miles;
    private double fuel_efficiency;

    public Odometer() {
        //default constructor
    }

    //constructor
    public Odometer(double miles,double fuel_efficiency) {
        this.fuel_efficiency=fuel_efficiency;
        this.fuel_efficiency=fuel_efficiency;
    }

    public double getMiles() {
        return miles;
    }

    // Mutator to reset the odometer to zero miles
    public double resetMiles() {
        miles=0;
        return miles;
    }

    // Mutator to set the fuel efficiency
    public double setFE() {
        System.out.print("Enter the fuel efficiency: ");
        Scanner input = new Scanner(System.in);
        double FE = input.nextDouble();
        fuel_efficiency = FE;
        return fuel_efficiency;
    }

    //Mutator to accept the miles driven and add them up to total
    public double setTT() {
        System.out.print("Enter the miles drive for a trip: ");
        Scanner input = new Scanner(System.in);
        double TT = input.nextDouble();
        miles=miles+TT;
        return miles;
    }

    //Accessor to return gas consuming
    public double GasCon(){ return miles*fuel_efficiency; }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public double getFuel_efficiency() {
        return fuel_efficiency;
    }

    public void setFuel_efficiency(double fuel_efficiency) {
        this.fuel_efficiency = fuel_efficiency;
    }

    public void display() {
        System.out.println("Miles: "+miles);
        System.out.println("Fuel Efficiency: "+fuel_efficiency);
    }

    public void displayMenu() {
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.println("| 0. exit.                   |");
        System.out.println("| 1. Reset mileage.          |");
        System.out.println("| 2. Set fuel efficiency.    |");
        System.out.println("| 3. Enter the driving miles.|");
        System.out.println("| 4. Gas consuming.          |");
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.print("Enter the head number: ");
    }


    public static void main(String[] args) {
         Odometer a = new Odometer(3000,20);
         a.displayMenu();;
         Scanner input = new Scanner(System.in);
         int headNum = input.nextInt();//choose which step to operate
        while (headNum!=0)
        {
            if(headNum==1) {
                a.resetMiles();
                a.display();
                System.out.println("");
                a.displayMenu();
                Scanner input1 = new Scanner(System.in);
                int headNum1 = input1.nextInt();
                headNum=headNum1;
            }else if(headNum==2) {
                a.setFE();
                System.out.println("");
                a.display();
                a.displayMenu();
                Scanner input1 = new Scanner(System.in);
                int headNum1 = input1.nextInt();
                headNum=headNum1;
            }else if (headNum==3) {
                a.setTT();
                a.display();
                System.out.println("");
                a.displayMenu();
                Scanner input1 = new Scanner(System.in);
                int headNum1 = input1.nextInt();
                headNum=headNum1;
            }else if (headNum==4) {
                System.out.println(a.GasCon());
                a.display();
                System.out.println("");
                a.displayMenu();
                Scanner input1 = new Scanner(System.in);
                int headNum1 = input1.nextInt();
                headNum=headNum1;
            }
        }
        System.out.println("Thank you so much!!!");
    }
}



