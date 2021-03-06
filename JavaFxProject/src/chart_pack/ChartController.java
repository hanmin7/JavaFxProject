package chart_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class ChartController implements Initializable {
	@FXML PieChart pieChart;
	@FXML BarChart<String, Integer> barChart;
	@FXML AreaChart<String, Integer> areaChart;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pieChart.setData(FXCollections.observableArrayList(
			new PieChart.Data("AWT", 10),
			new PieChart.Data("Swing", 30),
			new PieChart.Data("SWT", 25),
			new PieChart.Data("JavaFX", 35),
			new PieChart.Data("Others", 10.0)
		));
		//-----pieChart
		
		XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
		series1.setData(FXCollections.observableArrayList(
				new XYChart.Data("2015", 70),
				new XYChart.Data("2016", 40),
				new XYChart.Data("2017", 50),
				new XYChart.Data("2018", 30)
		));
		series1.setName("Cat1");
		
		XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
		series2.setData(FXCollections.observableArrayList(
				new XYChart.Data("2015", 40),
				new XYChart.Data("2016", 90),
				new XYChart.Data("2017", 20),
				new XYChart.Data("2018", 80)
		));
		series2.setName("Cat2");
		
		barChart.setData(FXCollections.observableArrayList(series1, series2));
		//------barChart
		
		XYChart.Series<String, Integer> series3 = new XYChart.Series<>();
		series3.setData(FXCollections.observableArrayList(
				new XYChart.Data("2015", 70),
				new XYChart.Data("2016", 40),
				new XYChart.Data("2017", 50),
				new XYChart.Data("2018", 30)
		));
		series3.setName("Cat3");
		areaChart.setData(FXCollections.observableArrayList(series3));
		//------areaChart
		
		
	}//initialize

}//ChartController
