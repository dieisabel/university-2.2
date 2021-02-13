package utils;

import java.util.Random;

public class Utility {

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
        while (true) {
            if (low > high) break;
            mid = (low + high) / 2;
            if (array[mid] == key) return mid;
            else if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
