package main;

import logic.Customer;
import logic.Lab8Logic;
import logic.View;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        System.out.println("Laboratory Work No.8");
        new Main().run();
        System.out.println("END");
    }

    private void run() {
        Lab8Logic logic = new Lab8Logic();
        View view = new View();
        List<Customer> customers = createCustomerList();
        int m;
        do {
            m = view.menu();
            switch (m) {
                case 1:
                    if (logic.addToList(customers, view.createCustomer())) {
                        System.out.println ("Added successfully!");
                    } else {
                        System.out.println ("Array if full!");
                    }
                    break;
                case 2:
                    if (logic.removeFromList(customers)) {
                        System.out.println("Removed!");
                    } else {
                        System.out.println("Array is empty!");
                    }
                    break;
                case 3:
                    Customer customer = view.createCustomer();
                    if (logic.removeCustomerFromList(customers, customer)) {
                        System.out.println("Successfully removed!");
                    } else {
                        System.out.println("Customer not in list");
                    }
                    break;
                case 4:
                    view.show(customers);
                    break;
                case 5:
                    System.out.println("Enter name: ");
                    String name = view.getString();
                    view.show(logic.filterByName(customers, name));
                    break;
                case 6:
                    int[] interval = view.getInterval();
                    view.show(logic.filterByInterval(customers, interval[0], interval[1]));
                    break;
                case 7:
                    view.show(logic.filterDebtors(customers));
                    break;
                case 8:
                    view.show(logic.sortByBalance(customers));
                    break;
                case 9:
                    view.show(logic.distinctByBirthday(customers));
                    break;
                case 10:
                    view.show(logic.getMostRichCustomerForEachBirthday(customers));
                    break;
                case 11:
                    String fileName = view.getFileName();
                    if (logic.writeToTextFile(fileName, customers)) {
                        System.out.println ("Writed to " + fileName);
                    }
                    break;
                case 12:
                    fileName = view.getFileName();
                    List<Customer> data = logic.readFromTextFile(fileName);
                    if (data != null) {
                        customers = data;
                        System.out.println("Loaded data from " + fileName);
                    }
                    break;
                case 13:
                    fileName = view.getFileName();
                    if (logic.writeToJsonFile(fileName, customers)) {
                        System.out.println ("Writed to " + fileName);
                    }
                    break;
                case 14:
                    fileName = view.getFileName();
                    data = logic.readFromJsonFile(fileName);
                    if (data != null) {
                        customers = data;
                        System.out.println("Loaded data from " + fileName);
                    }
                    break;
            }
            System.out.println("---------------------------");
        } while (m != 0);
    }

    private <T> List<T> createCustomerList() {
        return new ArrayList<>(100);
    }
}
