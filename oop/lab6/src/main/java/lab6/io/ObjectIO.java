package lab6.io;

import lab6.logic.Customer;

import java.io.*;

public class ObjectIO implements IO<Customer>{
    @Override
    public Customer[] read (String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Customer[]) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An " + e.getClass() + " occured while processing");
            return null;
        }
    }

    @Override
    public boolean write (String fileName, Customer[] objects) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(objects);
        } catch (IOException e) {
            System.out.println("An " + e.getClass() + " occured while processing");
            return false;
        }
        return true;
    }
}
