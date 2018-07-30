package Exercise2_FormattingProblem;

import java.util.Scanner;
import java.util.*;

public class DateFormatter {

    public static String[] EngMonth = {"January", "February", "March", "April", "May",
            "July", "June", "Augest", "Spetember", "October", "November", "December"};

    public static void main(String[] args) {
        System.out.print("Enter 1(keep going) or 0(exit): ");
        Scanner inputHeadNum = new Scanner(System.in);
        int headNum = inputHeadNum.nextInt();
        int exception = 0;
        while(headNum != 0){
            if(headNum == 1){
                System.out.print("Please enter data in form(12/25/2000): ");
                Scanner inputData = new Scanner(System.in);
                String date = inputData.nextLine();
                String[] arrDate = date.split("/");
                try{
                    if(Integer.parseInt(arrDate[0])<1||Integer.parseInt(arrDate[0])>12){
                        exception++;
                        throw new DayException();
                    }
                }
                catch(DayException DE){
                    System.err.print(DE.getMessage()+" | ");
                }

                try{
                    if(Integer.parseInt(arrDate[1])<1||Integer.parseInt(arrDate[1])>31){
                        exception++;
                        throw new MonthException();
                    }
                }
                catch(MonthException ME){
                    System.err.print(ME.getMessage()+" | ");
                }

                try{
                    if(Integer.parseInt(arrDate[2])<1000||Integer.parseInt(arrDate[2])>3000){
                        exception++;
                        throw new YearException();
                    }
                }
                catch(YearException YE){
                    System.err.print(YE.getMessage()+" | ");
                }
                if(exception == 0)
                System.out.println("To the new Format: " + transFormat(date));
            }else{
                System.out.print("Wrong head number. Please enter 1(keep going) or 0(exit): ");
                Scanner input1 = new Scanner(System.in);
                int headNum1 = input1.nextInt();
                headNum = headNum1;
            }
            System.out.println("");
            System.out.print("Enter 1(keep going) or 0(exit): ");
            Scanner input1 = new Scanner(System.in);
            headNum = input1.nextInt();
            exception = 0;
        }
        System.out.println("Thank you very much!");
    }

    public static String transFormat(String date){
        String day, month, year;
        String[] arrDate = date.split("/");
        day = EngMonth[Integer.parseInt(arrDate[0])-1];
        return day + " " + arrDate[1] + "," + arrDate[2];
    }
}
