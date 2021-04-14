package main;

import logic.Customer;
import logic.Lab7Logic;
import logic.View;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        System.out.println("Laboratory Work No.7");
        new Main().run();
        System.out.println("END");
    }

    private void run() {
        Lab7Logic logic = new Lab7Logic();
        View view = new View();
        ArrayList<Customer> customers = createCustomersList();
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
                    String fileName = view.getFileName();
                    if (logic.writeToTextFile(fileName, customers)) {
                        System.out.println ("Writed to " + fileName);
                    }
                    break;
                case 10:
                    fileName = view.getFileName();
                    ArrayList<Customer> data = logic.readFromTextFile(fileName);
                    if (data != null) {
                        customers = data;
                        System.out.println("Loaded data from " + fileName);
                    }
                    break;
                case 11:
                    fileName = view.getFileName();
                    if (logic.writeToJsonFile(fileName, customers)) {
                        System.out.println ("Writed to " + fileName);
                    }
                    break;
                case 12:
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

    private ArrayList<Customer> createCustomersList() {
        return new ArrayList<Customer>();
    }
}
