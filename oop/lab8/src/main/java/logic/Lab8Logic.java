package logic;

import io.TextIO;
import io.IO;
import io.JsonIO;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lab8Logic {
    public List<Customer> readFromTextFile(String fileName) {
        IO<Customer> in = new TextIO();
        return in.read(fileName);
    }

    public List<Customer> readFromJsonFile(String fileName) {
        IO<Customer> in = new JsonIO();
        return in.read(fileName);
    }

    public boolean writeToTextFile(String fileName, List<Customer> customers) {
        IO<Customer> out = new TextIO();
        return out.write(fileName, customers);
    }

    public boolean writeToJsonFile(String fileName, List<Customer> customers) {
        IO<Customer> out = new JsonIO();
        return out.write(fileName, customers);
    }

    public boolean addToList(List<Customer> customers, Customer customer) {
        customers.add(customer);
        return true;
    }

    public boolean removeFromList(List<Customer> customers) {
        if (customers.isEmpty()) {
            return false;
        }
        customers.remove(customers.size() - 1);
        return true;
    }

    public boolean removeCustomerFromList(List<Customer> customers, Customer customer) {
        if (customers.contains(customer)) {
            customers.remove(customer);
            return true;
        }
        return false;
    }

    public List<Customer> filterByName(List<Customer> customers, String name) {
        return customers.stream()
                .filter(x -> x.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Customer> filterByInterval(List<Customer> customers, int start, int end) {
        return customers.stream()
                .filter(x -> x.getCreditCardId() > start && x.getCreditCardId() < end)
                .collect(Collectors.toList());
    }

    public List<Customer> filterDebtors(List<Customer> customers) {
        return customers.stream()
                .filter(x -> x.getAccountBalance() < 0)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<LocalDate> distinctByBirthday(List<Customer> customers) {
        return customers.stream()
                .map(Customer::getBirthday)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Customer> getMostRichCustomerForEachBirthday(List<Customer> customers) {
        return distinctByBirthday(customers).stream()
                .map(x -> customers.stream()
                        .filter(y -> y.getBirthday().equals(x))
                        .max(Customer::compareTo)
                        .get())
                .collect(Collectors.toList());
    }

    public List<Customer> sortByBalance(List<Customer> customers) {
        return customers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
