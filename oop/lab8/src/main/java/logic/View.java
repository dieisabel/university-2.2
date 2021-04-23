package logic;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;

public class View {
    public int menu() {
        showMenu();
        return getMenuChoice();
    }

    public <T> void show(Collection<T> objects) {
        for (T object : objects) {
            System.out.println(object);
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
                "id surname name patronymic birthday address creditCardId accountBalance");
        String[] s = scanner.nextLine().split(" ");
        int id = Integer.parseInt(s[0]);
        String surname = s[1];
        String name = s[2];
        String patronymic = s[3];
        LocalDate birthday = LocalDate.parse(s[4]);
        String address = s[5];
        int creditCardId = Integer.parseInt(s[6]);
        double accountBalance = Double.parseDouble(s[7]);
        return new Customer(id, surname, name, patronymic, birthday, address, creditCardId, accountBalance);
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
        System.out.println("9. Distinct by birthday");
        System.out.println("10. Get most rich customer for each birthday");
        System.out.println("11. Save to text file");
        System.out.println("12. Load from text file");
        System.out.println("13. Save to JSON");
        System.out.println("14. Load from JSON");
        System.out.println("0. Exit");
    }

    private int getMenuChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter");
        return scanner.nextInt();
    }
}
