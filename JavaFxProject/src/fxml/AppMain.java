package fxml;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setSpacing(10);
		
		TextField textField = new TextField();
		textField.setPrefWidth(200);
		
		Button button = new Button();
		button.setText("확인");
		
		root.getChildren().add(textField);
		root.getChildren().add(button);
		
		Scene scene = new Scene(root); //scene에 컨테이너넣어줌
		primaryStage.setScene(scene);
		primaryStage.show();
		
	
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + " : stop() 실행.");
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
