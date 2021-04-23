package io;

import java.io.Serializable;
import java.util.List;

public interface IO<T extends Serializable> {
    List<T> read(String fileName);
    boolean write(String fileName, List<T> objects);
}
