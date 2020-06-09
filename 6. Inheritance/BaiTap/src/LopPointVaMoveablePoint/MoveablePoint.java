package LopPointVaMoveablePoint;

import java.awt.Point;

public class MoveablePoint extends Points {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint() {
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(int x, int y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed() {
        float[] arr = {xSpeed,ySpeed};
        return arr;
    }


    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public void move() {
        super.setXY(super.getX()+this.xSpeed,super.getY()+this.ySpeed);

    }
    @Override
    public String toString() {
        return super.toString()+" xSpeed = " + xSpeed +" ySpeed = " + ySpeed ;
    }

    public static void main(String[] args) {
        Points obj = new MoveablePoint(1,1,10,10);
        ((MoveablePoint)obj).move();
        System.out.println(obj.toString());
    }
}
