package main;

import lab5.HashTable;

import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Laboratory Work No.5");
        new Main().run();
        System.out.println("END");
    }

    private void run() {
        Random rnd = new Random(1000);
        HashTable table = new HashTable();
        HashSet<Integer> set = new HashSet<>();
        int searchItem = rnd.nextInt();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            set.add(rnd.nextInt(10000));
        }
        long end = System.currentTimeMillis();
        System.out.println("Java hash set: " + (end - start));
        start = System.currentTimeMillis();
        set.contains(searchItem);
        end = System.currentTimeMillis();
        System.out.println("Searching in java set: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            table.add(rnd.nextInt(10000));
        }
        end = System.currentTimeMillis();
        System.out.println("Table: " + (end - start));
        start = System.currentTimeMillis();
        table.contains(searchItem);
        end = System.currentTimeMillis();
        System.out.println("Searching in table: " + (end - start));
    }
}
