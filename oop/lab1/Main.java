import java.lang.Math;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] S) {
        System.out.println("Laboratory work No. 1");

        Main main = new Main();
        main.run();

        System.out.println("END");
    }

    void print(int m, int c, double t, double b, double f, double z) {
        System.out.printf("m = %d%n", m);
        System.out.printf("c = %d%n", c);
        System.out.printf("t = %f%n", t);
        System.out.printf("b = %f%n", b);
        System.out.printf("f = %f%n", f);
        System.out.printf("z = %f%n", z);
    }

    void printDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss:SSSS")));
    }

    double calcF(double m, double t, double c) {
        return Math.pow((m * Math.tan(t) + Math.abs(c * Math.sin(t))), 1.0 / 3.0);
    }

    double calcZ(double m, double b, double t, double c) {
        return m * Math.cos(b * t * Math.sin(t)) + c;
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        double t = scanner.nextDouble();
        double b = scanner.nextDouble();

        double f = calcF(m, t, c);
        double z = calcZ(m, b, t, c);

        print(m, c, t, b, f, z);
        printDateTime();
    }
}
