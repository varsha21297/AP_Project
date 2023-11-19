import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Skeleton extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Stick Hero Game");

        AnchorPane anchorPane=new AnchorPane();
        AnchorPane anchorPane2=new AnchorPane();
        // Create UI components for the skeleton screen
        Button startButton = new Button("Start Game");
        Label characterLabel = new Label("Stick Hero");
        anchorPane.getChildren().add(startButton);
        anchorPane.getChildren().add(characterLabel);
        startButton.setLayoutX(360);
        startButton.setLayoutY(200);
        characterLabel.setLayoutX(360);
        characterLabel.setLayoutY(160);
        startButton.setOnAction(actionEvent -> {
            primaryStage.setScene(new Scene(anchorPane2, 800, 500));});
        // Define layout structure (VBox for simplicity)
                // Set the scene
        Scene initialScene = new Scene(anchorPane, 800, 500);

        Label gameLabel = new Label("Stick Hero Game Screen");
        Label scoreLabel = new Label("Score: 0");
        Button backButton = new Button("Pause");
        anchorPane2.getChildren().add(gameLabel);
        anchorPane2.getChildren().add(scoreLabel);
        anchorPane2.getChildren().add(backButton);

        gameLabel.setAlignment(Pos.CENTER);
        scoreLabel.setLayoutX(20);
        scoreLabel.setLayoutY(10);
        backButton.setLayoutX(720);
        backButton.setLayoutY(10);
        primaryStage.setScene(initialScene);
        primaryStage.show();
    }

}
