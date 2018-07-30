package Exercise1_AverageProblem;

import java.util.ArrayList;
import java.util.Scanner;

public class Average {

    public static void main(String[] args){

        int N;
        int enterNum;
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.print("Please enter how many numbers you want to input: ");
        Scanner inputN = new Scanner(System.in);
        N = inputN.nextInt();

        for(int i = 0; i < N; i ++){
            try{
                System.out.print("Please enter the number: ");
                Scanner inputNum = new Scanner(System.in);
                enterNum = inputNum.nextInt();
                if(enterNum < 0){
                    i--;
                    throw  new negativeIntegerException();
                }else{
                    numbers.add(enterNum);
                }
            }catch(negativeIntegerException NE){
                System.err.println("N must be positive. ");
            }
        }
        int sum = 0;
        for(int i = 0; i < numbers.size(); i++){
            sum += numbers.get(i);
        }
        System.out.println("The numbers you entered are: " + numbers.toString());
        System.out.println("The average of " + N + " numbers is " + sum/numbers.size());
    }
}
