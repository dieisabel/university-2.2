package lab4;

public class Main {

    public static void main(String[] args) {
        System.out.println("Laboratory Work No.4");

        Main main = new Main();
        main.run();

        System.out.println("END");
    }

    private void run() {
        double eps = 10e-3;
        double a = 1.5;
        double start = 0.8;
        double end = 2.0;
        double step = 0.005;

        int size = calculateSteps(start, end, step);

        double[] arrayY = createArrayY(size, start, step, a, eps);

        print(arrayY);
    }

    public void print(double[] array) {
        int min = min(array);
        System.out.println("MIN");
        System.out.println("index: " + min);
        System.out.println("value: " + array[min] + "\n");

        int max = max(array);
        System.out.println("MAX");
        System.out.println("index: " + max);
        System.out.println("value: " + array[max]);
    }

    public double function(double x, double a, double eps) {
        if (x < 1.7 - eps) {
            return Math.PI * Math.pow(x, 2) - 7 / Math.pow(x, 2);
        }
        if (x > 1.7 + eps) {
            return Math.log10(x + 7 * Math.sqrt(x));
        } else {
            return a * Math.pow(x, 3) + 7 * Math.sqrt(x);
        }
    }

    public int calculateSteps(double start, double end, double step) {
        return (int)((end - start) / step + 1);
    }

    public double[] createArrayX(int size, double start, double step) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = start + i * step;
        }
        return array;
    }

    public double[] createArrayY(int size, double start, double step, double a, double eps) {
        double[] array = new double[size];
        double x;
        for (int i = 0; i < size; i++) {
            x = start + i * step;
            array[i] = function(x, a, eps);
        }
        return array;
    }

    public int min(double[] array) {
        double minElement = array[0];
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public int max(double[] array) {
        double maxElement = array[0];
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public double mean(double[] array) {
        double sum = 0.0;
        for (double num : array) {
            sum += num;
        }
        return sum / array.length;
    }

    public double sum(double[] array) {
        double sum = 0.0;
        for (double num : array) {
            sum += num;
        }
        return sum;
    }
}
