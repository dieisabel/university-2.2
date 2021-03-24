package lab5.logic;

public class Lab5ArrayProcessor implements ArrayProcessor {
    @Override
    public double calculate(double[] array) {
        double result = 1.0;
        for (double number : array) {
            result *= number;
        }
        return result;
    }

    @Override
    public double calculate(double[][] array) {
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

    @Override
    public void processArray(double[] array) {
        double product = calculate(array);
        System.out.println("Solution 1: product = " + product);
    }

    @Override
    public void processArray(double[][] array) {
        double max = calculate(array);
        System.out.println("Solution 2: max = " + max);
    }
}
