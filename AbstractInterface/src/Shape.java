abstract class Shape1 {
    abstract double getArea();
}
class Circle extends Shape1{

    private double radious;

    public Circle(double radious) {
        this.radious = radious;
    }

    @Override
    public double getArea() {
        return Math.PI*radious*radious;
    }
}
class Trangle extends Shape1{
    private double length;
    private double breadth;

    public Trangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    double getArea() {
        return (0.5*length*breadth);
    }
}
 class MainClass{
    public static void main(String[] args) {

        Circle a1= new Circle(10);
        Trangle a2=new Trangle(10,10);
        System.out.println("Circle Area is: "+a1.getArea());
        System.out.println("Area of Trangle is: "+a2.getArea());
    }
}