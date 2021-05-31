package org.example;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Figure {

    public Line() {
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.strokeLine(startPoint.getX(), startPoint.getY(),
                endPoint.getX(), endPoint.getY());
    }
}
