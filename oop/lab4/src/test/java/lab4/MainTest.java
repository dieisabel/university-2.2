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
    void testFunctionFirstExpression() {
        double x = 1.2;
        double expected = -0.3395111;
        double actual = main.function(x, a, eps);
        assertEquals(expected, actual, eps);
    }

    @Test
    void testFunctionSecondExpression() {
        double x = 1.7;
        double expected = 16.4963;
        double actual = main.function(x, a, eps);
        assertEquals(expected, actual, eps);
    }

    @Test
    void testFunctionThirdExpression() {
        double x = 1.9;
        double expected = 1.06253;
        double actual = main.function(x, a, eps);
        assertEquals(expected, actual, eps);
    }

    @Test
    void testCalculateSteps() {
        int expected = 241;
        int actual = main.calculateSteps(start, end, step);
        assertEquals(expected, actual);
    }

    @Test
    void testCreateArrayX0() {
        double expected = 0.8;
        int size = main.calculateSteps(start, end, step);
        double actual = main.createArrayX(size, start, step)[0];
        assertEquals(expected, actual, eps);
    }

    @Test
    void testCreateArrayX180() {
        double expected = 1.7;
        int size = main.calculateSteps(start, end, step);
        double actual = main.createArrayX(size, start, step)[180];
        assertEquals(expected, actual, eps);
    }

    @Test
    void testCreateArrayX240() {
        double expected = 2.0;
        int size = main.calculateSteps(start, end, step);
        double actual = main.createArrayX(size, start, step)[240];
        assertEquals(expected, actual, eps);
    }

    @Test
    void testCreateArrayY0() {
        double expected = -8.92;
        int size = main.calculateSteps(start, end, step);
        double actual = main.createArrayY(size, start, step, a, eps)[0];
        assertEquals(expected, actual, eps);
    }

    @Test
    void testCreateArrayY180() {
        double expected = 16.4963;
        int size = main.calculateSteps(start, end, step);
        double actual = main.createArrayY(size, start, step, a, eps)[180];
        assertEquals(expected, actual, eps);
    }

    @Test
    void testCreateArrayY240() {
        double expected = 1.07552;
        int size = main.calculateSteps(start, end, step);
        double actual = main.createArrayY(size, start, step, a, eps)[240];
        assertEquals(expected, actual, eps);
    }

    @Test
    void testMinX() {
        int expected = 0;
        int size = main.calculateSteps(start, end, step);
        double[] array = main.createArrayX(size, start, step);
        int actual = main.min(array);
        assertEquals(expected, actual);
    }

    @Test
    void testMaxX() {
        int expected = 240;
        int size = main.calculateSteps(start, end, step);
        double[] array = main.createArrayX(size, start, step);
        int actual = main.max(array);
        assertEquals(expected, actual);
    }

    @Test
    void testMinY() {
        int expected = 0;
        int size = main.calculateSteps(start, end, step);
        double[] array = main.createArrayY(size, start, step, a, eps);
        int actual = main.min(array);
        assertEquals(expected, actual);
    }

    @Test
    void testMaxY() {
        int expected = 182;
        int size = main.calculateSteps(start, end, step);
        double[] array = main.createArrayY(size, start, step, a, eps);
        int actual = main.max(array);
        assertEquals(expected, actual);
    }

    @Test
    void testMeanX() {
        double expected = 1.4;
        int size = main.calculateSteps(start, end, step);
        double[] array = main.createArrayX(size, start, step);
        double actual = main.mean(array);
        assertEquals(expected, actual, eps);
    }

    @Test
    void testMeanY() {
        double expected = 0.49015;
        int size = main.calculateSteps(start, end, step);
        double[] array = main.createArrayY(size, start, step, a, eps);
        double actual = main.mean(array);
        assertEquals(expected, actual, eps);
    }

    @Test
    void testSumX() {
        double expected = 337.4;
        int size = main.calculateSteps(start, end, step);
        double[] array = main.createArrayX(size, start, step);
        double actual = main.sum(array);
        assertEquals(expected, actual, eps);
    }

    @Test
    void testSumY() {
        double expected = 118.1269;
        int size = main.calculateSteps(start, end, step);
        double[] array = main.createArrayY(size, start, step, a, eps);
        double actual = main.sum(array);
        assertEquals(expected, actual, eps);
    }
}