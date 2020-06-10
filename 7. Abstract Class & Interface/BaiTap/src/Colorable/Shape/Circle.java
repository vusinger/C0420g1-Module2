package Colorable.Shape;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getsize() {
        return this.radius*this.radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle Size :"+this.getsize();
    }
}
