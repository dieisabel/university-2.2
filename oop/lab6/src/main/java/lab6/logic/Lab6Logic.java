package lab6.logic;

import lab6.io.TextIO;
import lab6.io.IO;
import lab6.io.ObjectIO;

import java.util.Collections;
import java.util.Objects;
import java.util.stream.Stream;

public class Lab6Logic {
    public Customer[] readFromTextFile(String fileName) {
        IO<Customer> in = new TextIO();
        return in.read(fileName);
    }

    public Customer[] readFromBinaryFile(String fileName) {
        IO<Customer> in = new ObjectIO();
        return in.read(fileName);
    }

    public boolean writeToTextFile(String fileName, Customer[] customers) {
        IO<Customer> out = new TextIO();
        return out.write(fileName, customers);
    }

    public boolean writeToBinaryFile(String fileName, Customer[] customers) {
        IO<Customer> out = new ObjectIO();
        return out.write(fileName, customers);
    }

    public boolean addToArray(Customer[] customers, Customer customer) {
        int end = findEnd(customers);
        if (end < 0) {
            return false;
        }
        customers[end] = customer;
        return true;
    }

    public boolean removeFromArray(Customer[] customers) {
        int end = findEnd(customers);
        if (end == 0) {
            return false;
        }
        if (end < 0) {
            customers[customers.length - 1] = null;
        } else {
            customers[end - 1] = null;
        }
        return true;
    }

    public Customer[] filterByName(Customer[] customers, String name) {
        return Stream.of(customers)
                .filter(Objects::nonNull)
                .filter(x -> x.getName().equals(name))
                .toArray(Customer[]::new);
    }

    public Customer[] filterByInterval(Customer[] customers, int start, int end) {
        return Stream.of(customers)
                .filter(Objects::nonNull)
                .filter(x -> x.getCreditCardId() > start && x.getCreditCardId() < end)
                .toArray(Customer[]::new);
    }

    public Customer[] filterDebtors(Customer[] customers) {
        return Stream.of(customers)
                .filter(Objects::nonNull)
                .filter(x -> x.getAccountBalance() < 0)
                .sorted(Collections.reverseOrder())
                .toArray(Customer[]::new);
    }

    public Customer[] sortByBalance(Customer[] customers) {
        return Stream.of(customers)
                .filter(Objects::nonNull)
                .sorted()
                .toArray(Customer[]::new);
    }

    private int findEnd(Customer[] customers) {
        int end = -1;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                end = i;
                break;
            }
        }
        return end;
    }
}
