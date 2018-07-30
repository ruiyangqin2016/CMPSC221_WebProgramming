/*
Author: Ruiyang Qin
Date: Sept. 18, 2017
CMPSC 221, Assignment 1 Question3
Description: selecting seats
 */
package SeatingProblem;

import java.util.Scanner;

public class Airplane {
    private String [][] seats = {
            {"A","B","C","D"},
            {"A","B","C","D"},
            {"A","B","C","D"},
            {"A","B","C","D"},
            {"A","B","C","D"},
            {"A","B","C","D"},
            {"A","B","C","D"}};

    public void display() {
        for(int i = 0; i < 7; i++) {
            System.out.print(i+" ");
            for(int j = 0; j < 4; j++) {
                System.out.print(seats[i][j]+"     ");
            }
            System.out.println("");
        }
    }

    public void selectSeat() {
        System.out.print("Enter the seat number you want(like 1A): ");
        Scanner input = new Scanner(System.in);
        String seatNumber = input.nextLine();

        //Make sure enter is Upper case
        String colSeat = seatNumber.charAt(1)+"";
        String colSeat1 = colSeat.toUpperCase();
        seatNumber = seatNumber.charAt(0)+colSeat1;

        System.out.print("Enter your name: ");
        Scanner input2 = new Scanner(System.in);
        String name = input2.nextLine();
        int col = Integer.parseInt(seatNumber.charAt(0)+"");
        String abcd[] = {"A","B","C","D"};
        int row = 0;
        while(!abcd[row].equals(seatNumber.charAt(1)+"")) { row++; }
        if(check_occupied(col,row)) {
            seats[col][row] = name;
        }else{
            System.out.println("Sorry, the seat is occupied.");
        }

    }

    public boolean check_empterSeat() {
        int empty_seat = 0;
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 4; j++) {
                if(seats[i][j].length() == 1) { empty_seat++; }
            }
        }
        return empty_seat != 0;
    }

    public boolean check_occupied(int col,int row) {
        return seats[col][row].length() == 1;
    }

    public void displayMenu() {
        System.out.println("------------------");
        System.out.println("| 0. Exit.       |");
        System.out.println("| 1. Select seat.|");
        System.out.println("------------------");
        System.out.print("Operating by enter the head number: ");
    }

    public static void main(String[] args) {
        Airplane a = new Airplane();
        a.display();
        a.displayMenu();
        Scanner input = new Scanner(System.in);
        int headNum = input.nextInt();
        while(headNum!=0) {
            if(a.check_empterSeat()) {
                a.selectSeat();
                a.display();
                a.displayMenu();
                Scanner input1 = new Scanner(System.in);
                int headNum1 = input1.nextInt();
                headNum = headNum1;
            }else{
                System.out.println("Sorry, this flight is full~");
                headNum=0;
            }
        }
        System.out.println("Thank you!");
    }
}
