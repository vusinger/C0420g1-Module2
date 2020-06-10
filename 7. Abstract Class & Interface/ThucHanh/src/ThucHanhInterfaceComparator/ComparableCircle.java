package ThucHanhInterfaceComparator;

import ThucHanhComparator.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    private double radius;
    private String color;
    private boolean check;

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        this.radius = radius;
    }

    public ComparableCircle(double radius, String color, boolean check) {
        this.radius = radius;
        this.color = color;
        this.check = check;
    }

    public double getRadius() {
        return radius;
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

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}
