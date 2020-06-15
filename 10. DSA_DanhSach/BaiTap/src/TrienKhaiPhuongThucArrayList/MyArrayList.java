package TrienKhaiPhuongThucArrayList;

import java.util.Arrays;

public class MyArrayList<E> {
    /**
     * So lượng phần tử có trong arraylist
     */

    private int size = 0;

    /**
     * Sức chứa của ArrayList
     */

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Mảng chứa các phần tử
     */
    Object[] elements;

    /**
     * Sức chứa mặc định khi khởi tạo bằng constuctor không có tham số
     */
    public MyArrayList() {
        elements =  new Object[DEFAULT_CAPACITY];
    }

    /**
     * Phương thức Constructor với sức chứa truyền vào
     */

    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            elements =  new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity = "+capacity);
        }
    }

    /**
     * Phương thức trả về số lượng phần tử
     */

    public int size() {
        return this.size;
    }

    /**
     * Phương thức clear 1 array list
     */

    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    /**
     * Phương thức add 1 phần tử vào arraylist
     */

    public boolean add(E element) {
        if (elements.length == size) {
            ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }

    public void add(E element,int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index = "+index);
        } else if (index == elements.length) {
            this.ensureCapacity(5);
        }
        if (size>=elements.length) {
            ensureCapacity(5);
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size+1; i >= index ; i--) {
                elements[i] = elements[i-1];
            }
            elements[index] = element;
            size++;
        }
    }

    /**
     * Phương thức tăng kích thước của my array list
     */

    private void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements,newSize);
        } else {
            throw new IllegalArgumentException("minCapacity = "+minCapacity);
        }
    }
    /**
     * Phương thức lấy 1 elements tại vị trí index
     */

    public E get(int index) {
        return (E) elements[index];
    }

    /**
     * Phương thức lấy index của một phần tử trong mảng
     */

    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }

    /**
     * Phương thức kiểm tra phần tử có trong Array List hay không
     */

    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    /**
     * Clone một Array List
     */

    public MyArrayList<E> clone() {
        MyArrayList<E> obj = new MyArrayList<>();
        obj.elements = Arrays.copyOf(this.elements,this.size);
        obj.size = this.size;
        return obj;
    }

    /**
     * Remove index trong ArrayList
     */

    public E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("index = " +index);
        }
        E element = (E) elements[index];
        for (int i = index; i < size-1; i++) {
            this.elements[i] = this.elements[i+1];
        }
        this.elements[size-1] = null;
        size--;
        return element;
    }
}
