package queue_danh_sach_lien_ket_vong;

public class Solution {
    public static void main(String[] args) {
        // Create a queue and initialize front and rear
        Queue  q = new Queue();
        // Inserting elements in Circular Queue
        q.enQueue(14);
        q.enQueue(22);
        q.enQueue(4);
        q.enQueue(5);
        q.enQueue(6);
        q.enQueue(7);
        q.enQueue(8);

        // Display elements present in Circular Queue
        q.displayQueue();

        // Deleting elements from Circular Queue
        System.out.println("Deleted value = " + q.deQueue());
        System.out.println("Deleted value = " + q.deQueue());

        // Remaining elements in Circular Queue
        q.displayQueue();

        q.enQueue(9);
        q.enQueue(20);
        q.displayQueue();
    }
}
