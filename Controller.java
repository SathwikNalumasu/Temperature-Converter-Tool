package com.internshala.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	@FXML
	public Label welcomeLabel;
	@FXML
	public ChoiceBox<String> choiceBox;
	@FXML
	public TextField userInputField;
	@FXML
	public Button convertButton;
	private static final String C_To_F_Text="Celsius to Farenhiet";
	private static final String F_To_C_Text="Farenhiet to Celsius";

	private boolean isC_To_F = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox.getItems().add(C_To_F_Text);
		choiceBox.getItems().add(F_To_C_Text);
		choiceBox.setValue(C_To_F_Text);

		choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			System.out.println(newValue);
			if(newValue.equals(C_To_F_Text)){
				isC_To_F = true;

			}else
			{
				isC_To_F = false;
			}
			}
		});

	convertButton.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			convert();
		}
	});
	}
	private void convert() {
		String input = userInputField.getText();

		try{
			float enteredTemperature = Float.parseFloat(input);
			float newTemperature = 0.0f;
			if (isC_To_F) {
				newTemperature = (enteredTemperature * 9 / 5) + 32;
			} else {
				newTemperature = (enteredTemperature - 32) * 5 / 9;
			}
			display(newTemperature);
		}catch(Exception exception){
			warnUser();
			return;
		}


	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error occurred");
		alert.setContentText("Enter Valid Temperature ");
		alert.show();
	}

	private void display(float newTemperature) {
		String unit =  isC_To_F? " F" : " C";
		System.out.println("The converted Temperature is " + newTemperature + unit);
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The converted Temperature is " + newTemperature + unit);
		alert.show();
	}
}

