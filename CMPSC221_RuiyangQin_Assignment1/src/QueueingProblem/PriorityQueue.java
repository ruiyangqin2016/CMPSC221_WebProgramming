/*
Author: Ruiyang Qin
Date: Sept. 18, 2017
CMPSC 221, Assignment 1 Question4
Description: Do whatever the prority queue can do by
             using ArrayList
 */
package QueueingProblem;

import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.Scanner;

public class PriorityQueue {

    ArrayList<String> PriQueue = new ArrayList<>();

    public ArrayList<String> getPriQueue() {
        return PriQueue;
    }

    public void setPriQueue(ArrayList<String> priQueue) {
        PriQueue = priQueue;
    }

    public void enqueue(String info, int pos) {
        if(pos>=PriQueue.size()){
            pos = PriQueue.size();
            PriQueue.add(pos, info);
        }else{
            if(pos==0) {
                PriQueue.add(pos, info);
            }else{
                PriQueue.add(pos-1,info);
            }
        }
    }

    public void dequeue(String info){
        PriQueue.remove(info);
    }

    public void display() {
        for(int i = 0; i < PriQueue.size(); i ++) {
            System.out.print(PriQueue.get(i)+" ");
        }
        System.out.println("");
    }

    public void displayMenu() {
        System.out.println("==============");
        System.out.println("| 0. Exit.   |");
        System.out.println("| 1. Add.    |");
        System.out.println("| 2. Remove. |");
        System.out.println("==============");
        System.out.print("Please enter the head number: ");
    }

     public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        q.displayMenu();
        Scanner input = new Scanner(System.in);
        int headNum = input.nextInt();
        while(headNum != 0){
            if(headNum == 1) {
                System.out.print("Please enter the element you want to input: ");
                Scanner input1 = new Scanner(System.in);
                String info = input1.nextLine();
                System.out.print("Please enter the position: ");
                Scanner input2 = new Scanner(System.in);
                int pos = input2.nextInt();
                q.enqueue(info, pos);
                q.display();
                q.displayMenu();
                Scanner input3 = new Scanner(System.in);
                int headNum1 = input3.nextInt();
                headNum = headNum1;
            }else if(headNum == 2) {
                System.out.print("Please enter the element you want to remove: ");
                Scanner input3 = new Scanner(System.in);
                String reInfo = input3.nextLine();
                q.dequeue(reInfo);
                q.display();
                q.displayMenu();
                Scanner input4 = new Scanner(System.in);
                int headNum1 = input4.nextInt();
                headNum = headNum1;
            }
        }
        System.out.println("Thank you so much!");
    }
}

