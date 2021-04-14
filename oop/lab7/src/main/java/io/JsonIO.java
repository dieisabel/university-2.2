package io;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import logic.Customer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonIO implements IO<Customer> {

    @Override
    public ArrayList<Customer> read(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(
                    new File(fileName),
                    new TypeReference<ArrayList<Customer>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean write(String fileName, ArrayList<Customer> objects) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(fileName), objects);
        } catch (IOException e) {
            System.out.println("An " + e.getClass() + " occured while processing");
            return false;
        }
        return true;
    }
}
