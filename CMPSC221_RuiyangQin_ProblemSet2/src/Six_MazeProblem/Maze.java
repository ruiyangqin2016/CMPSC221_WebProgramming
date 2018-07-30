package Six_MazeProblem;

import java.util.ArrayList;
import java.util.Scanner;

public class Maze {

    private Node start;
    private Node finish;
    private int sizeOfNode;
    private static ArrayList<Node> storeMaze = new ArrayList<>();
    public static final String[] NSEW = {"N", "S", "E", "W"};

    /**
     * Default constructor
     */
    public Maze(){
        this.sizeOfNode = 0;
        this.start = null;
        this.finish = null;
    }

    public Maze(Node start, int sizeOfNode, Node finish){
        this.finish = finish;
        this.start = start;
        this.sizeOfNode = 12;
    }

    public Node getFinish() {
        return finish;
    }

    public void setFinish(Node finish) {
        this.finish = finish;
    }

    public Node getStart() { return start; }

    public void setStart(Node start) {
        this.start = start;
    }

    public int getSizeOfNode() {
        return sizeOfNode;
    }

    public void setSizeOfNode(int sizeOfNode) {
        this.sizeOfNode = sizeOfNode;
    }

    public Node holdData(String data){
        for(int i = 0; i < storeMaze.size(); i++){
            if(storeMaze.get(i).getData().equals(data))return storeMaze.get(i);
        }
        return null;
    }

    public void buildingMaze(String data, String direction, String dataInDir){
        Node addData = new Node(dataInDir,null,null,null,null);
        Node oriData = holdData(data);
        if(oriData == null){
            System.out.println("Wrong operation! ");
        }else{
            if(direction.equals(NSEW[0])){//North of original data have a node
                oriData.setNorth(addData);
                addData.setSouth(oriData);
            }
            if(direction.equals(NSEW[1])){//South of original data have a node
                oriData.setSouth(addData);
                addData.setNorth(oriData);
            }
            if(direction.equals(NSEW[2])){//East of original data have a node
                oriData.setEast(addData);
                addData.setWest(oriData);
            }
            if(direction.equals(NSEW[3])){//West of original data have a node
                oriData.setWest(addData);
                addData.setEast(oriData);
            }
        }
        storeMaze.add(addData);
    }

    public String checkDirection(Node node){
        ArrayList<String> directionAL = new ArrayList<>();
        if(node.getNorth() != null){
            directionAL.add("North");
        }
        if(node.getSouth() != null){
            directionAL.add("South");
        }
        if(node.getEast() != null){
            directionAL.add("East");
        }
        if(node.getWest() != null){
            directionAL.add("West");
        }
        String returnVal = " {  ";
        for(int i = 0; i< directionAL.size();i++){
            returnVal = returnVal + directionAL.get(i) + "  ";
        }
        returnVal+="}";
        return returnVal;
    }

    public void showMap(){
        String[][] map = {
                {"A","--","B","  ","C","--","D"},
                {"|","  ","|","  ","|","  "," "},
                {"E","  ","F","--","G","--","H"},
                {"|","  "," ","  ","|","  ","|"},
                {"I","--","J","  ","K","  ","L"}
        };
        for(int row = 0;row < 5;row ++){
            for(int col = 0;col < 7;col ++){
                System.out.print(map[row][col]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){
        Maze maze = new Maze();
        Node node = new Node("A",null,null,null,null);
        storeMaze.add(node);
        maze.buildingMaze("A","S","E");
        maze.buildingMaze("A","E","B");
        maze.buildingMaze("E","S","I");
        maze.buildingMaze("I","E","J");
        maze.buildingMaze("B","S","F");
        maze.buildingMaze("F","E","G");
        maze.buildingMaze("G","S","K");
        maze.buildingMaze("G","E","H");
        maze.buildingMaze("G","N","C");
        maze.buildingMaze("C","E","D");
        maze.buildingMaze("H","S","L");

        while(!node.getData().equals("L")){
            System.out.println("You are in room " + node.getData()
                    + " of a maze of twisty little passages, all alike. You can go"
                    + maze.checkDirection(node)
                    + " (N or S or E or W or ('O' to see map))");
            Scanner input = new Scanner(System.in);
            String direction = input.nextLine();
            direction = direction.toUpperCase().charAt(0)+"";
            Node next = maze.finish;
            if(direction.equals("E")){
                next = node.getEast();
            }else if(direction.equals("W")){
                next = node.getWest();
            }else if(direction.equals("S")){
                next = node.getSouth();
            }else if(direction.equals("N")){
                next = node.getNorth();
            }else if(direction.equals("O")){
                next = node;
                maze.showMap();
            }
            node = next;
        }

        System.out.println("You win! ");
    }
}
