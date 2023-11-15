import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Skeleton extends Application {

    private Stage primaryStage;
    private VBox root;
    private Scene initialScene;
    private Scene gameScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Stick Hero Game");

        // Create UI components for the skeleton screen
        Button startButton = new Button("Start Game");
        Label characterLabel = new Label("Stick Hero");

        // Define layout structure (VBox for simplicity)
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(startButton, characterLabel);

        // Set the scene
        initialScene = new Scene(root, 400, 300);

        // Add event handler for the "Start Game" button
        startButton.setOnAction(e -> showGameScene());

        Label gameLabel = new Label("Stick Hero Game Screen");
        Label scoreLabel = new Label("Score: 0");

        // Define layout structure (VBox for the main game content)
        VBox gameRoot = new VBox(20);
        gameRoot.setAlignment(Pos.CENTER);
        gameRoot.getChildren().add(gameLabel);

        // Create HBoxes for the top-left and top-right corners
        HBox topLeftBox = new HBox(10);
        topLeftBox.setAlignment(Pos.TOP_LEFT);

        HBox topRightBox = new HBox(10);
        topRightBox.setAlignment(Pos.TOP_RIGHT);

        // Create pause button and add it to the top-left HBox
        Button pauseButton = new Button("Pause");
        topLeftBox.getChildren().add(pauseButton);

        // Set alignment for the scoreLabel and add it to the top-right HBox
        scoreLabel.setAlignment(Pos.TOP_RIGHT);
        topRightBox.getChildren().add(scoreLabel);

        // Add the top-left and top-right HBoxes to the gameRoot
        gameRoot.getChildren().addAll(topLeftBox, topRightBox);

        // Set the scene
        gameScene = new Scene(gameRoot, 400, 300);

        primaryStage.setScene(initialScene);
        primaryStage.show();
    }

    private void showGameScene() {
        primaryStage.setScene(gameScene);
    }
}
