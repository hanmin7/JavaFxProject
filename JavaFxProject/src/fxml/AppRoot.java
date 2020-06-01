package fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppRoot extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		//컨트롤들이 담긴 컨테이너
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml")); //Rott.fxml파일을 가져와서 실행해야함. "../control/Root.fxml"딴곳에 있으면 상대경로 도 적어줌
//		HBox root = FXMLLoader.load(getClass().getResource("Root.fxml")); //상위클래스가 Parent
		
		Scene scene = new Scene(root); //컨테이너를 장면에 담음
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("FXML sample");
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}//메인역할 start(Stage primaryStage)
