package Point2DPoint3D;

public class Point3D extends Point2D{
    private float Z = 0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.Z = z;
    }

    public float getZ() {
        return Z;
    }

    public void setZ(float z) {
        this.Z = z;
    }

    public float[] getXYZ() {
        float[] arr = {super.getX(),super.getY(),this.Z};
        return arr;
    }

    public void setXYZ(float x,float y,float z) {
        super.setX(x);
        super.setX(y);
        setZ(z);
    }

    @Override
    public String toString() {
        return  super.toString()+", Z=" + Z ;
    }

    public static void main(String[] args) {
        Point2D obj = new Point3D(10,20,30);
        System.out.println(obj.toString());
    }
}
