/*
Author: Ruiyang Qin
Date: Sept. 18, 2017
CMPSC 221, Assignment 1 Question1
Description: Show account information and
             be able to deposite and withdraw
 */
package AccountManagementProblems;

import java.util.Scanner;

public class Account {

    private long account_number;
    private String account_type;
    private String name;
    private double account_balance;

    public Account()
    {
        //this is a default constructor
    }

    public Account(long an, String at, String na, double ab)
    {
        this.account_number=an;
        this.account_type=at;
        this.name=na;
        this.account_balance=ab;
    }

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }

    public double deposite(double deposite_money)
    {
        Scanner input = new Scanner(System.in);
        while(deposite_money<0)
        {
            System.out.println("Sorry, you may not deposite negative money");
            System.out.print("Enter the money you want to deposite: ");
            double money = input.nextDouble();
            deposite_money=money;
        }
        return account_balance=account_balance+deposite_money;
    }

    public double withdraw(double withdraw_money)
    {
        Scanner input = new Scanner(System.in);
        double return_value;
        return_value=account_balance-withdraw_money;
        while(return_value<0)
        {
            System.out.println("Sorry, you may not withdraw money more than "+account_balance);
            System.out.print("Enter the money you want to withdraw: ");
            double money = input.nextDouble();
            return_value=account_balance-money;
        }
        account_balance=return_value;
        return return_value;
    }

    public void display()
    {
        System.out.println("Account number: "+account_number);
        System.out.println("Name: "+name);
        System.out.println("Account type: "+account_type);
        System.out.println("Account balance: "+account_balance);
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Account Tony = new Account(20103321,"Saving","Tony",5000000);
        System.out.print("Please enter your account number: (Please enter 20103321 for test)");
        long answer2 = input.nextLong();
        if(answer2==Tony.account_number)
        {
            Scanner input2=new Scanner(System.in);
            System.out.print("Start using your account? ");
            String answer1 = input2.nextLine();
            while (answer1.equals("Y") || answer1.equals("Yes") || answer1.equals("YES"))
            {
                Scanner input3=new Scanner(System.in);

                Tony.display();
                System.out.println("");
                System.out.println("deposite or withdraw ");
                String answer3 = input3.nextLine();
                if (answer3.equals("deposite") || answer3.equals("DEPOSITE"))
                {
                    Scanner input4=new Scanner(System.in);
                    System.out.print("Enter the money you want to deposite: ");
                    double money = input4.nextDouble();
                    Tony.deposite(money);
                    Scanner inpu5=new Scanner(System.in);
                    System.out.print("Continue? (Y or N)");
                    String answer4 = inpu5.nextLine();
                    answer1=answer4;
                } else {
                    Scanner inpu6=new Scanner(System.in);
                    System.out.print("Enter the money you want to withdraw: ");
                    double money = input.nextDouble();
                    Tony.withdraw(money);
                    System.out.print("Continue? (Y or N)");
                    String answer4 = inpu6.nextLine();
                    answer1=answer4;
                }
            }
        }
        Tony.display();
        System.out.println("Thank you very much！！！");
    }
}
