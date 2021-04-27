package main;

import lab2.Queue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Laboratory Work No.2");

        Main main = new Main();
        main.run();

        System.out.println("END");
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int size = getSize(scanner);
        Queue<Integer> queue = new Queue<>(size);
        int choice;
        do {
            choice = menu();
            switch (choice) {
                case 1:
                    queueOffer(queue, scanner);
                    break;
                case 2:
                    queuePoll(queue);
                    break;
                case 3:
                    System.out.println("Value: " + queue.peek());
                    break;
                case 4:
                    System.out.println("Size: " + queue.getSize());
                    break;
                case 5:
                    queueIsEmpty(queue);
                    break;
                case 6:
                    queueIsFull(queue);
                case 7:
                    queue.display();
                    break;
            }
        } while (choice != 0);
        System.out.println();
    }

    private int menu() {
        System.out.println("-------------");
        System.out.println("1. Offer");
        System.out.println("2. Poll");
        System.out.println("3. Peek");
        System.out.println("4. Size");
        System.out.println("5. Is empty");
        System.out.println("6. Is full");
        System.out.println("7. Display");
        System.out.println("0. Exit");
        System.out.println("-------------");
        System.out.println("Choose: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private int getSize(Scanner scanner) {
        System.out.println("Enter queue max size: ");
        int size = scanner.nextInt();
        if (size == 0) {
            System.out.println("Queue size cannot be 0");
            System.exit(-1);
        }
        return size;
    }

    private void queueOffer(Queue<Integer> queue, Scanner scanner) {
        System.out.println("Enter value: ");
        int value = scanner.nextInt();
        if (queue.offer(value)) {
            System.out.println("Value added successfully!");
        } else {
            System.out.println("Queue is full");
        }
    }

    private void queueIsFull(Queue<Integer> queue) {
        if (queue.isFull()) {
            System.out.println("Queue is full");
        } else {
            System.out.println("Queue not full");
        }
    }

    private void queueIsEmpty(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue not empty");
        }
    }

    private void queuePoll(Queue<Integer> queue) {
        Integer elem = queue.poll();
        if (elem != null) {
            System.out.println("Deleted element " + elem + " successfully!");
        } else {
            System.out.println("Queue is empty");
        }
    }
}
