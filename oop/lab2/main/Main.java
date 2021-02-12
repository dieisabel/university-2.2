package main;

import lab2.Customer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Laboratory work No. 2");
        Main main = new Main();
        main.run();
        System.out.println("END");
    }

    private void run() {
        Customer[] customers = fillArray();
        printByName(customers, "Edward");
        printInterval(customers, 50000, 100000);
        printDebtors(customers);
    }

    private void printByName(Customer[] customers, String name) {
        System.out.println("Name: " + name);
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                String message = generateMessage(customer);
                System.out.println(message);
            }
        }
    }

    private void printInterval(Customer[] customers, int start, int end) {
        System.out.println("Interval: " + start + "/" + end);
        for (Customer customer : customers) {
            int creditCardId = customer.getCreditCardId();
            if (creditCardId > start && creditCardId < end) {
                String message = generateMessage(customer);
                System.out.println(message);
            }
        }
    }

    private void printDebtors(Customer[] customers) {
        System.out.println("Debtors:");
        for (Customer customer : customers) {
            if (customer.getAccountBalance() < 0) {
                String message = generateMessage(customer);
                System.out.println(message);
            }
        }
    }

    private String generateMessage(Customer customer) {
        return customer.getId() + " " +
                customer.getSurname() + " " +
                customer.getName() + " " +
                customer.getPatronymic() + " " +
                customer.getAddress() + " " +
                customer.getCreditCardId() + " " +
                customer.getAccountBalance();
    }

    private Customer[] fillArray() {
        return new Customer[]{
                new Customer(1, "Smith",  "Edward","Rivera", "California, Riverside CA", 58303, 1954.90),
                new Customer(2, "Owens", "Matthew", "Sparks", "Lousiana, Baton Rouge", 38139, -13.45),
                new Customer(3, "Lopez", "Raymond", "Vincent", "California, Los Angeles", 13914, 876.10),
                new Customer(4, "Baker","Bruce" , "Johnson", "Idaho, Garfield", 57781, 25631.15),
                new Customer(5, "Jackson", "Ernest", "Hicks", "Washington, Tacoma", 98340, -789.89),
        };
    }
}
