package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class FigureComposite implements Figure {

   private List<Figure> figures = new ArrayList<Figure>();
    private int placedGraphes = 0;
    private int missedClicks = 0;



    public void ResetFigures() {
        this.figures.clear();
    }

    public void ResetPlacedGraphes() {
        this.placedGraphes = 0;
    }

    public void ResetMissedClicks() {
        this.missedClicks = 0;
    }

    public void addFigure(Rect rect){

        figures.add(rect);
        placedGraphes++;
        System.out.println(rect);


    }

    public void addFigure(Circle circle){

        figures.add(circle);
        placedGraphes++;
        System.out.println(circle);


    }


    @Override
    public void repaint(GraphicsContext gc) {

        gc.clearRect(0,0,640,480);
        gc.setFill(Color.DARKRED);
        gc.fillRect(0,0,640,480);


        for(Figure item : figures){


            item.repaint(gc);


        }


    }

    @Override
    public boolean containsPoint(double x, double y) {

        for(Figure item : figures){


            if(item.containsPoint(x, y)) {
                missedClicks++;
                System.out.println("false coordinates");
                System.out.println(x + " " + y);
                return true;}

        }



        return false;
    }

    public int getPlacedGraphes() {
        return placedGraphes;
    }

    public int getMissedClicks() {
        return missedClicks;
    }
}
