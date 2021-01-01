package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Figure Game");

        var view = new View();
        var game = new Game();
        var figureComposite = new FigureComposite();
        game.link(figureComposite,view);

        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
