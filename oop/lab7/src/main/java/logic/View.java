package logic;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    public int menu() {
        showMenu();
        return getMenuChoice();
    }

    public void show(ArrayList<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public String getFileName() {
        System.out.println("Enter file name: ");
        return getString();
    }

    public String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int[] getInterval() {
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Enter interval start: ");
        int start = scanner.nextInt();
        System.out.println ("Enter interval end: ");
        int end = scanner.nextInt();
        return new int[] {start, end};
    }

    public Customer createCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer information in order: " +
                "id surname name patronymic address creditCardId accountBalance");
        String[] s = scanner.nextLine().split(" ");
        int id = Integer.parseInt(s[0]);
        String surname = s[1];
        String name = s[2];
        String patronymic = s[3];
        String address = s[4];
        int creditCardId = Integer.parseInt(s[5]);
        double accountBalance = Double.parseDouble(s[6]);
        return new Customer(id, surname, name, patronymic, address, creditCardId, accountBalance);
    }

    private void showMenu() {
        System.out.println("1. Add customer");
        System.out.println("2. Remove customer");
        System.out.println("3. Remove certain customer");
        System.out.println("4. Show");
        System.out.println("5. Print by name");
        System.out.println("6. Print by interval");
        System.out.println("7. Print debtors");
        System.out.println("8. Print by balance");
        System.out.println("9. Save to text file");
        System.out.println("10. Load from text file");
        System.out.println("11. Save to JSON");
        System.out.println("12. Load from JSON");
        System.out.println("0. Exit");
    }

    private int getMenuChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter");
        return scanner.nextInt();
    }
}
