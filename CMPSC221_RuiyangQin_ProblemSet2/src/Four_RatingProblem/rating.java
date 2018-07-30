package Four_RatingProblem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class rating {

    private String nameMov;
    private int ratingNum;
    public static Map<String,Integer> MovieInfo = new HashMap<>();
    public static Map<String,String> nameKind = new HashMap<>();

    public rating(){
        //Default constructor

    }

    public rating(String nameMov, int ratingNum){
        this.nameMov = nameMov;
        this.ratingNum = ratingNum;
    }

    public String getNameMov(){
        return nameMov;
    }

    public int getRatingNum(){
        return ratingNum;
    }

    public void setNameMov(String nameMov) {
        this.nameMov = nameMov;
    }

    public void setRatingNum(int ratingNum) {
        this.ratingNum = ratingNum;
    }

    public String[] diffName(){
        BufferedReader br;
        FileReader fr;
        try {
            fr = new FileReader("C:\\Users\\China\\IdeaProjects\\CMPSC221_RuiyangQin_ProblemSet2\\src\\Four_RatingProblem\\MovieInformation.txt");
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if(line.length()!=1){
                    nameKind.put(line,null);//only have each different name
                }
            }
            br.close();
        }catch (FileNotFoundException fnex){
            System.err.println("Exception!");
        }catch(IOException e){
            e.printStackTrace();
        }

        /**
         * get an array store different name
         */
        String arr[]=new String[nameKind.size()];
        String stringA = nameKind.toString();
        arr = stringA.split(",");
        for(int i = 0;i<arr.length;i++){
            arr[i] = arr[i].split("=")[0];
        }
        arr[0] = arr[0].replace("{","");
        for(int i = 0;i<arr.length;i++){
            arr[i] = arr[i].replace(" ","");
        }

        return arr;
    }

    public static void main(String[] args){

        rating a = new rating();
        BufferedReader br;
        FileReader fr;
        ArrayList<String> fileInfo = new ArrayList<>();
        String[] b = a.diffName();
        try {
            fr = new FileReader("C:\\Users\\China\\IdeaProjects\\CMPSC221_RuiyangQin_ProblemSet2\\src\\Four_RatingProblem\\MovieInformation.txt");
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                line.replace(" ","");
                fileInfo.add(line);
               // System.out.print(line+"|||");
            }
            br.close();
        }catch (FileNotFoundException fnex){
            System.err.println("Exception!");
        }catch(IOException e){
            e.printStackTrace();
        }

        String[] d = new String[fileInfo.size()];
        for(int i = 0;i<d.length;i++){
            d[i]=fileInfo.get(i);
            d[i]=d[i].replace(" ","");
        }


        int times;
        double sum;
        for(int i = 0;i<b.length;i++){
            times = 0;
            sum = 0;
            System.out.print(b[i]+": ");
            for(int j = 0;j<d.length;j++){
                if(d[j].length()!=1){
                    d[j].replace(" ","");
                    if(b[i].equals(d[j])){
                        times += 1;
                        sum += Integer.parseInt(d[j+1]);
                    }
                }
            }
            String result = String.format("%.1f",sum/times);
            System.out.print(times+" reviews, average of "+result
                    +" / 5");
            System.out.println("");
        }
    }

}
