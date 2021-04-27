class Element<T> {
    public Element<T> next = null;
    public T data;

    public Element(T value) {
        data = value;
    }
}

public class QueueList<T> {
    private int size;
    private Element<T> head = null;
    private Element<T> tail = null;

    public void offer(T value) {
        Element<T> element = new Element<>(value);
        if (isEmpty()) {
            head = element;
        } else {
            tail.next = element;
        }
        tail = element;
        size++;
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public T peek() {
        if (head != null) {
            return head.data;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
