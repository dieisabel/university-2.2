package lab3;

class Element {
    public Integer value;
    public Element next = null;

    public Element(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        Integer temp;
        if (next != null) {
            temp = next.value;
        } else {
            temp = null;
        }
        return "Element{" +
                "value="  + value +
                ", next=" + temp +
                '}';
    }
}

public class ListPriorityQueue implements Queue {
    private Element head;
    private Element tail;

    private int size = 0;

    public boolean offer (Integer value) {
        Element element = new Element(value);
        if (isEmpty ()) {
            head = element;
        } else {
            Element temp = head;
            if (element.value > 0) {
                while (element.value > temp.value & temp.value > 0) {
                    if (temp.next != null) {
                        temp = temp.next;
                    } else {
                        break;
                    }
                }
                element.next = temp.next;
                temp.next = element;
                if (temp.value > element.value || temp.value <= 0) {
                    int tmp = element.value;
                    element.value = temp.value;
                    temp.value = tmp;
                }
            } else {
                while (element.value < temp.value) {
                    if (temp.next != null) {
                        temp = temp.next;
                    } else {
                        break;
                    }
                }
                element.next = temp.next;
                temp.next = element;
                if (temp.value < element.value) {
                    int tmp = element.value;
                    element.value = temp.value;
                    temp.value = tmp;
                }
            }
        }
        tail = element;
        size++;
        return true;
    }

    public Integer poll() {
        if (isEmpty()) {
            return null;
        }
        int temp = head.value;
        head = head.next;
        size--;
        return temp;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return head.value;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
