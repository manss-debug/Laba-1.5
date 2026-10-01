package org.example.javalab3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                Launcher.class.getResource(
                        "/org/example/javalab3/BookOverview.fxml"
                )
        );

        Scene scene = new Scene(loader.load());

        stage.setTitle("Электронный каталог книг");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}