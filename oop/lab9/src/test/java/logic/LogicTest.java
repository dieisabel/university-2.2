package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {

    Logic logic;

    @BeforeEach
    void setUp() {
        logic = new Logic();
    }

    @Test
    void testTabulate() {
        double start = 0.8;
        double finish = 2.0;
        double step = 0.005;
        double eps = 10e-3;
        List<Point> points = logic.tabulate(start, finish, step, logic::function);
        assertEquals(0.8, points.get(0).getX(), eps);
        assertEquals(1.7, points.get(180).getX(), eps);
        assertEquals(2.0, points.get(240).getX(), eps);
        assertEquals(-8.92, points.get(0).getY(), eps);
        assertEquals(16.4963, points.get(180).getY(), eps);
        assertEquals(1.07552, points.get(240).getY(), eps);
    }
}