package vitcampusmap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class Main extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        context = new SpringApplicationBuilder(Main.class).run();
    }

    @Override
    public void start(Stage stage) {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();

        try {
            // Load HTML file as text
            URL url = getClass().getResource("/map.html");
            String html = new String(Files.readAllBytes(Paths.get(url.toURI())));

            // Insert your API key from environment variable
            String apiKey = System.getenv("GOOGLE_MAP_KEY");

            if (apiKey == null || apiKey.isBlank()) {
                System.out.println("❌ ERROR: GOOGLE_MAP_KEY environment variable not set!");
                System.out.println("Set it using:   setx GOOGLE_MAP_KEY \"YOUR_KEY_HERE\"");
                return;
            }

            html = html.replace("__API_KEY__", apiKey);

            // Load final processed HTML into WebView
            engine.loadContent(html);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(webView, 1200, 800);
        stage.setTitle("VIT Campus Map");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        context.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
