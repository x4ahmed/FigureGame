package sample;

import javafx.scene.canvas.GraphicsContext;

public interface Figure {
    // Repaints the figure
    void repaint(GraphicsContext gc);



    // Checks if the Entity cotains the specified point
    boolean containsPoint(double x , double y);


}
