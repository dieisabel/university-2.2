package main;

import lab5.io.Lab5ArrayReader;
import lab5.logic.Lab5ArrayProcessor;

public class Main {
    public static void main(String[] args) {
        System.out.println("Laboratory Work No.5");

        Main main = new Main();
        main.run();

        System.out.println("END");
    }

    private void run() {
        Lab5ArrayReader reader = new Lab5ArrayReader();
        double[] oneDimensionalArray = reader.readOneDimensionalArray("lab51.txt");
        double[][] twoDimensionalArray = reader.readTwoDimensionalArray("lab52.txt");

        solution1(oneDimensionalArray);
        solution2(twoDimensionalArray);
    }

    private void solution1(double[] array) {
        Lab5ArrayProcessor processor = new Lab5ArrayProcessor();
        processor.processArray(array);
    }

    private void solution2(double[][] array) {
        Lab5ArrayProcessor processor = new Lab5ArrayProcessor();
        processor.processArray(array);
    }
}
