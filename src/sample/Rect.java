package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.lang.Math;

public class Rect implements Figure {
    private double X;
    private double Y;
    private double Size;

    public Rect(double x , double y , double size){

        this.X = x;
        this.Y = y;
        this.Size = size;

    }


    @Override
    public void repaint(GraphicsContext gc) {

        gc.setStroke(Color.WHITE);
        gc.setFill(Color.DARKBLUE);
        gc.fillRect(this.X-(Size/2),this.Y-(Size/2), Size, Size);
        gc.setFill(Color.WHITE);
        gc.strokeRect(this.X-(Size/2),this.Y-(Size/2), Size, Size);
        gc.fillOval(this.X, this.Y, 2, 2);
        System.out.println(this.X + " " + this.Y);

    }


    @Override
    public boolean containsPoint(double x, double y) {
        // top left point
        double X1 = this.X-(Size/2);
        double Y1 = this.Y-(Size/2);

        // lower right point
        double X2 = this.X+(Size/2);
        double Y2 = this.Y+(Size/2);

        if(x>X1 && x<X2 && y>Y1 && y<Y2){return true;}


        else return false;


    }

}
