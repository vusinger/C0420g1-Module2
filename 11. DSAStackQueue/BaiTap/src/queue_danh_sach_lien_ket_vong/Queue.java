package queue_danh_sach_lien_ket_vong;

public class Queue<E> {
    private Node front;
    private Node rear;

    private class Node {
        private int data;
        private Node link;

        public Node(int data) {
            this.data = data;
        }
    }

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enQueue(int value) {
        Node temp = new Node(value);
        if (this.front ==  null)
            this.front = temp;
        else {
            this.rear.link = temp;
        }
        this.rear = temp;
        this.rear.link = this.front;
    }

    public int deQueue() {
        if (this.front==null) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int value;
        if (this.front==this.rear) {
            value = this.front.data;
            this.front = null;
            this.rear = null;
        } else {
            Node temp = this.front;
            value = temp.data;
            this.front = this.front.link;
            this.rear.link = this.front;
        }
        return value;
    }

    public void displayQueue() {
        Node temp = this.front;
        System.out.print("Elements in Circular Queue are: ");
        while (temp.link != this.front) {
            System.out.print(temp.data+" ");
            temp = temp.link;
        }
        System.out.print(temp.data+" ");
        System.out.println();
    }
}
