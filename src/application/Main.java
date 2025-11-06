package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();

        engine.load(getClass().getResource("/map.html").toExternalForm());

        stage.setScene(new Scene(webView, 1200, 800));
        stage.setTitle("VIT Campus Map - Google Maps");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
