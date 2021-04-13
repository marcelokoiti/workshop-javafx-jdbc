package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//Estamos instanciando ao inves de fazer de forma estatica. Possibilita manipular antes de carregar
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
//			Parent parent = loader.load();
			ScrollPane scrollPane = loader.load();      
			scrollPane.setFitToHeight(true);                       // ajusta altura maximo
			scrollPane.setFitToWidth(true);                        // ajusta largura maximo
			
			Scene mainScene = new Scene(scrollPane);               // Cena principal
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Exemplo JavaFX application");
			primaryStage.show();                                   // mostra o palco
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("java version: "+System.getProperty("java.version")); 
		System.out.println("javafx.version: " + System.getProperty("javafx.version"));
		launch(args);
	}
}
