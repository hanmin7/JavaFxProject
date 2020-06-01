package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

//Controller(event)  Initializable 구현

public class RootController implements Initializable {
	@FXML
	TextField textField; 
	
	@FXML Button btnOk;  
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		textField.setText("초기화합니다");
		btnOk.setOnAction(new EventHandler<ActionEvent>() { //익명구현객체선언
			
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
	}
	
}
