package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

    Main main;
    double eps = 10e-3;

    double a = 1.5;
    double start = 0.8;
    double end = 2.0;
    double step = 0.005;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testFunction() {
        double actual1 = main.function(1.2, a, eps);
        double actual2 = main.function(1.7, a, eps);
        double actual3 = main.function(1.9, a, eps);
        assertEquals(-0.3395111, actual1, eps);
        assertEquals(16.4963, actual2, eps);
        assertEquals(1.06253, actual3, eps);
    }

    @Test
    void testCalculateSteps() {
        int expected = 241;
        int actual = main.calculateSteps(start, end, step);
        assertEquals(expected, actual);
    }

    @Test
    void testCreateArrayX() {
        int size = main.calculateSteps(start, end, step);
        double[] array = main.createArrayX(size, start, step);
        assertEquals(0.8, array[0], eps);
        assertEquals(1.7, array[180], eps);
        assertEquals(2.0, array[240], eps);
    }

    @Test
    void testCreateArrayY() {
        int size = main.calculateSteps(start, end, step);
        double[] array = main.createArrayY(start, end, step, a, eps);
        assertEquals(-8.92, array[0], eps);
        assertEquals(16.4963, array[180], eps);
        assertEquals(1.07552, array[240], eps);
    }

    @Test
    void testMinMax() {
        int size = main.calculateSteps(start, end, step);
        double[] array = main.createArrayY(size, start, step, a, eps);
        int min = main.min(array);
        int max = main.max(array);
        assertEquals(0, min);
        assertEquals(182, max);
    }

    @Test
    void testMean() {
        double expected = 0.49015;
        int size = main.calculateSteps(start, end, step);
        double[] array = main.createArrayY(size, start, step, a, eps);
        double actual = main.mean(array);
        assertEquals(expected, actual, eps);
    }

    @Test
    void testSum() {
        double expected = 118.1269;
        int size = main.calculateSteps(start, end, step);
        double[] array = main.createArrayY(size, start, step, a, eps);
        double actual = main.sum(array);
        assertEquals(expected, actual, eps);
    }
}