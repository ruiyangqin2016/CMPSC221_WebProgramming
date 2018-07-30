package Six_MazeProblem;

public class Node {

    private String data;
    private Node North;
    private Node South;
    private Node East;
    private Node West;

    public Node(){
        //default constructor
    }

    public Node(String data, Node N, Node S, Node E, Node W) {
        this.data = data;
        this.North = N;
        this.South = S;
        this.East = E;
        this.West = W;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNorth() {
        return North;
    }

    public void setNorth(Node north) {
        this.North = north;
    }

    public Node getSouth() {
        return South;
    }

    public void setSouth(Node south) {
        this.South = south;
    }

    public Node getEast() {
        return East;
    }

    public void setEast(Node east) {
        this.East = east;
    }

    public Node getWest() {
        return West;
    }

    public void setWest(Node west) {
        this.West = west;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", North=" + North +
                ", South=" + South +
                ", East=" + East +
                ", West=" + West +
                '}';
    }
}
