package logic;

public class Lab5Processor implements Processor {
    @Override
    public double process(double[] array) {
        double result = 1.0;
        for (double number : array) {
            result *= number;
        }
        return result;
    }

    @Override
    public double process(double[][] array) {
        double max = array[0][0];
        int border = array.length - 1;
        for (double[] row : array) {
            for (int j = array.length - 1; j >= border; j--) {
                if (max < row[j]) {
                    max = row[j];
                }
            }
            border--;
        }
        return max;
    }
}
