package lab3;

import java.util.Scanner;

public class View {
    public int menu() {
        showMenu();
        return getChoice();
    }

    public int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void showMenu() {
        System.out.println("1. Offer");
        System.out.println("2. Poll");
        System.out.println("3. Peek");
        System.out.println("0. Exit");
    }

    private int getChoice() {
        Scanner scanner = new Scanner (System.in);
        return scanner.nextInt();
    }
}
