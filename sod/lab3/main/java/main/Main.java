package main;

import lab3.ListPriorityQueue;
import lab3.View;
import lab3.Queue;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Laboratory Work No.3");
        new Main().run();
        System.out.println("END");
    }

    private void run() {
        int m;
        Queue queue = new ListPriorityQueue();
        addRandomNumbers(queue);
        pollNumbers(queue);
        View view = new View();
        do {
            m = view.menu();
            switch (m) {
                case 1:
                    System.out.println("Enter value: ");
                    int value = view.getInt();
                    if (queue.offer(value)) {
                        System.out.println("Added " + value + " successfully");
                    } else {
                        System.out.println ("Error occured while adding " + value);
                    }
                    break;
                case 2:
                    Integer polled = queue.poll();
                    if (polled == null) {
                        System.out.println("Queue is empty");
                    } else {
                        System.out.println ("Poll " + polled);
                    }
                    break;
                case 3:
                    Integer peeked = queue.peek();
                    if (peeked == null) {
                        System.out.println("Queue is empty");
                    } else {
                        System.out.println("Peek " + peeked);
                    }
                    break;
            }
        } while (m != 0);
    }

    private void addRandomNumbers(Queue queue) {
        Random rnd = new Random();
        int[] array = rnd.ints(1000, -100000, 100000).toArray();
        long start = System.currentTimeMillis();
        for (int number : array) {
            queue.offer(number);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Added 1000 random numbers");
        System.out.println ("Time = " + (finish - start));
    }

    private void pollNumbers(Queue queue) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 15;i ++) {
            queue.poll();
        }
        long finish = System.currentTimeMillis();
        System.out.println ("Polled 15 numbers");
        System.out.println ("Time = " + (finish - start));
    }
}
