package lab3;

class Element {
    public Integer value;
    public Element next = null;

    public Element(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Element{" +
                "value="  + value +
                ", next=" + next.value +
                '}';
    }
}

public class PriorityQueue {
    private Element head;
    private Element tail;

    private int size = 0;

    public void offer (int value) {
        if (isEmpty ()) {
            head = new Element(value);
        }
        Element element = new Element (value);
        if (head.value < 0 & element.value > 0) {
            int tmp = element.value;
            element.value = head.value;
            head.value = tmp;
        } else {
            Element temp = head;
            while ((element.value > 0 & element.value > temp.value) || (element.value < 0 & element.value < temp.value)) {
                if (temp.next != null) {
                    temp = temp.next;
                } else {
                    break;
                }
            }
            element.next = temp.next;
            temp.next = element;
            if ((temp.value > element.value & element.value > 0) || (temp.value < element.value & element.value < 0)) {
                int tmp = element.value;
                element.value = temp.value;
                temp.value = tmp;
            }
        }
        tail = element;
        size++;
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

    public void display() {
        Element temp = head;
        while (temp != null) {
            System.out.print(temp.value + " <- ");
            temp = temp.next;
        }
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return head.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

