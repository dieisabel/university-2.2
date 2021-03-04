package io;

import java.io.File;

public interface Reader {
    double[] readOneDimensionalArray(File file);
    double[] readOneDimensionalArray(String fileName);

    double[][] readTwoDimensionalArray(File file);
    double[][] readTwoDimensionalArray(String fileName);
}
