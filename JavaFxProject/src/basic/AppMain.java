package basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppMain extends Application {//(추상클래스) Application 상속받는 AppMain 

	public AppMain() { //생성자
		System.out.println(Thread.currentThread().getName() + " : AppMain() 실행.");
	}
	
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + " : init() 실행.");
	}

	@Override
	public void start(Stage primaryStage) throws Exception { //보통 UI만드는소스 여기에 넣음	
		System.out.println(Thread.currentThread().getName() + " : start() 실행.");
		
		//스테이지표현위한 장면(Scene) -scene에는 컨테이너(컨트롤)가 필요
		
		VBox root = new VBox(); //컨테이너
		root.setPrefWidth(350); //사이즈
		root.setPrefHeight(150);
		root.setAlignment(Pos.CENTER);// 컨트롤들 중앙정렬
		root.setSpacing(20); //컨트롤 사이의 간격 조절 
		
		
		Label label = new Label(); //컨트롤 . label : 텍스트 출력
		label.setText("Hello JavaFX");
		label.setFont(new Font(50)); //폰트크기조절
		
		Button button = new Button(); //컨트롤
		button.setText("확인");
		button.setOnAction(event -> Platform.exit()); //람다식 표현으로 밑에서 길게 적은걸 줄일 수 있음
		
//		//원래 문장
//		button.setOnAction(new EventHandler<ActionEvent>() { //버튼에 액션이벤트 넣을꺼임
//			
//			@Override
//			public void handle(ActionEvent event) {
//				Platform.exit(); //확인버튼 누르면 종료액션 넣음
//			}
//		});
		
		root.getChildren().add(label); //컨트롤 나타내기위해 getChildren add로 달아두겠다
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
