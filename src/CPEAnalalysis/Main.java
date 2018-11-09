package CPEAnalalysis;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class Main extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Image[] images = new Image[1];
        images[0] = new Image("./IMG_0899.jpg");
        Button btGenerateC = new Button("Generate testing C Source files");
        Button buttonSo = new Button("Generate Dynamic Link Library files");
        Button buttonData = new Button("Test performance data");
        btGenerateC.setOnAction(e -> {
            final Runtime runtime = Runtime.getRuntime();
            Process process1 = null;
            try {
                process1 = runtime.exec("./generateC");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        buttonSo.setOnAction(e -> {
            final Runtime runtime = Runtime.getRuntime();
            Process process2 = null;
            try {
                process2 = runtime.exec("./generateSo");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        buttonData.setOnAction(e -> {
            final Runtime runtime = Runtime.getRuntime();
            Process process3 = null;
            try {
                process3 = runtime.exec("./linkRun");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        ImageView imageView = new ImageView(images[0]);
        imageView.setFitWidth(450);
        imageView.setFitHeight(300);
        HBox hBox1 = new HBox(10);
        hBox1.getChildren().addAll(btGenerateC);
        hBox1.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox(10);
        hBox2.getChildren().addAll(buttonSo);
        hBox2.setAlignment(Pos.CENTER);

        HBox hBox3 = new HBox(10);
        hBox3.getChildren().addAll(buttonData);
        hBox3.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox1, hBox2, hBox3);
        // Create a pane to hold nodes
        BorderPane pane = new BorderPane();
        pane.setCenter(imageView);
        pane.setBottom(vBox);
        vBox.setPadding(new Insets(10));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 550, 430);
        primaryStage.setTitle("CPE Testing Program - Wang, Chen for ICS Lab");
        // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}