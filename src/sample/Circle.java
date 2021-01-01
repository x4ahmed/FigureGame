package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle implements Figure {
    private double X;
    private double Y;
    private double Size;

    public Circle(double x , double y , double size) {

        this.X = x;
        this.Y = y;
        this.Size = size;

    }


    @Override
    public void repaint(GraphicsContext gc) {

        gc.setFill(Color.PURPLE);
        gc.setStroke(Color.WHITE);
        gc.strokeOval(this.X-(Size/2), this.Y-(Size/2), this.Size, this.Size);
        gc.fillOval(this.X-(Size/2), this.Y-(Size/2), this.Size, this.Size);
        gc.setFill(Color.WHITE);
        gc.fillOval(this.X, this.Y, 2, 2);

    }

    @Override
    public boolean containsPoint(double x, double y) {

        double X1 = this.X-(Size/2);
        double Y1 = this.Y-(Size/2);

        double result = Math.sqrt((Math.pow((this.X-x),2))+(Math.pow((this.Y-y),2)));

        if(result<=(this.Size/2)) {return true;}

        return false;
    }


}
