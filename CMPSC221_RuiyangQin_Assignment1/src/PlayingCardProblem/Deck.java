/*
Author: Ruiyang Qin
Date: Sept. 18, 2017
CMPSC 221, Assignment 1 Question5
Description: 52 cards thing. add or remove, shuffle, etc.
 */
package PlayingCardProblem;

import java.util.*;

public class Deck
{
    private final String[] shape = {"club", "diamond", "heart", "spade"};//give club for 20, diamond for 40, heart for 60 and spade for 80
    private final String[] num = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};//give 1 to 2, 2 to 2,  etc
    ArrayList<String> cards = new ArrayList<String>();

    public ArrayList<String> getCards() {
        return cards;
    }

    public void setCards(ArrayList<String> cards) {
        this.cards = cards;
    }

    public void print() {
        for(int i = 0;i < cards.size();i ++) {
            System.out.print(cards.get(i)+" ");
        }
        System.out.println("");
        System.out.println("");
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public boolean checkShape(String a){
        return (a.equals("club")||a.equals("diamond")||a.equals("heart")
                ||a.equals("spade"));
    }

    public boolean checkNum(String a){
        return (a.equals("2")||a.equals("3")||a.equals("4")
                ||a.equals("5")||a.equals("6")||a.equals("7")
                ||a.equals("8")||a.equals("9")||a.equals("10")
                ||a.equals("J")||a.equals("Q")||a.equals("K")
                ||a.equals("A"));
    }

    public boolean checkExist(String card) {
        int countNum = 0;
        String splieCard[] = card.split(" ");
        for(int i=0;i<cards.size();i++){
            if (cards.get(i).split(" ")[0]==splieCard[0]){
                if(cards.get(i).split(" ")[1]==splieCard[1]){
                    countNum = 1;
                }
            }
        }
        return countNum == 1;
    }

    public void addCard() {
        Scanner input = new Scanner(System.in);
        System.out.print("What kind of card you want to add(heart, club, diamond, spade)? ");
        String addKind = input.nextLine();
        while(!checkShape(addKind)){
            System.out.print("Wrong word, please try again: ");
            String tryKind = input.nextLine();
            addKind = tryKind;
        }
        addKind.toLowerCase();
        System.out.print("What number you want(2,3,4,5,6,7,8,9,10,J,Q,K,A)? ");
        String addNum = input.nextLine();
        while(!checkNum(addNum)){
            System.out.print("Wrong word, please try again: ");
            String tryNum = input.nextLine();
            addNum = tryNum;
        }
        Card c = new Card(addKind,addNum);
        if(!checkExist(c.toString())) {
            cards.add(c.toString());
        }else{
            System.out.println("Sorry, you have this card.");
        }
    }

    public void removeCard() {
        Scanner input = new Scanner(System.in);
        System.out.print("What kind of card you want to remove(heart, club, diamond, spade)? ");
        String removeKind = input.nextLine();
        while(!checkShape(removeKind)){
            System.out.print("Wrong word, please try again: ");
            String tryKind = input.nextLine();
            removeKind = tryKind;
        }
        System.out.print("What number you want(2,3,4,5,6,7,8,9,10,J,Q,K,A)? ");
        String removeNum = input.nextLine();
        while(!checkNum(removeNum)){
            System.out.print("Wrong word, please try again: ");
            String tryNum = input.nextLine();
            removeNum = tryNum;
        }
        Card c = new Card(removeKind,removeNum);
        if(!checkExist(c.toString())) {
            cards.remove(c.toString());
        }else{
            System.out.println("Sorry, you need to add one first.");
        }
    }

    public int transferCardToNum(String a){
        int i = 0;
        while (!a.split(" ")[0].equals(shape[i])){i++;}
        int i1 = 0;
        while (!a.split(" ")[1].equals(num[i1])){i1++;}
        return i*20+i1;
    }
    public void sort() {
        String temp = "";
        for (int i = 0; i < cards.size(); i ++){
            for (int j = 0; j < cards.size() - 1 - i; j ++){
                if(transferCardToNum(cards.get(j + 1))<transferCardToNum(cards.get(j))){
                    temp = cards.get(j);
                    cards.remove(j); cards.add(cards.get(j+1));
                    cards.remove(j+1); cards.add(temp);
                }
            }
        }
    }

    public void Menu(){
        System.out.println("===================");
        System.out.println("|  0. Exit.       |");
        System.out.println("|  1. Add.        |");
        System.out.println("|  2. Remove.     |");
        System.out.println("|  3. Shuffle.    |");
        System.out.println("|  4. Print.      |");
        System.out.println("|  5. Sort cards. |");
        System.out.println("===================");
        System.out.print("Enter the head number: ");
    }

    public static void main(String[] args) {
        Deck d = new Deck();
        d.Menu();
        Scanner input1 = new Scanner(System.in);
        int headNum = input1.nextInt();
        while(headNum != 0){
            if(headNum == 1){
                d.addCard();
            }else if(headNum == 2){
                d.removeCard();
            }else if(headNum == 3){
                d.shuffle();
            }else if(headNum == 4){
                d.print();
            }else if(headNum == 5){
                d.sort();
            }
            d.Menu();
            Scanner input2 = new Scanner(System.in);
            int headNum1 = input2.nextInt();
            headNum = headNum1;
        }
        System.out.println("Thank you very much!");
    }
}
