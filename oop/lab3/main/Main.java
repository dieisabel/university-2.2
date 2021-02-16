package main;

import java.util.Scanner;

import lab3.Lab3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Laboratory work No.3");

        Main main = new Main();
        main.run();

        System.out.println("END");
    }

    private void run() {
        Lab3 lab3 = new Lab3();
        String string = getLine();
        int[] nums = lab3.convert(string);
        print(string);
        print(nums);
    }

    private String getLine() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        return string;
    }

    private void print(String string) {
        String trimmed = string.trim();
        for (int i = 0; i < trimmed.length(); i++) {
            System.out.printf("%3c", string.charAt(i));
        }
        System.out.println("");
    }

    private void print(int[] nums) {
        for (int number : nums) {
            System.out.printf("%3d", number);
        }
        System.out.println("");
    }
}
