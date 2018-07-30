package Exercise6_DictionaryProblem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class wordLadder {
    public static String replaceWord;
    public static int count = 0;
    public static ArrayList<String> position = new ArrayList<>();
    public static ArrayList<String> dictionary = new ArrayList<>();
    public static ArrayList<String> recordLadder = new ArrayList<>();
    public static String[] alphatable = {"a","b","c","d","e","f","j",
            "h","i","g","k","l","m","n","o","p","q","r","s","t","u",
            "v","w","z","y","z"};

    public static void main(String[] args) {
        /**
         * Setting for the game
         */
        buildDictionary();
        System.out.print("Please enter an English word: ");
        Scanner EnglishWord = new Scanner(System.in);
        String startWord = EnglishWord.nextLine().toLowerCase();
        while(!isEnglishWord(startWord)){
            System.out.print("Please enter an English word: ");
            Scanner EnglishWord1 = new Scanner(System.in);
            String startGame1 = EnglishWord1.nextLine().toLowerCase();
            startWord = startGame1;
        }
        System.out.print("Please enter a target English word: ");
        Scanner EnglishWord2 = new Scanner(System.in);
        String endWord = EnglishWord2.nextLine().toLowerCase();
        while(!isEnglishWord(endWord)){
            System.out.print("Please enter an English word: ");
            Scanner EnglishWord3 = new Scanner(System.in);
            String endWord1 = EnglishWord3.nextLine().toLowerCase();
            endWord = endWord1;
        }

        /**
         * recursion function
         */
        for(int i = 0; i < startWord.length(); i++){
            position.add(i+"");
        }
        ladder(startWord,endWord);
    }


    public static void ladder(String startWord, String endWord){
        System.out.println(startWord);
        if(startWord.equals(endWord)){
            System.out.println("There is a ladder!");
            System.exit(0);
        }else{
            if(startWord.length()!=endWord.length()){
                System.out.println("There will never be a ladder because of the difference of length~");
                System.exit(0);
            }else{
                for(int i = 0; i < startWord.length(); i++){
                    if(startWord.charAt(i) == endWord.charAt(i)){
                        if(!recordLadder.contains(startWord)){
                            recordLadder.add(startWord);
                        }
                        position.remove(i+"");
                    }
                }
                int pos = new Random().nextInt(position.size());
                startWord = replaceLetter(startWord,Integer.parseInt(position.get(pos)));
                while(!isEnglishWord(startWord))
                {
                    startWord = replaceLetter(startWord,Integer.parseInt(position.get(pos)));
                }

                if(recordLadder.contains(startWord))
                    count++;
                if(count >= position.size()*26){
                    System.out.println("Sorry, there is no ladder~");
                    System.exit(0);
                }
                ladder(startWord,endWord);
            }
        }
    }

    public static boolean isEnglishWord(String word){
        boolean exist = false;
        for(int i = 0; i < dictionary.size(); i ++){
            if(word.equals(dictionary.get(i)))
                exist = true;
        }
        return exist;
    }
    public static String replaceLetter(String word, int pos){
        replaceWord = word;
        String a = "";
        int posAlpha = new Random().nextInt(26);
        String letter = alphatable[posAlpha];
        for(int i = 0; i < pos; i++){
            a += word.charAt(i);
        }
        a += letter;
        for(int i = pos + 1; i < word.length(); i++){
            a += word.charAt(i);
        }
        return a;
    }
    public static void buildDictionary(){
        BufferedReader br;
        FileReader fr;
        try{
            fr = new FileReader("C:\\Users\\China\\IdeaProjects\\CMPSC221_RuiyangQin_ProblemSet3\\src\\Exercise6_DictionaryProblem\\words.txt");
            br = new BufferedReader(fr);

            String line;
            String lowerCase;
            while((line = br.readLine())!=null){
                line.toLowerCase();
                lowerCase = line.toLowerCase();
                dictionary.add(lowerCase);
            }
            br.close();
        }catch(FileNotFoundException FNFE){
        }catch(IOException e){ }
    }
}
