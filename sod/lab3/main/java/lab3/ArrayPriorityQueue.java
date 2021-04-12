package lab3;

public class ArrayPriorityQueue implements Queue {
    private Integer head = 0;
    private Integer tail = 0;

    public int MAX_SIZE;
    public int size = 0;

    private final Integer[] items;

    public ArrayPriorityQueue(int maxSize) {
        this.MAX_SIZE = maxSize;
        this.items = new Integer[maxSize];
    }

    public boolean offer(Integer value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            items[0] = value;
            size++;
            return true;
        } else {
            int n = head;
            Integer temp = items[n];
            if (value > 0) {
                for (int i = n; i <= tail; i++) {
                    if (value > temp & temp > 0) {
                        temp = items[i];
                        n = i;
                    }
                }
                shiftToRight(items, n + 1);
                items[n + 1] = value;
                if (temp > value || temp <= 0) {
                    items[n + 1] = temp;
                    items[n] = value;
                }
            } else {
                for (int i = n; i <= tail; i++) {
                    if (value < temp) {
                        temp = items[i];
                        n = i;
                    }
                }
                shiftToRight(items, n + 1);
                items[n + 1] = value;
                if (temp < value) {
                    items[n + 1] = temp;
                    items[n] = value;
                }
            }
        }
        tail++;
        size++;
        return true;
    }

    public Integer poll() {
        if (isEmpty()) {
            return null;
        }
        Integer temp = items[head];
        shiftToLeft(items);
        size--;
        tail--;
        return temp;
    }

    public Integer peek() {
        if (head == null) {
            return null;
        } else {
            return items[head];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public int getSize() {
        return size;
    }

    private void shiftToRight(Integer[] array, int position) {
        for (int i = tail; i >= position; i--) {
            array[i + 1] = array[i];
        }
    }

    private void shiftToLeft(Integer[] array) {
        for (int i = 0; i < tail; i++) {
            array[i] = array[i + 1];
        }
    }
}
