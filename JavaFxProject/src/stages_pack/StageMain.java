package stages_pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Root.fxml
//AddForm.fxml
//ScoreChart.fxml
//StageController.java

public class StageMain extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("AddForm.fxml"));
		
//		FXMLLoader loader = new FXMLLoader(); //인스턴스 선언 후 호출하는 방법
//		Parent root = loader.load(getClass().getResource("Root.fxml"));
//		
//		//Controller에 stage(메인) 값 넘겨줌.
//		StageController cont = loader.getController();
//		cont.setPrimaryStage(stage);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
