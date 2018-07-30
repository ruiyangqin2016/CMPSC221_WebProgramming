package Exercise5_SubstringProblem;

import java.util.Scanner;

public class StringContains {

    public static void main(String[] args) {
        System.out.println("Notice: this programming isn't sensitive to capital letter ");
        System.out.print("Please enter your haystack: ");
        Scanner inputHS = new Scanner(System.in);
        String haystack = inputHS.nextLine();
        haystack = haystack.toLowerCase();
        System.out.print("Please enter your needle: ");
        Scanner inputNE = new Scanner(System.in);
        String needle = inputNE.nextLine();
        needle = needle.toLowerCase();

        System.out.println("Contain or not is: "+contains(haystack,needle));
    }
    public static boolean contains(String haystack, String needle){
        boolean CONTAIN;
        if(haystack.length() >= needle.length()){
            if(partialCompare(haystack,needle)){
                CONTAIN = true;
            }else{
                haystack = removeFirstLetter(haystack,needle);
                CONTAIN = contains(haystack,needle);
            }
        }else{
            CONTAIN = false;
        }

        return CONTAIN;
    }

    public static boolean partialCompare(String big, String small){
        boolean outcome = true;
        for(int i = 0; i < small.length(); i++){
            if(big.charAt(i) != small.charAt(i)){
                outcome = false;
            }
        }
        return outcome;
    }

    public static String removeFirstLetter(String big, String small){
        String newBig = "";
        for(int i = 1; i < big.length(); i++){
            newBig += big.charAt(i)+"";
        }
        return newBig;
    }
}
