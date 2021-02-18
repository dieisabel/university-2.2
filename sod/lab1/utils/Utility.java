package utils;

import java.util.Random;

public class Utility {

    private static int linearCounter;
    private static int binaryCounter;

    public static int[] generateArray(int size, int start, int end) {
        Random rnd = new Random(10000);
        return rnd.ints(size, start, end).toArray();
    }

    public static int range(int[] array, int start, int end) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= end && array[i] >= start) {
                counter++;
            }
        }
        return counter;
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            linearCounter++;
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int mid = 0;
        int high = array.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            binaryCounter++;
            if (array[mid] == key) return mid;
            binaryCounter++;
            if (array[mid] < key) {
                low = mid + 1;
            } else {
                binaryCounter++;
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    public static int getLinearCounter() {
        return linearCounter;
    }

    public static int getBinaryCounter() {
        return binaryCounter;
    }
}
