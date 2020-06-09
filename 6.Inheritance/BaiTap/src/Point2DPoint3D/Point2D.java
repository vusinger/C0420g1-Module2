package Point2DPoint3D;

public class Point2D {
    private float X = 0.0f;
    private float Y = 0.0f;

    public float getX() {
        return X;
    }

    public void setX(float x) {
        X = x;
    }

    public float getY() {
        return Y;
    }

    public void setY(float y) {
        Y = y;
    }

    public float[] getXY() {
        float[] arr = {X,Y};
        return arr;
    }

    public void setXY(float x,float y) {
        X = x;
        Y = y;
    }

    public Point2D() {
    }

    public Point2D(float x, float y) {
        X = x;
        Y = y;
    }

    @Override
    public String toString() {
        return  "X=" + X + ", Y=" + Y ;
    }
}
