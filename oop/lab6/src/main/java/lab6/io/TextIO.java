package lab6.io;

import lab6.logic.Customer;

import java.io.*;
import java.util.ArrayList;

public class TextIO implements IO<Customer>{
    @Override
    public Customer[] read(String fileName) {
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
        Customer[] customersArray = new Customer[customers.size()];
        customersArray = customers.toArray(customersArray);
        return customersArray;
    }

    @Override
    public boolean write (String fileName, Customer[] objects) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            for (Object object : objects) {
                if (object == null) {
                    out.print((String) null);
                } else {
                    out.print(object);
                }
                out.println();
            }
        } catch (IOException e) {
            System.out.println("An " + e.getClass() + " occured while processing");
            return false;
        }
        return true;
    }

    private Customer readObject(String s) {
        if (s.equals("null")) {
            return null;
        }
        String[] objectString = s.split(" ");
        int id = Integer.parseInt (objectString[0]);
        String surname = objectString[1];
        String name = objectString[2];
        String patronymic = objectString[3];
        String address = objectString[4];
        int creditCardNumber = Integer.parseInt(objectString[5]);
        double accountBalance = Double.parseDouble(objectString[6]);
        return new Customer(id, surname, name, patronymic, address, creditCardNumber, accountBalance);
    }
}
