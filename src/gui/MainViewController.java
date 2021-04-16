package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction teste");
	}
	
	@FXML
	public void onMenuItemDepartmentAction() {
		System.out.println("onMenuItemDepartmentAction teste");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		System.out.println("onMenuItemAboutAction teste");	
		loadView("/gui/About.fxml");
	}
	
// The initialize method is called after all @FXML annotated members have been injected
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

//synchronized - aplicativo grafico é multithread. Para garantir que o processamento "try" nao seja iterrompido
	public synchronized void loadView(String absoluteName) {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));

/*  No MainView.fxml (janela Principal) inicia com <ScrollPane /  <content> /  <VBox / <children / <MenuBar
*   Pega referencia "<Vbox" do main para acrescentar nos filhos "<children" do Vbox main , os
*   filhos "<children" do  "<Vbox" about
*/
		VBox newVBox = loader.load();
		
		Scene mainScene = Main.getMainScene();   
		VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
		
		Node mainMenu = mainVBox.getChildren().get(0);        // Primeiro <children do VBox da MainView
		mainVBox.getChildren().clear();                       // limpa os <children do VBox da MainView
		
		mainVBox.getChildren().add(mainMenu);                 // Reinsere o <children do VBox da MainView
		mainVBox.getChildren().addAll(newVBox.getChildren()); // Insere o <children do VBox do About
		
		}
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro no loadView", e.getMessage(), AlertType.ERROR);
		}
	}
	
}
