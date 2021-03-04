package io;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lab5Reader implements Reader {
    @Override
    public double[] readOneDimensionalArray(File file) {
        try (Scanner in = new Scanner(file)) {
            int size = in.nextInt();
            double[] array = new double[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = in.nextDouble();
            }
            return array;
        } catch (IOException ex) {
            System.err.println("Error reading file");
            return null;
        }
    }

    @Override
    public double[] readOneDimensionalArray(String fileName) {
        try (Scanner in = new Scanner(new File(fileName))) {
            int size = in.nextInt();
            double[] array = new double[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = in.nextDouble();
            }
            return array;
        } catch (IOException ex) {
            System.err.println("Error reading file");
            return null;
        }
    }

    @Override
    public double[][] readTwoDimensionalArray(File file) {
        try (Scanner in = new Scanner(file)) {
            int size = in.nextInt();
            double[][] array = new double[size][size];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = in.nextDouble();
                }
            }
            return array;
        } catch (IOException ex) {
            System.err.println("Error reading file");
            return null;
        }
    }

    @Override
    public double[][] readTwoDimensionalArray(String fileName) {
        try (Scanner in = new Scanner(new File(fileName))) {
            int size = in.nextInt();
            double[][] array = new double[size][size];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = in.nextDouble();
                }
            }
            return array;
        } catch (IOException ex) {
            System.err.println("Error reading file");
            return null;
        }
    }
}
