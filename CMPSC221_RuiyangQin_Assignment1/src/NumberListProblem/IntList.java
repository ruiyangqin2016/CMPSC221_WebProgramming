/*
Author: Ruiyang Qin
Date: Sept. 18, 2017
CMPSC 221, Assignment 1 Question6
Description: adjust the list to get more information about it
 */
package NumberListProblem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


public class IntList {

    private int[] list;
    ArrayList<String> ArrList = new ArrayList<>();

    public int[] getList() {
        return list;
    }

    public void setList(int[] list) {
        this.list = list;
    }

    public void add(){
        System.out.print("Please enter the number: ");
        Scanner input1 = new Scanner(System.in);
        String num = input1.nextLine();
        ArrList.add(num);
    }

    public void castToArray(){
        String a;
        int b;
        list = new int[ArrList.size()];
        for(int i = 0; i<list.length;i++){
            a = ArrList.get(i)+"";
            b = Integer.parseInt(a);
            list[i] = b;
        }
    }

    public void sort(int[] a){
        int temp = 0;
        for(int i = 0; i < a.length; i ++){
            for (int j = 0; j <a.length-i-1;j++){
                if(a[j+1]<=a[j]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }

    public int count(int[] a, int b){
        int num = 0;
        for(int i = 0; i < a.length; i ++){
            if(a[i] == b){
                num = num + 1;
            }
        }
        return num;
    }

    public void output(){
        castToArray();
        sort(list);
        int numDiffNum = 1;
        for(int i = 0; i < list.length-1; i ++){
            if(list[i]!=list[i+1]){
                numDiffNum++;
                if(i+1==list.length){
                    numDiffNum++;
                }
            }
        }
        int[] smallList = new int[numDiffNum];
        smallList[0]=list[0];
        int a =1;
        for(int i = 0; i<list.length-1;i++){
            if(list[i]!=list[i+1]){
                smallList[a]=list[i+1];
                a++;
            }
        }
        sort(smallList);
        System.out.println(" N               Count");
        for(int i = 0; i<smallList.length;i++){
            System.out.print(smallList[i]);
            for(int i1 =0; i1<19-(smallList[i]+"").length();i1++){
                System.out.print(" ");
            }
            System.out.println(count(list,smallList[i]));
        }
    }

    public void print(){
        castToArray();
        sort(list);
        for(int i = 0; i<list.length;i++){
            System.out.print(list[i]+" ");
        }
        System.out.println("");
    }

    public void Menu(){
        System.out.println("=================");
        System.out.println("| 0. Exit.      |");
        System.out.println("| 1. Add.       |");
        System.out.println("| 2. Output.    |");
        System.out.println("| 3. Print list.|");
        System.out.println("=================");
        System.out.print("Enter the head number: ");
    }

    public static void main(String[] args) {
        IntList a = new IntList();
        a.Menu();
        Scanner input1 = new Scanner(System.in);
        int headNum = input1.nextInt();
        while(headNum!=0){
            if(headNum==1){
                a.add();
            }else if(headNum==2){
                a.output();
            }else if(headNum==3){
                a.print();
            }
            a.Menu();
            Scanner input2 = new Scanner(System.in);
            int headNum1 = input2.nextInt();
            headNum=headNum1;
        }
        System.out.println("Thank you very much!");
    }
}
