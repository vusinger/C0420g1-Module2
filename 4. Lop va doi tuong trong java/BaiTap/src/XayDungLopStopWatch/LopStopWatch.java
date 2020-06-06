package XayDungLopStopWatch;

import java.util.Arrays;

public class LopStopWatch {
    public static class StopWatch {
        private double startTime, endTime;

        public double getStartTime() {
            return startTime;
        }

        public void setStartTime(double startTime) {
            this.startTime = startTime;
        }

        public double getEndTime() {
            return endTime;
        }

        public void setEndTime(double endTime) {
            this.endTime = endTime;
        }

        public StopWatch() {
            this.startTime = System.currentTimeMillis();
        }

        void start() {
            this.startTime = System.currentTimeMillis();
        }

        void stop() {
            this.endTime = System.currentTimeMillis();
        }

        double getElapsedTime() {
            return (this.endTime - this.startTime)/1000;
        }
    }

    public static void sapxep() {
        double[] array = new double[100000000];
        for (int i = 0; i < 100000000; i++) {
            double random = Math.random() * 10000;
            array[i] = Math.round(random);
        }
        Arrays.sort(array);
    }

    public static void main(String[] args) {
        StopWatch stw = new StopWatch();
        stw.start();
        sapxep();
        stw.stop();
        System.out.println("Thoi gian thuc hien sort:"+stw.getElapsedTime()+"s");
    }
}
