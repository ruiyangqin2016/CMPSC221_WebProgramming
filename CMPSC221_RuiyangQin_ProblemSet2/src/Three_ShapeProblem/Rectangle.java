package Three_ShapeProblem;

public class Rectangle implements Shape{

    private double length;
    private double width;

    public double getLength()
    {return length;}
    public double getWidth()
    {return width;}
    public void setLength(double length)
    {this.length = length;}
    public void setWidth(double width)
    {this.width = width;}

    public Rectangle(double length, double width){
        this.width = width;
        this.length = length;
    }

    @Override
    public double area(){
        return (width + length)*2;
    }
}
