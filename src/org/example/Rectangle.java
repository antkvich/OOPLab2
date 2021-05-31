package org.example;

public class Rectangle extends Square {

    public Rectangle() {
    }

    @Override
    public void setEndPoint(Point endPoint) {
        double deltaX = endPoint.getX() - startPoint.getX();
        double deltaY = endPoint.getY() - startPoint.getY();

        double startX = deltaX > 0 ? startPoint.getX() : endPoint.getX();
        double startY = deltaY > 0 ? startPoint.getY() : endPoint.getY();

        startPoint.setX(startX);
        startPoint.setY(startY);

        width = Math.abs(deltaX);
        height = Math.abs(deltaY);

    }

}
