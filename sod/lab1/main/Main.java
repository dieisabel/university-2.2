package main;

import utils.Utility;

public class Main {

    public static void main(String[] args) {
        System.out.println("Laboratory work No. 1");

        Main main = new Main();
        main.run();

        System.out.println("END");
    }

    private void run() {
        int N = 2;
        int[] array1 = Utility.generateArray(100000, 0, 100000 + N * 1000);
        int[] array2 = Utility.generateArray(200000, 0, 100000 + N * 1000);
        System.out.println("Solution 1: array\'s generated");
        solution2(array1, N, 2 * N);
        solution3(array1, 1000 + N);
        long sol4 = solution4(array1);
        solution5(array2, sol4);
        solution6(array1, 1000 + N);
    }

    private void solution2(int[] array, int start, int end) {
        int counter = Utility.range(array, start, end);
        System.out.println("Solution 2: counter = " + counter);
    }

    private void solution3(int[] array, int key) {
        int index = Utility.linearSearch(array, key);
        System.out.println("Solution 3: index = " + index);
    }

    private long solution4(int[] array) {
        long start = System.currentTimeMillis();
        Utility.bubbleSort(array);
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("Solution 4: diff = " + diff);
        return diff;
    }

    private void solution5(int[] array, long time) {
        long start = System.currentTimeMillis();
        Utility.bubbleSort(array);
        long end = System.currentTimeMillis();
        long diff = (end - start) - time;
        System.out.println("Solution 5: diff between sorting two arrays = " + diff);
    }

    private void solution6(int[] array, int key) {
        int index = Utility.binarySearch(array, key);
        System.out.println("Solution 6: index = " + index);
    }
}
