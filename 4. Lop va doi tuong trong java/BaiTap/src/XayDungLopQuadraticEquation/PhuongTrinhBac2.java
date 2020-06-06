package XayDungLopQuadraticEquation;

import java.util.Scanner;

public class PhuongTrinhBac2 {
    public class QuadraticEquation {
        private double a,b,c;

        public double getA() {
            return a;
        }

        public double getB() {
            return b;
        }

        public double getC() {
            return c;
        }

        public void setA(double a) {
            this.a = a;
        }

        public void setB(double b) {
            this.b = b;
        }

        public void setC(double c) {
            this.c = c;
        }

        double getDiscriminant() {
            return b*b - 4*a*c;
        }
        double getRoot1() {
            return (-b+Math.sqrt(this.getDiscriminant()))/(2*a);
        }
        double getRoot2() {
            return (-b-Math.sqrt(this.getDiscriminant()))/(2*a);
        }
    }
    void main1(double a, double b,double c) {
        QuadraticEquation obj = new QuadraticEquation();
        obj.setA(a);
        obj.setB(b);
        obj.setC(c);
        double delta = obj.getDiscriminant();
        if (delta>0) {
            System.out.println("Nghiem thu 1:"+obj.getRoot1());
            System.out.println("Nghiem thu 2:"+obj.getRoot2());
        } else if (delta == 0) {
            System.out.println("Nghiem duy nhat:"+obj.getRoot1());
        } else if (delta <0) {
            System.out.println("Phuong trinh vo nghiem!!");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a:");
        double a = sc.nextDouble();
        System.out.print("Nhap b:");
        double b = sc.nextDouble();
        System.out.print("Nhap c:");
        double c = sc.nextDouble();
        PhuongTrinhBac2 ptb2 = new PhuongTrinhBac2();
        ptb2.main1(a,b,c);
    }
}
