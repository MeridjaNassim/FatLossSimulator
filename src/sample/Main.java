package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage STAGE;
    public static Scene MAIN_SCENE;

    public static Scene RESULTS_SCENE;
    public static Parent root_to_results;
    public static Controller mainPageController;
    public static ResultsController resultsController;
    private FXMLLoader loader1 ;
    private FXMLLoader loader2;
    @Override
    public void start(Stage primaryStage) throws Exception{
        loader1 = new FXMLLoader(); loader2 = new FXMLLoader();
         AnchorPane root = loader1.load(getClass().getResource("MainPage.fxml").openStream());
        mainPageController = loader1.getController();
       root_to_results = loader2.load(getClass().getResource("Results.fxml").openStream());
        resultsController = loader2.getController();

        String image = Main.class.getResource("background.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;");
        root_to_results.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;");
        primaryStage.setTitle("Fat Loss Simulator");
        MAIN_SCENE = new Scene(root,1000,749);
        RESULTS_SCENE = new Scene(Main.root_to_results,1000,749);
        primaryStage.setScene(MAIN_SCENE);
        primaryStage.setResizable(false);
        STAGE = primaryStage;
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
