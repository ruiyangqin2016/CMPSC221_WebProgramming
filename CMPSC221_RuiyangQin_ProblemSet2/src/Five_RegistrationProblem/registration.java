package Five_RegistrationProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class registration {
    private ArrayList<String> course = new ArrayList<>();
    public static ArrayList<String> IDList = new ArrayList<>();
    public static Map<String,ArrayList<String>> student = new HashMap<>();
    private Integer IDNum;

    public registration(){
        //Default constructor
    }

    public registration(int IDNum, ArrayList<String> course){
        this.IDNum = IDNum;
        this.course = course;
    }

    public ArrayList<String> getCourse() {
        return course;
    }

    public void setCourse(ArrayList<String> course) {
        this.course = course;
    }

    public void setIDNum(Integer IDNum){
        this.IDNum = IDNum;
    }

    public void setStudent(Map<String, ArrayList<String>> student){
        this.student = student;
    }

    public Integer getIDNum(){
        return IDNum;
    }

    public Map<String,ArrayList<String>> student(){
        return student;
    }

    public void Menu(){
        System.out.println("==================");
        System.out.println("| 0. Exit.       |");
        System.out.println("| 1. Add Student.|");
        System.out.println("| 2. Add course. |");
        System.out.println("| 3. Show info.  |");
        System.out.println("==================");
        System.out.print("Please enter the head number: ");
    }

    public void display(){
        for(int i = 0;i < student.size();i ++){
            System.out.print(IDList.get(i)+": ");
            System.out.print(student.get(IDList.get(i))+" ");
            System.out.println("");
        }
    }

    public static boolean IDExist(String a){
        int b = 0;
        for(int i = 0; i<IDList.size();i++){
            if(a.equals(IDList.get(i))){b = 1;}
        }
        return (b==1);
    }

    public void addCourse(){
        System.out.print("Please enter your student ID: ");
        Scanner input1 = new Scanner(System.in);
        String ID = input1.nextLine();
        if(IDExist(ID)){
            System.out.print("Please enter your adding course: ");
            Scanner input2 = new Scanner(System.in);
            String course = input2.nextLine();
            student.get(ID).add(course);
        }else{
            System.out.println("Sorry, please add your information first.");
        }
    }

    public void addStudent(){
        ArrayList<String> Course = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the new student ID: ");
        String ID = input.nextLine();
        IDList.add(ID);
        student.put(ID,Course);
    }

    public static void main(String[] arg){
        registration a = new registration();
        a.Menu();
        Scanner input = new Scanner(System.in);
        int headNum = input.nextInt();
        while(headNum != 0){
             if(headNum == 1){//add courses
                 a.addStudent();
                 a.Menu();
                 Scanner input3 = new Scanner(System.in);
                 int headNum1 = input3.nextInt();
                 headNum = headNum1;
             }if(headNum == 2){
                 a.addCourse();
                 a.Menu();
                 Scanner input3 = new Scanner(System.in);
                 int headNum1 = input3.nextInt();
                 headNum = headNum1;
             }if(headNum == 3){
                 a.display();
                 a.Menu();
                 Scanner input3 = new Scanner(System.in);
                 int headNum1 = input3.nextInt();
                 headNum = headNum1;
             }
        }
        System.out.println("Thank you very much!");
    }

}
