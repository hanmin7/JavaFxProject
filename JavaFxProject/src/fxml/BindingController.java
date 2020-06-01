package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class BindingController implements Initializable{
	@FXML TextArea txtArea1;
	@FXML TextArea txtArea2;
	@FXML Label label;
	@FXML Slider slider;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldVal, Number newVal) {
//				System.out.println(newVal);
				label.setFont(new Font(newVal.doubleValue()));
				
			}
			
		});
		
//		txtAria2.textProperty().bind(txtArea1.textProperty());
//		txtAria2.textProperty().bindBidirectional(txtArea1.textProperty());
		Bindings.bindBidirectional(txtArea1.textProperty(), txtArea2.textProperty());
		//txtArea1에 글 적는거 txtArea2에도 담음 2역시 1에 담기고.
	}

}
