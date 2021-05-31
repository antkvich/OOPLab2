package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Controller {

    public ColorPicker colorPicker;
    public Canvas canvas;
    public ToggleButton lineTButton;
    public ToggleButton rectangleTButton;
    public ToggleButton squareTButton;
    public ToggleButton ellipseTButton;
    public ToggleButton circleTButton;
    public Button clearButton;

    private Color selectedColor;
    private Figure currentFigure;
    private Drawer drawer;

    @FXML
    public void initialize() {
        canvas.getParent().setStyle("-fx-background-color: white");

        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
        drawer = new Drawer(graphicsContext2D);

        colorPicker.setValue(Color.VIOLET);
        selectedColor = Color.VIOLET;

        colorPicker.setOnAction(e -> selectedColor = colorPicker.getValue());
        clearButton.setOnAction(this::clear);

        lineTButton.setOnAction(e -> currentFigure = new Line());
        rectangleTButton.setOnAction(e -> currentFigure = new Rectangle());
        squareTButton.setOnAction(e -> currentFigure = new Square());
        ellipseTButton.setOnAction(e -> currentFigure = new Oval());
        circleTButton.setOnAction(e -> currentFigure = new Circle());

        canvas.setOnMousePressed(this::onMousePressed);
        canvas.setOnMouseReleased(this::onMouseReleased);

        lineTButton.fire();
    }

    private void clear(ActionEvent e) {
        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
        Paint fill = graphicsContext2D.getFill();
        graphicsContext2D.setFill(Color.WHITE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 1200, 720);
        graphicsContext2D.setFill(fill);
    }

    private void onMousePressed(MouseEvent e) {
        if (e.isPrimaryButtonDown()) {
            Point startPoint = new Point(e.getX(), e.getY());
            currentFigure.setStartPoint(startPoint);
        }
    }


    private void onMouseReleased(MouseEvent e) {
        Point endPoint = new Point(e.getX(), e.getY());
        currentFigure.setEndPoint(endPoint);
        drawer.draw(currentFigure, selectedColor);
    }
}
