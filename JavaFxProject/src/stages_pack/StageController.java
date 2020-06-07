package stages_pack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageController implements Initializable {
	@FXML TableView<Student> tableView;
	@FXML Button btnAdd, btnChart;
	
	ObservableList<Student> scores; //Student클래스 만들어야함
	
//	Stage primaryStage;
//	void setPrimaryStage(Stage primaryStage) {
//		this.primaryStage = primaryStage;
//	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		scores = FXCollections.observableArrayList(); //초기화
		
		//Button에 액션달아줌
//		btnAdd.setOnAction(e -> btnAddAction(e));
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				btnAddAction(event);
			}
		});
		btnChart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				btnChartAction(event);
			}
		});
		
		TableColumn<Student, ?> tcName = tableView.getColumns().get(0); //칼럼첫번째꺼 가져옴
		tcName.setCellValueFactory(new PropertyValueFactory("name"));
		
		TableColumn<Student, ?> tcKorean = tableView.getColumns().get(1);
		tcKorean.setCellValueFactory(new PropertyValueFactory("korean"));
		
		TableColumn<Student, ?> tcMath = tableView.getColumns().get(2);
		tcMath.setCellValueFactory(new PropertyValueFactory("math"));
		
		TableColumn<Student, ?> tcEnglish = tableView.getColumns().get(3);
		tcEnglish.setCellValueFactory(new PropertyValueFactory("english"));
		
		
		//tableView
		tableView.setItems(scores);
		
	}
	
	public void btnAddAction(ActionEvent ae) {
		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);
		addStage.initOwner(btnAdd.getScene().getWindow()); //아무컨트롤가져와서.getScene.getWindow ...거기에 새로운 윈도우를 뿌린다
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("AddForm.fxml")); //scene 담아야함
			Scene scene = new Scene(parent);
			
			addStage.setScene(scene);
			addStage.setResizable(false);
			addStage.show();
			
			Button btnFormAdd = (Button) parent.lookup("#btnFormAdd");
			btnFormAdd.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					TextField txtName = (TextField) parent.lookup("#txtName");
					TextField txtKorean = (TextField) parent.lookup("#txtKorean");
					TextField txtMath = (TextField) parent.lookup("#txtMath");
					TextField txtEnglish = (TextField) parent.lookup("#txtEnglish");
					Student student = new Student(txtName.getText(),
									Integer.parseInt(txtKorean.getText()),//int로 선언했었기때문에 타입변환 해줘야함
									Integer.parseInt(txtMath.getText()),
									Integer.parseInt(txtEnglish.getText())
					);
					scores.add(student);
					addStage.close();
					
				}
			});
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void btnChartAction(ActionEvent ae) {
		Stage chartStage = new Stage(StageStyle.UTILITY);
		chartStage.initModality(Modality.WINDOW_MODAL);
//		chartStage.initOwner(primaryStage);
		chartStage.initOwner(btnAdd.getScene().getWindow());
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("ScoreChart.fxml"));
			BarChart barChart = (BarChart) parent.lookup("#barChart");
			
			XYChart.Series<String, Integer> seriesKorean = new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasKorean = FXCollections.observableArrayList();
			for(int i=0; i<scores.size(); i++) {
				datasKorean.add(new XYChart.Data(scores.get(i).getName(), scores.get(i).getKorean()));
				//이름, 국어점수 
			}
			seriesKorean.setData(datasKorean);
			seriesKorean.setName("국어");
			
			XYChart.Series<String, Integer> seriesMath = new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasMath = FXCollections.observableArrayList();
			for(int i=0; i<scores.size(); i++) {
				datasMath.add(new XYChart.Data(scores.get(i).getName(), scores.get(i).getMath()));
			}
			seriesMath.setData(datasMath);
			seriesMath.setName("수학");
			
			XYChart.Series<String, Integer> seriesEnglish = new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasEnglish = FXCollections.observableArrayList();
			for(int i=0; i<scores.size(); i++) {
				datasEnglish.add(new XYChart.Data(scores.get(i).getName(), scores.get(i).getEnglish()));
			}
			seriesEnglish.setData(datasEnglish);
			seriesEnglish.setName("영어");
			
			
			barChart.setData(FXCollections.observableArrayList(seriesKorean, seriesMath, seriesEnglish));
			
			Scene scene = new Scene(parent);
			chartStage.setScene(scene);
			chartStage.show();
			chartStage.setResizable(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
