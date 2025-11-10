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

        engine.setUserAgent(
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120 Safari/537.36"
        );

        engine.load(getClass().getResource("/map.html").toExternalForm());

        stage.setScene(new Scene(webView, 1200, 800));
        stage.setTitle("VIT Campus Map - Google Maps");
        stage.show();
    }

    public static void main(String[] args) {
        System.setProperty("javafx.webview.renderer", "webview2");
        launch(args);
    }

}
