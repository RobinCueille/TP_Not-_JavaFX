package application;
import javafx.scene.image.Image;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("IHM.fxml"));
			Scene scene = new Scene(root,500,400); // Dimension de la fenêtre 
			Image image = new Image("file:Images/logo3il.png");
			primaryStage.setTitle("Gestionnaire de couleurs"); // On change le titre de la page
			primaryStage.setResizable(false); // On rend a page immuable au changement de taille 
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.getIcons().add(image);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
