package logic;

import io.TextIO;
import io.IO;
import io.JsonIO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Lab7Logic {
    public ArrayList<Customer> readFromTextFile(String fileName) {
        IO<Customer> in = new TextIO();
        return in.read(fileName);
    }

    public ArrayList<Customer> readFromJsonFile(String fileName) {
        IO<Customer> in = new JsonIO();
        return in.read(fileName);
    }

    public boolean writeToTextFile(String fileName, ArrayList<Customer> customers) {
        IO<Customer> out = new TextIO();
        return out.write(fileName, customers);
    }

    public boolean writeToJsonFile(String fileName, ArrayList<Customer> customers) {
        IO<Customer> out = new JsonIO();
        return out.write(fileName, customers);
    }

    public boolean addToList(ArrayList<Customer> customers, Customer customer) {
        customers.add(customer);
        return true;
    }

    public boolean removeFromList(ArrayList<Customer> customers) {
        if (customers.size() == 0) {
            return false;
        }
        customers.remove(customers.size() - 1);
        return true;
    }

    public boolean removeCustomerFromList(ArrayList<Customer> customers, Customer customer) {
        int index = findCustomer(customers, customer);
        if (index == -1) {
            return false;
        } else {
            customers.remove(index);
            return true;
        }
    }

    public ArrayList<Customer> filterByName(ArrayList<Customer> customers, String name) {
        return customers.stream()
                .filter(x -> x.getName().equals(name))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Customer> filterByInterval(ArrayList<Customer> customers, int start, int end) {
        return customers.stream()
                .filter(x -> x.getCreditCardId() > start && x.getCreditCardId() < end)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Customer> filterDebtors(ArrayList<Customer> customers) {
        return customers.stream()
                .filter(x -> x.getAccountBalance() < 0)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Customer> sortByBalance(ArrayList<Customer> customers) {
        return customers.stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private int findCustomer(ArrayList<Customer> customers, Customer customer) {
        return customers.indexOf(customer);
    }
}
