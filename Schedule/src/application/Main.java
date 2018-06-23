package application;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	  public void start(Stage primaryStage) throws IOException {
	    // constructing our scene
	    URL url = getClass().getResource("ScheduleController.fxml");
	    AnchorPane pane = FXMLLoader.load( url );
	    Scene scene = new Scene( pane );
	    primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/icons/date_and_time_clock-512.png")));
	    // setting the stage
	    primaryStage.setScene( scene );
	    primaryStage.setTitle( "Schedule" );
	    primaryStage.show();
	    
	  }
	
	public static void main(String[] args) {
		launch(args);
	}
}
