/* IMPORTANT: you will need GeometricObject found in the textbook 11.1.
   Please copy and past the code if you do not see the GeometricObject class.

   The following programming is checking weather if two circles have equal radius.
   In the Circle class, I have created a constructor that passes one parameter,
   which is to pass a radious in that parameter. Then it will check if the radius are equal.*/

public class Circle extends GeometricObject implements Comparable<Circle> {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(5.0);
            
        boolean areEqual = circle1.equals(circle2);
            
        if (areEqual) {
            System.out.println("Circle 1 and Circle 2 have an equal radii.");
        } 
        
        else {
            System.out.println("Circle 1 and Circle 2 do not have an equal radii.");
                
        }
    }
        
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public int compareTo(Circle circle) {
        
        if (this.radius > circle.radius) {
            return 1;
        } 
        
        else if (this.radius < circle.radius) {
            return -1;
        }
        
        else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof Circle)) {
            return false;
        }
        
        Circle otherCircle = (Circle) obj;
        return Double.compare(otherCircle.radius, radius) == 0;
    }

}