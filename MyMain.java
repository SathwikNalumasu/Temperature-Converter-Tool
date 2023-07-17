package com.internshala.javafxapp;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyMain extends Application{

	public static void main(String[] args){
	launch(args);
	}

	@Override
	public void init() throws Exception {
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));

		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);


		Scene scene = new Scene(rootNode, 300, 275);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature converter Tool");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	private MenuBar createMenu(){
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Helloooooo");
			}
		});

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("quit");

		quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Byeeeee");
				Platform.exit();
			}
		});

		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

		Menu helpMenu = new Menu("Help");
		helpMenu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("About");
				alert.setHeaderText("Temperature Converter");
				alert.setContentText("This tool is used to convert temperature from Celsius to Farenhiet and vice-versa");
				alert.show();
			}
		});
		final MenuItem aboutApp = new MenuItem("About");
		helpMenu.getItems().addAll(aboutApp);
		aboutApp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			}
		});
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);

		return menuBar;
	}


	@Override
	public void stop() throws Exception {
		super.stop();
	}
}
