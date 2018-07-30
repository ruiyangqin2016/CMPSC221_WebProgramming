package Exercise4_ArrayProblem;

import java.util.ArrayList;

public class RecursiveArray {

    public static ArrayList<String> rowData = new ArrayList<>();
    public static String rowStringData = "";
    public static int ROW = 0;
    public static String[][] data = {
            {"A"},
            {"1"},
            {"2","3","C","L"},
            {"XX", "YY"}
    };

    public static void main(String[] args) {
        showArray();
        buildArr(data,ROW);
        display();
    }

    public static void buildArr(String data[][], int ROW){
        if(ROW == data.length){
            rowData.add(rowStringData);
        }else{
            for(int COLUMN = 0; COLUMN < arrDataNum(data); COLUMN ++){
                try{
                    rowStringData += data[ROW][COLUMN]+" ";
                    buildArr(data,ROW+1);//add by row(Vertically)
                    rowStringData = removeFromString(rowStringData);
                }catch(ArrayIndexOutOfBoundsException AE){ }
            }
        }
    }

    /**
     * Make sure: if the longest row is longer than the colum, the buildArr is still fully functional
     * Length should be the longest one
     * Using try catch to deal with those shortage arrays in 2D array
     * @param data
     * @return
     */
    public static int arrDataNum(String[][] data){
        int longest = data.length;
        for(int i = 0; i < data.length; i ++){
            if(longest<=data[i].length){
                longest = data[i].length;
            }
        }
        return longest;
    }

    public static void display(){
        for(int i = 0; i < rowData.size(); i ++){
            System.out.println(rowData.get(i));
        }
    }

    /**
     * remove last element which is added to rowStringData
     * @param StringData
     * @return
     */
    public static String removeFromString(String StringData){
        String a = "";
        String[] arrStringData = StringData.split(" ");
        for(int i = 0; i < arrStringData.length - 1; i ++){
            a += arrStringData[i]+" ";
        }
        return a;
    }

    public static void showArray(){
        System.out.println("2-D Array: ");
        for(int row = 0; row < data.length; row++){
            for(int i = 0; i < data.length; i++){
                try{
                    System.out.print(data[row][i]+" ");
                }catch(ArrayIndexOutOfBoundsException AE){
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
