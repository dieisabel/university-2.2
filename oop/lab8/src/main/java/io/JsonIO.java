package io;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import logic.Customer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonIO implements IO<Customer> {

    ObjectMapper objectMapper;

    public JsonIO() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public List<Customer> read(String fileName) {
        try {
            return objectMapper.readValue(
                    new File(fileName),
                    new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean write(String fileName, List<Customer> objects) {
        try {
            objectMapper.writeValue(new File(fileName), objects);
        } catch (IOException e) {
            System.out.println("An " + e.getClass() + " occured while processing");
            return false;
        }
        return true;
    }
}
