
import java.util.Scanner;

public class Triangle extends GeometricObject {
    double side1 = 1.0;
    double side2 = 1.0;
    double side3 = 1.0;
    
    Triangle() {
        
    }

    public Triangle(double s1, double s2, double s3) {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String toString() {
        return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter three sides of the triangle, a color, and a true/false indicate whether the triangle is filled.");

        System.out.print("Enter for the side1: ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter for the side2: ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter for the side3: ");
        double side3 = scanner.nextDouble();

        System.out.print("Enter a color: ");
        String color = scanner.next();

        System.out.print("Is your triangle filled or not? You must enter true/false: ");
        boolean filled = scanner.nextBoolean();

        
        Triangle triangle = new Triangle(side1, side2, side3);
        
        triangle.setColor(color);
        
        triangle.setFilled(filled);

        
        System.out.println("Triangle:");
        
        System.out.println(triangle.toString());
        
        System.out.println("Area: " + triangle.getArea());
        
        System.out.println("Perimeter: " + triangle.getPerimeter());
        
        System.out.println("Color: " + triangle.getColor());
        
        System.out.println("Filled: " + triangle.isFilled());

        scanner.close();
    }
}
