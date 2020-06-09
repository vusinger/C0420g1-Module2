package LopPointVaMoveablePoint;

public class Points {
    private float x = 0.0f;
    private float y = 0.0f;

    public Points() {
    }

    public Points(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float[] arr = {x,y};
        return arr;
    }

    public void setXY(float x,float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + x +" y= " + y ;
    }

    public static void main(String[] args) {
        Points obj = new Points(1,1);
        System.out.println(obj.toString());
    }
}
