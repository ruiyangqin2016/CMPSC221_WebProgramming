package Three_ShapeProblem;

public class test {
    public static void main(String[] args){
        Circle c = new Circle(4.0);
        Rectangle r = new Rectangle(4,3);
        ShowArea(c);
        ShowArea(r);
    }

    public static void ShowArea(Shape s){
        double area = s.area();
        System.out.println("The area of the shape is "+ area);
    }
}
