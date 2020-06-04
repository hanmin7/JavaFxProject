package media_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class MediaController implements Initializable {
	@FXML ImageView imageView;
	@FXML MediaView mediaView;
	@FXML Button btnPlay, btnPause, btnStop;
	@FXML ProgressBar progressBar;
	@FXML ProgressIndicator progressIndicator;
	@FXML Label labelTime;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		mediaView.setMediaPlayer(new MediaPlayer(new Media()));
		Media media = new Media(getClass().getResource("/medias/video.m4v").toString());
		MediaPlayer player = new MediaPlayer(media);
		mediaView.setMediaPlayer(player);
		
		player.setOnReady(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false); //disable이 false로해야 사용가능
				btnStop.setDisable(true);
				btnPause.setDisable(true);
				
				player.currentTimeProperty().addListener(new ChangeListener<Duration>() {

					@Override
					public void changed(ObservableValue<? extends Duration> observable, Duration oldValue,
							Duration newValue) {
						double progress = player.getCurrentTime().toSeconds() /
								player.getTotalDuration().toSeconds();
						progressBar.setProgress(progress);
						progressIndicator.setProgress(progress);
						labelTime.setText(
							(int)player.getCurrentTime().toSeconds()+"/"+
							(int)player.getTotalDuration().toSeconds()+" sec");
					}
				});
				
			}
		});
		
		player.setOnPlaying(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(true);
				btnStop.setDisable(false);
				btnPause.setDisable(false);
			}
		});
		
		player.setOnPaused(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnStop.setDisable(false);
				btnPause.setDisable(true);
			}
		});
		
		player.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnStop.setDisable(true);
				btnPause.setDisable(true);
				
				progressBar.setProgress(1.0);
				progressIndicator.setProgress(1.0);
			}
		});
		
		player.setOnStopped(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnStop.setDisable(true);
				btnPause.setDisable(true);
			}
		});
		
		
		btnPlay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				player.play();
			}
		});
		btnStop.setOnAction((e)-> player.stop()); //람다식
		btnPause.setOnAction((e)-> player.pause());

		
		
		
		
	}

}
