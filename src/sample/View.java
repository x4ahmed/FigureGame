package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.canvas.Canvas;
import javafx.util.Duration;


import java.awt.*;

public class View extends VBox {

// JavaFx Nodes

    private int width = 640;
    private int height = 480;
    private Button start;
    private TextField size;
    private double SIZE = 50;
    private Text timeLeft;
    private Text missedClickes;
    private Text placedGraphics;
    private Rect rect;
    private Circle circle;
    private MouseButton press;
    private int time = 0;
    private boolean startedPlaying = false;


    Canvas canvas = new Canvas(width,height);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    public View(){
        start = new Button("Start");
        size = new TextField();
        timeLeft = new Text();
        missedClickes = new Text();
        placedGraphics = new Text();


        missedClickes.setText("Missed Clicks: " + 0);
        placedGraphics.setText("Placed Graphics: " + 0);
        timeLeft.setText("Time left: " + 10);


        gc.setFill(Color.DARKRED);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        this.getChildren().addAll(start,size,timeLeft,missedClickes,placedGraphics,canvas);



    }

    public Rect getRect() {
        return this.rect;
    }

    public Circle getCircle() {
        return this.circle;
    }

    public double getSIZE() {
        return SIZE;
    }

    void addHandler(Game event){

        canvas.setOnMouseClicked(e -> {


            if(!startedPlaying) {


                press = e.getButton();

                if (press == MouseButton.PRIMARY) {

                    if (!event.getFigureComposite().containsPoint(e.getX(), e.getY())) {

                        rect = new Rect(e.getX(), e.getY(), SIZE);
                        event.getFigureComposite().addFigure(rect);
                        event.getFigureComposite().repaint(gc);
                        placedGraphics.setText("Placed Graphics: " + event.getFigureComposite().getPlacedGraphes());

                    }
                    missedClickes.setText("Missed Clicks: " + event.getFigureComposite().getMissedClicks());

                } else if (press == MouseButton.SECONDARY) {

                    if (!event.getFigureComposite().containsPoint(e.getX(), e.getY())) {

                        circle = new Circle(e.getX(), e.getY(), SIZE);
                        event.getFigureComposite().addFigure(circle);
                        event.getFigureComposite().repaint(gc);
                        placedGraphics.setText("Placed Graphics: " + event.getFigureComposite().getPlacedGraphes());

                    }

                    missedClickes.setText("Missed Clicks: " + event.getFigureComposite().getMissedClicks());

                }
            }

            else return;


        });


        size.setOnAction(e ->{

            this.SIZE = Double.parseDouble(size.getText());

        });

        start.setOnAction(e ->{

            if(time == 0){
            time = 10;
            startedPlaying = false;
            timeLeft.setText("Time left: " + time);
            gc.clearRect(0,0,640,480);
            gc.setFill(Color.DARKRED);
            gc.fillRect(0,0,640,480);

            event.getFigureComposite().ResetFigures();
            event.getFigureComposite().ResetPlacedGraphes();
            event.getFigureComposite().ResetMissedClicks();
            missedClickes.setText("Missed Clicks: " + event.getFigureComposite().getMissedClicks());
            placedGraphics.setText("Placed Graphics: " + event.getFigureComposite().getPlacedGraphes());

            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event1 -> {

                timeLeft.setText("Time left: " + --time);
                if(time==0){startedPlaying = true;}


            }));

            timeline.setCycleCount(10);
            timeline.play();



            }


            else return;
        });







    }




}
