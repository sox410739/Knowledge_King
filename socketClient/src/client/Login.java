package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Login {
	private static accountData account;
	private Button loginBtn;
	private Button registBtn;
	private static TextField accountInput;
	private static PasswordField passwordInput;
	private Label labelOfPleaseInputAccount;
	private Label labelOfPleaseInputPassword;
	private static Label labelOfRegistSuccess;
	private static Label labelOfWrongInput;
	private static Label labelOfHaveBeenRegisted;
	private static Pane background;
	private static boolean setSceneFlag = false;
	private ImageView backImg;
	private ImageView notRobot;
	private CheckBox checkNotRobot;
	boolean loginFlag = false;
	
	public void gameScreen() {
		background = new Pane();
		ClientMain.mainScene = new Scene(background, 480, 800);
		ClientMain.mainScene.setCursor(Cursor.HAND);
		
		backImg = new ImageView(new Image(getClass().getResourceAsStream("data/loginBack.png")));
		backImg.setLayoutX(0);
		backImg.setLayoutY(0);
		backImg.setFitHeight(800);
		backImg.setFitWidth(480);
		background.getChildren().add(backImg);
		
		loginBtn = new Button();
		loginBtn.setLayoutX(100);
		loginBtn.setLayoutY(600);
		loginBtn.setPrefHeight(80);
		loginBtn.setPrefWidth(140);
		loginBtn.setStyle("-fx-background-color:green; -fx-background-radius: 25;");
		loginBtn.setText("登入");
		loginBtn.setFont(new Font(30));
		loginBtn.setTextFill(Color.WHITE);
		background.getChildren().add(loginBtn);
		loginBtn.setOnMouseClicked(loginPressed);
		loginBtn.setOnMouseEntered(enterButton);
		loginBtn.setOnMouseExited(exitButton);
		
		registBtn = new Button();
		registBtn.setLayoutX(250);
		registBtn.setLayoutY(600);
		registBtn.setPrefHeight(80);
		registBtn.setPrefWidth(140);
		registBtn.setStyle("-fx-background-color:darkred; -fx-background-radius: 25;");
		registBtn.setText("註冊");
		registBtn.setFont(new Font(30));
		registBtn.setTextFill(Color.WHITE);
		background.getChildren().add(registBtn);
		registBtn.setOnMouseClicked(registPressed);
		registBtn.setOnMouseEntered(enterButton);
		registBtn.setOnMouseExited(exitButton);
		
		notRobot = new ImageView(new Image(getClass().getResourceAsStream("data/notRobot.png")));
		notRobot.setLayoutX(150);
		notRobot.setLayoutY(500);
		notRobot.setFitWidth(188);
		notRobot.setFitHeight(46);
		background.getChildren().add(notRobot);
		
		checkNotRobot = new CheckBox();
		checkNotRobot.setLayoutX(158);
		checkNotRobot.setLayoutY(492);
		checkNotRobot.setPrefHeight(60);
		checkNotRobot.setPrefWidth(60);
		background.getChildren().add(checkNotRobot);
		checkNotRobot.setOnMouseEntered(enterButton);
		checkNotRobot.setOnMouseExited(exitButton);
		
		accountInput = new TextField(); 
		accountInput.setPrefColumnCount(1);
		accountInput.setPrefWidth(250);
		accountInput.setPrefHeight(40);
		accountInput.setAlignment(Pos.CENTER_LEFT);
		accountInput.setLayoutX(120);
		accountInput.setLayoutY(410);
		accountInput.setPromptText("帳號");
		background.getChildren().add(accountInput);
		
		passwordInput = new PasswordField(); 
		passwordInput.setPrefColumnCount(1);
		passwordInput.setPrefWidth(250);
		passwordInput.setPrefHeight(40);
		passwordInput.setAlignment(Pos.CENTER_LEFT);
		passwordInput.setLayoutX(120);
		passwordInput.setLayoutY(450);
		passwordInput.setPromptText("密碼");
		background.getChildren().add(passwordInput);
		
		labelOfPleaseInputAccount = new Label();
		labelOfPleaseInputAccount.setLayoutX(375);
		labelOfPleaseInputAccount.setLayoutY(420);
		labelOfPleaseInputAccount.setVisible(false);
		labelOfPleaseInputAccount.setText("請輸入帳號");
		labelOfPleaseInputAccount.setTextFill(Color.RED);
		labelOfPleaseInputAccount.setFont(new Font(20));
		background.getChildren().add(labelOfPleaseInputAccount);
		
		labelOfPleaseInputPassword = new Label();
		labelOfPleaseInputPassword.setLayoutX(375);
		labelOfPleaseInputPassword.setLayoutY(460);
		labelOfPleaseInputPassword.setVisible(false);
		labelOfPleaseInputPassword.setText("請輸入密碼");
		labelOfPleaseInputPassword.setTextFill(Color.RED);
		labelOfPleaseInputPassword.setFont(new Font(20));
		background.getChildren().add(labelOfPleaseInputPassword);
		
		labelOfRegistSuccess = new Label();
		labelOfRegistSuccess.setLayoutX(340);
		labelOfRegistSuccess.setLayoutY(510);
		labelOfRegistSuccess.setVisible(false);
		labelOfRegistSuccess.setText("註冊成功!!");
		labelOfRegistSuccess.setTextFill(Color.GREEN);
		labelOfRegistSuccess.setFont(new Font(20));
		background.getChildren().add(labelOfRegistSuccess);
		
		labelOfWrongInput = new Label();
		labelOfWrongInput.setLayoutX(340);
		labelOfWrongInput.setLayoutY(510);
		labelOfWrongInput.setVisible(false);
		labelOfWrongInput.setText("帳號或密碼輸入錯誤");
		labelOfWrongInput.setTextFill(Color.RED);
		labelOfWrongInput.setFont(new Font(15));
		background.getChildren().add(labelOfWrongInput);
		
		labelOfHaveBeenRegisted = new Label();
		labelOfHaveBeenRegisted.setLayoutX(340);
		labelOfHaveBeenRegisted.setLayoutY(510);
		labelOfHaveBeenRegisted.setVisible(false);
		labelOfHaveBeenRegisted.setText("此帳號已被註冊");
		labelOfHaveBeenRegisted.setTextFill(Color.RED);
		labelOfHaveBeenRegisted.setFont(new Font(20));
		background.getChildren().add(labelOfHaveBeenRegisted);
	}
	
	public EventHandler<MouseEvent> loginPressed = (e)->{
		boolean accountIsEmpty = accountInput.getText().equals("");
		boolean passwordIsEmpty = passwordInput.getText().equals("");
		labelOfPleaseInputAccount.setVisible(false);
		labelOfPleaseInputPassword.setVisible(false);
		labelOfWrongInput.setVisible(false);
		labelOfRegistSuccess.setVisible(false);
		labelOfHaveBeenRegisted.setVisible(false);
		
		if(accountIsEmpty){
			labelOfPleaseInputAccount.setVisible(true);
		}
		if(passwordIsEmpty){
			labelOfPleaseInputPassword.setVisible(true);
		}
		if(!accountIsEmpty && !passwordIsEmpty) {   //pass account to server
			Thread task = null;
			try {
				task = new Thread(new loginTask(ClientMain.clientSocket.getOutputStream(), ClientMain.clientSocket.getInputStream()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			task.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if(setSceneFlag) {
				background.getChildren().clear();
				Gaming game = new Gaming(account);
				game.gaming();
			}
		}
	};
	
	public EventHandler<MouseEvent> registPressed = (e)->{
		boolean accountIsEmpty = accountInput.getText().equals("");
		boolean passwordIsEmpty = passwordInput.getText().equals("");
		labelOfPleaseInputAccount.setVisible(false);
		labelOfPleaseInputPassword.setVisible(false);
		labelOfWrongInput.setVisible(false);
		labelOfRegistSuccess.setVisible(false);
		labelOfHaveBeenRegisted.setVisible(false);
		
		if(accountIsEmpty){
			labelOfPleaseInputAccount.setVisible(true);
		}
		if(passwordIsEmpty){
			labelOfPleaseInputPassword.setVisible(true);
		}
		if(!accountIsEmpty && !passwordIsEmpty) {
			Thread task = null;
			try {
				task = new Thread(new registTask(ClientMain.clientSocket.getOutputStream(), ClientMain.clientSocket.getInputStream()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			task.start();
		}
	};
	
	private static class registTask implements Runnable{
		private BufferedWriter output = null;
		private BufferedReader input = null; 
		
		public registTask(OutputStream out, InputStream in) throws IOException {
			output = new BufferedWriter(new OutputStreamWriter(out, "Cp950"));
			input = new BufferedReader(new InputStreamReader(in, "Cp950"));
		}
		
		@Override
		public void run() {
			char[] buf = new char[1024];
			String acc = accountInput.getText();
			String pass = passwordInput.getText();
			try {
				
				String temp = "R " + acc + " " + pass;
				output.write(temp);
				output.flush();
				
				int length = input.read(buf);
				temp = new String(buf, 0, length);
				System.out.println(temp);
				if(temp.charAt(0) == 's') {
					labelOfRegistSuccess.setVisible(true);
					accountInput.setText("");
					passwordInput.setText("");
				}
				else if(temp.charAt(0) == 'h') {
					labelOfHaveBeenRegisted.setVisible(true);
					accountInput.setText("");
					passwordInput.setText("");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
	public static class loginTask implements Runnable{
		private BufferedWriter output = null;
		private BufferedReader input = null;  
		
		public loginTask(OutputStream out, InputStream in) throws IOException {
			output = new BufferedWriter(new OutputStreamWriter(out, "Cp950"));
			input = new BufferedReader(new InputStreamReader(in, "Cp950"));
		}
		
		@Override
		public void run() {
			char[] buf = new char[1024];
			String acc = accountInput.getText();
			String pass = passwordInput.getText();
			try {
				String temp = "L " + acc + " " + pass;
				output.write(temp);
				output.flush();
				
				int length = input.read(buf);
				temp = new String(buf, 0, length);
				System.out.println(temp);
				if(temp.charAt(0) == 'e') {
					labelOfWrongInput.setVisible(true);
					accountInput.setText("");
					passwordInput.setText("");
				}
				else if(temp.charAt(0) == 's') {
					accountInput.setText("");
					passwordInput.setText("");
					temp = temp.substring(13);
					account = new accountData(temp);
					setSceneFlag = true;
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
	public EventHandler<MouseEvent> enterButton = (e)-> {
		ClientMain.mainScene.setCursor(Cursor.HAND);
		//System.out.println(e.getSource().getClass());
		if(e.getSource().getClass().toString().equals("class javafx.scene.control.Button")) {
			Button temp = (Button)e.getSource();
			Glow glow = new Glow(0);
			temp.setEffect(glow);
			Timeline glowUp = new Timeline(new KeyFrame(Duration.millis(50), (glowEvent)->{
				glow.setLevel(glow.getLevel() + 0.15);
			}));
			glowUp.setCycleCount(5);
			glowUp.play();
		}
	};
	
	public EventHandler<MouseEvent> exitButton = (e)->{
		ClientMain.mainScene.setCursor(Cursor.DEFAULT);
		if(e.getSource().getClass().toString().equals("class javafx.scene.control.Button")) {
			Button temp = (Button)e.getSource();
			Glow glow = new Glow(0.75);
			temp.setEffect(glow);
			Timeline glowDown = new Timeline(new KeyFrame(Duration.millis(50), (glowEvent)->{
				glow.setLevel(glow.getLevel() - 0.15);
			}));
			glowDown.setCycleCount(5);
			glowDown.play();
		}
	};
}
