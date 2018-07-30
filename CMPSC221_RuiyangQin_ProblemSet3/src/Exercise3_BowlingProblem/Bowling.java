package Exercise3_BowlingProblem;

import java.util.Scanner;

public class Bowling {

    public static void main(String[] args) {

        System.out.print("Enter 1 for keep going and 0 for exit: ");
        Scanner menu = new Scanner(System.in);
        int headNum = menu.nextInt();
        while(headNum != 0){
            System.out.print("How much row you want to build: ");
            Scanner input = new Scanner(System.in);
            int row = input.nextInt();
            System.out.println("Total: "+totalPT(row));

            System.out.print("Enter 1 for keep going and 0 for exit: ");
            Scanner menu1 = new Scanner(System.in);
            headNum = menu1.nextInt();
        }
        System.out.println("Thank you so much!");
    }

    public static Integer totalPT(Integer row){
        if(row == 0){
            return 0;
        }else{
            return totalPT(row-1)+row;
        }
    }
}
