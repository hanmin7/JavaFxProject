package view_pack;

import javafx.beans.property.SimpleStringProperty;

public class Board {
	private SimpleStringProperty title;
	private SimpleStringProperty password;
	private SimpleStringProperty publicity;
	private SimpleStringProperty exitDate;
	private SimpleStringProperty content;
	
	public Board(String title, String password, String publicity, String exitDate, String content) {
		this.title = new SimpleStringProperty(title);
		this.password = new SimpleStringProperty(password);
		this.publicity = new SimpleStringProperty(publicity);
		this.exitDate = new SimpleStringProperty(exitDate);
		this.content = new SimpleStringProperty(content);
	}
	
	public String getTitle() {
		return this.title.get();
	}
	public void setTitle(String title) {
		this.title.set(title);
	}
	public SimpleStringProperty titleProperty() {
		return this.title;
	}
	//password
	public String getPassword() {
		return this.password.get();
	}
	public void setPassword(String title) {
		this.password.set(title);
	}
	public SimpleStringProperty passwordProperty() {
		return this.password;
	}
	//publicity
	public String getPublicity() {
		return this.publicity.get();
	}
	public void setPublicity(String title) {
		this.publicity.set(title);
	}
	public SimpleStringProperty publicityProperty() {
		return this.publicity;
	}
	//exitDate
	public String getExitDate() {
		return this.exitDate.get();
	}
	public void setExitDate(String title) {
		this.exitDate.set(title);
	}
	public SimpleStringProperty exitDateProperty() {
		return this.exitDate;
	}
	//content
	public String getContent() {
		return this.content.get();
	}
	public void setContent(String title) {
		this.content.set(title);
	}
	public SimpleStringProperty contentProperty() {
		return this.content;
	}
	
}
