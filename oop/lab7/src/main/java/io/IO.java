package io;

import java.util.ArrayList;

public interface IO<T> {
    ArrayList<T> read(String fileName);
    boolean write(String fileName, ArrayList<T> objects);
}
