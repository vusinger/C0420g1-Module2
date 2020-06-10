package ThucHanhComparator;

public class Circle {
    private double radius;
    private String color;
    private boolean check;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean check) {
        this.radius = radius;
        this.color = color;
        this.check = check;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public double getRadius() {
        return radius;
    }
}
