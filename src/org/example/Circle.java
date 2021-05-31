package org.example;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends Figure {

    protected double startX;
    protected double startY;
    protected double diameterX;

    public Circle() {
    }

    @Override
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
        double deltaX = startPoint.getX() - endPoint.getX();
        double deltaY = startPoint.getY() - endPoint.getY();

        if (deltaX > 0) {
            startX = startPoint.getX() - Math.abs(deltaX);
        } else {
            startX = startPoint.getX();
        }

        if (deltaY > 0) {
            startY = startPoint.getY() - Math.abs(deltaY);
        } else {
            startY = startPoint.getY();
        }

        diameterX = Math.abs(deltaX);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(color);
        graphicsContext.fillOval(startX, startY, diameterX, diameterX);
    }
}
