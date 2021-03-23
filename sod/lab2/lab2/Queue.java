package lab3;

import java.lang.Integer;

public class Queue<T> {
    private final int MAX_SIZE;
    private int size = 0;

    private Integer head = null;
    private Integer tail = null;

    private final T[] items;

    public Queue(int maxSize) {
        this.MAX_SIZE = maxSize;
        this.items = (T[]) new Object[this.MAX_SIZE];
    }

    public int getSize() {
        return size;
    }

    public int getMaxSize() {
        return MAX_SIZE;
    }

    public boolean offer(T value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = tail = 0;
            items[0] = value;
        } else {
            tail++;
            items[tail] = value;
        }
        size++;
        return true;
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T temp = items[head];
        tail--;
        size--;
        shift(items);
        return temp;
    }

    public T peek() {
        if (head != null) {
            return items[head];
        }
        return null;
    }

    public void display() {
        for (T element : items) {
            System.out.print(element + " <- ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    private void shift(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
    }
}
