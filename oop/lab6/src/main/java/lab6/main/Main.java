package lab6.main;

import lab6.logic.Customer;
import lab6.logic.Lab6Logic;
import lab6.logic.View;

public class Main {
    public static void main (String[] args) {
        System.out.println ("Laboratory Work No.6");
        new Main().run();
        System.out.println ("END");
    }

    private void run() {
        Lab6Logic logic = new Lab6Logic();
        View view = new View();
        Customer[] customers = createCustomersArray(view.getArraySize());
        int m;
        do {
            m = view.menu();
            switch (m) {
                case 1:
                    if (logic.addToArray(customers, view.createCustomer())) {
                        System.out.println ("Added successfully!");
                    } else {
                        System.out.println ("Array if full!");
                    }
                    break;
                case 2:
                    if (logic.removeFromArray(customers)) {
                        System.out.println("Removed!");
                    } else {
                        System.out.println("Array is empty!");
                    }
                    break;
                case 3:
                    view.show(customers);
                    break;
                case 4:
                    System.out.println("Enter name: ");
                    String name = view.getString();
                    view.show(logic.filterByName(customers, name));
                    break;
                case 5:
                    int[] interval = view.getInterval();
                    view.show(logic.filterByInterval(customers, interval[0], interval[1]));
                    break;
                case 6:
                    view.show(logic.filterDebtors(customers));
                    break;
                case 7:
                    view.show(logic.sortByBalance(customers));
                    break;
                case 8:
                    String fileName = view.getFileName();
                    if (logic.writeToTextFile(fileName, customers)) {
                        System.out.println ("Writed to " + fileName);
                    }
                    break;
                case 9:
                    fileName = view.getFileName();
                    Customer[] data = logic.readFromTextFile(fileName);
                    if (data != null) {
                        customers = data;
                        System.out.println("Loaded data from " + fileName);
                    }
                    break;
                case 10:
                    fileName = view.getFileName();
                    if (logic.writeToBinaryFile(fileName, customers)) {
                        System.out.println ("Writed to " + fileName);
                    }
                    break;
                case 11:
                    fileName = view.getFileName();
                    data = logic.readFromBinaryFile(fileName);
                    if (data != null) {
                        customers = data;
                        System.out.println("Loaded data from " + fileName);
                    }
                    break;
            }
            System.out.println("---------------------------");
        } while (m != 0);
    }

    private Customer[] createCustomersArray(int amount) {
        if (amount < 0 || amount > 100) {
            System.out.println ("Customers amount cannot be less than 0 or bigger than 100");
            System.exit(-1);
        }
        return new Customer[amount];
    }
}
