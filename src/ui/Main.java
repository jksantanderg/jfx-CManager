package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	private MenuControllerGUI controller;
	
	public static void main (String[] args) {
		launch(args);
	}
	
	//Cambio

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
		controller =new MenuControllerGUI();
		
		fxmlLoader.setController(controller);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		
		controller.setMainStage(primaryStage);
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Contact Manager");
		primaryStage.show();	

	}


	public MenuControllerGUI getController() {
		return controller;
	}

	public void setController(MenuControllerGUI controller) {
		this.controller = controller;
	}

}
