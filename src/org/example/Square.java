package org.example;

import javafx.scene.canvas.GraphicsContext;


public class Square extends Figure {

    double width;
    double height;

    public Square() {
    }

    @Override
    public void setEndPoint(Point endPoint) {
        double deltaX = endPoint.getX() - startPoint.getX();
        double deltaY = endPoint.getY() - startPoint.getY();

        double startX = deltaX > 0 ? startPoint.getX() : endPoint.getX();
        double startY = deltaY > 0 ? startPoint.getY() : endPoint.getY();

        startPoint.setX(startX);
        startPoint.setY(startY);

        deltaX = Math.abs(deltaX);
        deltaY = Math.abs(deltaY);

        height = width = deltaX < deltaY ? deltaX : deltaY;

    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(color);
        graphicsContext.fillRect(startPoint.getX(), startPoint.getY(), width, height);
    }
}
