package main;

import io.Lab5Reader;
import logic.Lab5Processor;

public class Main {
    public static void main(String[] args) {
        System.out.println("Laboratory Work No.5");

        Main main = new Main();
        main.run();

        System.out.println("END");
    }

    private void run() {
        Lab5Reader reader = new Lab5Reader();
        double[] oneDimensionalArray = reader.readOneDimensionalArray("lab51.txt");
        double[][] twoDimensionalArray = reader.readTwoDimensionalArray("lab52.txt");

        solution1(oneDimensionalArray);
        solution2(twoDimensionalArray);
    }

    private void solution1(double[] array) {
        Lab5Processor processor = new Lab5Processor();
        double product = processor.process(array);
        System.out.println("Solution 1: product = " + product);
    }

    private void solution2(double[][] array) {
        Lab5Processor processor = new Lab5Processor();
        double max = processor.process(array);
        System.out.println("Solution 2: max = " + max);
    }
}
