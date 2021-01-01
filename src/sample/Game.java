package sample;

import javafx.scene.canvas.GraphicsContext;

public class Game {

    private View view;
    private FigureComposite figureComposite;

    public FigureComposite getFigureComposite() {
        return figureComposite;
    }
// the link methods sets up all connections

    void link(FigureComposite figureComposite , View view){

        this.figureComposite = figureComposite;
        this.view = view;


        // Setup the mouse handler
        view.addHandler(this);

    }





}
