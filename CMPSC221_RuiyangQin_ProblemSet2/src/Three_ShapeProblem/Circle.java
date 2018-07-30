package Three_ShapeProblem;

public class Circle implements Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius) {

        this.radius = radius;
    }

    @Override
    public double area(){
        return 3.1415926535*Math.pow(radius,2);
    }
}
