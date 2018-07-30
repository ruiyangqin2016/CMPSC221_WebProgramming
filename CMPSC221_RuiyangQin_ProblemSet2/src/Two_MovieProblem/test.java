package Two_MovieProblem;

public class  test {
    public static void main(String[] args) {
        Action a = new Action(4,"B","1987","Sharks");
        Comedy b = new Comedy(7,"S","2010","ABAB");
        Drama c = new Drama(19,"G","1978","GHJ");
        System.out.println("The late fee for Action type is "+a.lateFee());
        System.out.println("The late fee for Comedy type is "+b.lateFee());
        System.out.println("The late fee for Drama type is "+c.lateFee());
    }


}
