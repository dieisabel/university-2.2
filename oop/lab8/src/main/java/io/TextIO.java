package io;

import logic.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TextIO implements IO<Customer> {
    @Override
    public List<Customer> read(String fileName) {
        ArrayList<Customer> customers = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String s = in.readLine();
            while (s != null) {
                customers.add(readObject(s));
                s = in.readLine();
            }
        } catch (IOException e) {
            System.out.println("An " + e.getClass() + " occured while processing");
            return null;
        }
        return customers;
    }

    @Override
    public boolean write (String fileName, List<Customer> customers) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            for (Customer customer : customers) {
                out.print(customer);
                out.println();
            }
        } catch (IOException e) {
            System.out.println("An " + e.getClass() + " occured while processing");
            return false;
        }
        return true;
    }

    private Customer readObject(String s) {
        String[] objectString = s.split(" ");
        int id = Integer.parseInt (objectString[0]);
        String surname = objectString[1];
        String name = objectString[2];
        String patronymic = objectString[3];
        LocalDate birthday = LocalDate.parse(objectString[4]);
        String address = objectString[5];
        int creditCardNumber = Integer.parseInt(objectString[6]);
        double accountBalance = Double.parseDouble(objectString[7]);
        return new Customer(id, surname, name, patronymic, birthday, address, creditCardNumber, accountBalance);
    }
}
