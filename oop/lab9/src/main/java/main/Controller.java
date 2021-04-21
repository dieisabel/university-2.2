package main;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import logic.Logic;
import logic.Point;

import java.util.List;

public class Controller {

    Logic logic;

    @FXML
    private TextField startField;

    @FXML
    private TextField finishField;

    @FXML
    private TextField stepField;

    @FXML
    private TextArea outputArea;

    public void initialize() {
        this.logic = new Logic();
    }

    public void calculate() {
        double start = Double.parseDouble(startField.getText());
        double finish = Double.parseDouble(finishField.getText());
        double step = Double.parseDouble(stepField.getText());
        int steps = logic.calculateSteps(start, finish, step);
        List<Point> points = logic.tabulate(start, finish, step, logic::function);
        Point min = logic.min(points);
        Point max = logic.max(points);
        double mean = logic.mean(points);
        double sum = logic.sum(points);
        String result = "Steps: " + steps + "\n" +
                "Min y: " + min.getY() + "\n" +
                "Min x: " + min.getX() + "\n" +
                "Max y: " + max.getY() + "\n" +
                "Max x: " + max.getX() + "\n" +
                "Mean: " + mean + "\n" +
                "Sum: " + sum;
        outputArea.setText(result);
    }
}
