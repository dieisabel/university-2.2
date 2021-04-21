package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class Logic {
    public List<Point> tabulate(double start, double finish, double step, DoubleUnaryOperator func) {
        int steps = calculateSteps(start, finish, step);
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < steps; i++) {
            double x = start + i * step;
            double y = func.applyAsDouble(x);
            points.add(new Point(x, y));
        }
        return points;
    }

    public double function(double x) {
        double a = 1.5;
        double eps = 10e-6;
        if (x < 1.7 - eps) {
            return Math.PI * Math.pow(x, 2) - 7 / Math.pow(x, 2);
        }
        if (x > 1.7 + eps) {
            return Math.log10(x + 7 * Math.sqrt(x));
        } else {
            return a * Math.pow(x, 3) + 7 * Math.sqrt(x);
        }
    }

    public int calculateSteps(double start, double finish, double step) {
        return (int) Math.round((finish - start) / step) + 1;
    }

    public double sum(List<Point> points) {
        return points.stream().mapToDouble(Point::getY).sum();
    }

    public double mean(List<Point> points) {
        return sum(points) / points.size();
    }

    public Point min(List<Point> points) {
        return points.stream().min(Point::compareTo).orElse(points.get(0));
    }

    public Point max(List<Point> points) {
        return points.stream().max(Point::compareTo).orElse(points.get(0));
    }
}
