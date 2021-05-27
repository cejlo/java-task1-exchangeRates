package currencyConverterJavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import currencyConverter.Converter;

public class Controller {

	@FXML
	public Label resultLabel;
	@FXML
	public TextField input;
	@FXML
	public ComboBox<String> comboBox;
	@FXML
	public Button button;

	public Controller() {
    }
	  
	@FXML
    public void initialize() {
		
		ObservableList<String> currenciesObsList = FXCollections.observableArrayList(Converter.getAvaiableCurrencies());
		
		comboBox.setItems(currenciesObsList);
		
		comboBox.setValue(currenciesObsList.get(0));
		
		button.setOnAction(e -> {
			try {
				String value = input.getText();
				String currency = (String) comboBox.getValue();
				String result = Converter.convertRound(currency,value);
				resultLabel.setText(result);
			} catch (Error err) {
				resultLabel.setText("Error, correct values");
			}
		});
		
    }
    
}