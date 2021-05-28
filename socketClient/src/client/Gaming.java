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
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Gaming{
	private static String instruction;
	private static String enemyMessage;
	//home
	private static accountData account;
	private static Pane background;
	private static ImageView profileImg;
	private static ImageView challengeImg;
	private static ImageView bankImg;
	private static Label labelOfLevel;
	private static ProgressBar barOfExp;
	private static Label labelOfName;
	private static TextField textOfMoney;
	//profile
	private static Pane profilePane;
	private static Label myName;
	private static ImageView myCharacter;
	private static ImageView backImg;
	//challenge
	private static ImageView challengeBackToHomeImg;
	private static int checkpointNumber;
	private static ImageView checkpoint1Img;
	private static ImageView checkpoint2Img;
	private static ImageView checkpoint3Img;
	private static ImageView checkpoint4Img;
	//searching
	private static Label labelOfSearching;
	private static ImageView deletSearchingImg;
	private static ImageView searchingBackImg;
	private static Label labelOfTimer;
	private static int timer;
	//via
	private static ImageView backTopImg;
	private static ImageView backDownImg;
	private static ImageView myCharacterImg;
	private static ImageView enemyCharacterImg;
	private static ImageView myCharacterHeadImg;
	private static ImageView enemyCharacterHeadImg;
	private static Label labelOfMyname;
	private static Label labekOfEnemyName;
	private static String enemyName;
	private static int enemyCharacter;
	//answer
	private static ImageView checkpointBackImg;
	private static int setTime;
	private static Label labelOfMyscore;
	private static Label labelOfEnemyscore;
	private static ProgressBar myScoreBar;
	private static ProgressBar enemyScoreBar;
	private static int myScore;
	private static int myDifference;
	private static int enemyScore;
	private static int enemyDifference;
	private static int fullScore;
	private static boolean answered;
	private static boolean enemyAnswered;
	
	private static Label labelOfQuestionNumber;
	private static int questionNumber;
	private static int finalQuestionNumber;
	private static Label labelOfQuestion;
	private static int correctAnswer;
	private static int myNumberOfAC;
	private static String question;
	private static Button option1Btn;
	private static Button option2Btn;
	private static Button option3Btn;
	private static Button option4Btn;
	private static Button[] BtnArr;
	private static int colorInt = 15;
	//end
	private static ImageView endBackImg;
	private static Label labelOfWin;
	private static Label labelOfchallengeResult;
	private static Label loabelOfGold;
	private static Label labelOfExp;
	private static Label labelOfMyplusGold;
	private static Label labelOfMyplusExp;
	private static int gotGold;
	private static int gotExp;
	private static ImageView findNewEnemyImg;
	private static ImageView endBackToHomeImg;
	//message
	private static Pane messagePane;
	private static Label labelOfKeyinMessage;
	private static TextField keyinMessage;
	private static ImageView messagePassImg;
	private static ImageView messageCancelImg;
	private static TextField myMessageText;
	private static TextField enemyMessageText;
	//constructor
	public Gaming(accountData acc) {
		account = acc;
	}
	
	public void gaming() {
		//home
		background = new Pane();
		ClientMain.mainStage.setScene(new Scene(background, 480, 800));
		background.setStyle("-fx-background-color:black;");
		
		profileImg = new ImageView(new Image(getClass().getResourceAsStream("data/profile.png")));
		profileImg.setLayoutX(15);
		profileImg.setLayoutY(43);
		profileImg.setFitWidth(450);
		profileImg.setFitHeight(176);
		profileImg.setOnMouseEntered(mouseEntered);
		profileImg.setOnMouseExited(mouseExited);
		profileImg.setOnMouseClicked(profileClicked);
		background.getChildren().add(profileImg);
		
		challengeImg = new ImageView(new Image(getClass().getResourceAsStream("data/challenge.png")));
		challengeImg.setLayoutX(15);
		challengeImg.setLayoutY(225);
		challengeImg.setFitWidth(450);
		challengeImg.setFitHeight(400);
		challengeImg.setOnMouseEntered(mouseEntered);
		challengeImg.setOnMouseExited(mouseExited);
		challengeImg.setOnMouseClicked(challengeClicked);
		background.getChildren().add(challengeImg);
		
		bankImg = new ImageView(new Image(getClass().getResourceAsStream("data/bank.png")));
		bankImg.setLayoutX(15);
		bankImg.setLayoutY(630);
		bankImg.setFitWidth(450);
		bankImg.setFitHeight(162);
		bankImg.setOnMouseEntered(mouseEntered);
		bankImg.setOnMouseExited(mouseExited);
		background.getChildren().add(bankImg);
		
		textOfMoney = new TextField();
		textOfMoney.setLayoutX(300);
		textOfMoney.setLayoutY(5);
		textOfMoney.setPrefWidth(165);
		textOfMoney.setPrefHeight(32);
		textOfMoney.setText("   $" + account.getMoney());
		textOfMoney.setStyle("-fx-background-radius:50;" + " -fx-font-family:\"Berlin Sans FB Demi\";" 
		+ " -fx-font-size:25px;" + " -fx-font-weight:bold;" + " -fx-background-color:#bce0e5");
		textOfMoney.setPadding(new Insets(1, 0, 1, 0));
		textOfMoney.setFocusTraversable(false);
		textOfMoney.setEditable(false);
		textOfMoney.setCursor(Cursor.DEFAULT);
		background.getChildren().add(textOfMoney);
		
		labelOfLevel = new Label();
		labelOfLevel.setLayoutX(140);
		labelOfLevel.setLayoutY(5);
		labelOfLevel.setText("LV:" + account.getLevel());
		labelOfLevel.setFont(new Font(25));
		labelOfLevel.setTextFill(Color.WHITE);
		background.getChildren().add(labelOfLevel);
		
		barOfExp = new ProgressBar();
		barOfExp.setLayoutX(210);
		barOfExp.setLayoutY(13);
		barOfExp.setPrefWidth(80);
		barOfExp.setPrefHeight(20);
		barOfExp.setProgress(0.4);
		barOfExp.setProgress(((double)account.getExp()/(double)(account.getLevel()*50)));
		barOfExp.setStyle(new String("-fx-background-color:#535a5b;"));
		background.getChildren().add(barOfExp);
		
		labelOfName = new Label();
		labelOfName.setLayoutX(15);
		labelOfName.setLayoutY(5);
		labelOfName.setText(account.getName());
		labelOfName.setFont(new Font(30));
		labelOfName.setTextFill(Color.WHITE);
		background.getChildren().add(labelOfName);
		//profile
		profilePane = new Pane();
		profilePane.setLayoutX(60);
		profilePane.setLayoutY(100);
		profilePane.setPrefWidth(360);
		profilePane.setPrefHeight(600);
		profilePane.setOpacity(0);
		profilePane.setStyle("-fx-background-color: radial-gradient(focus-distance 0% ,center 50% 50% ,radius 60% ,#2694c7,#5e6161);");
		
		myName = new Label();
		myName.setLayoutX(120);
		myName.setLayoutY(50);
		myName.setPrefWidth(120);
		myName.setPrefHeight(80);
		myName.setAlignment(Pos.CENTER);
		myName.setFont(new Font(40));
		myName.setText(account.getName());
		myName.setOpacity(0);
		myName.setOnMouseEntered(optionEntered);
		myName.setOnMouseExited(optionExited);
		myName.setOnMouseClicked(nameClicked);
		profilePane.getChildren().add(myName);
		
		myCharacter = new ImageView(new Image(Gaming.class.getResourceAsStream("data/character" + account.getCharacter() + ".png")));
		myCharacter.setLayoutX(100);
		myCharacter.setLayoutY(100);
		myCharacter.setFitWidth(180);
		myCharacter.setFitHeight(400);
		myCharacter.setOpacity(0);
		myCharacter.setOnMouseEntered(optionEntered);
		myCharacter.setOnMouseExited(optionExited);
		myCharacter.setOnMouseClicked(myCharacterlClicked);
		profilePane.getChildren().add(myCharacter);
		
		backImg = new ImageView(new Image(Gaming.class.getResourceAsStream("data/messageCancel.png")));
		backImg.setLayoutX(120);
		backImg.setLayoutY(530);
		backImg.setFitWidth(120);
		backImg.setFitHeight(40);
		backImg.setOpacity(0);
		backImg.setOnMouseEntered(mouseEntered);
		backImg.setOnMouseExited(mouseExited);
		backImg.setOnMouseClicked(profileBackClicked);
		profilePane.getChildren().add(backImg);
		//challenge
		challengeBackToHomeImg = new ImageView(new Image(getClass().getResourceAsStream("data/back.png")));
		challengeBackToHomeImg.setLayoutX(5 + 480);
		challengeBackToHomeImg.setLayoutY(70);
		challengeBackToHomeImg.setFitWidth(100);
		challengeBackToHomeImg.setFitHeight(40);
		challengeBackToHomeImg.setOnMouseEntered(mouseEntered);
		challengeBackToHomeImg.setOnMouseExited(mouseExited);
		challengeBackToHomeImg.setOnMouseClicked(backToHomeClicked);
		background.getChildren().add(challengeBackToHomeImg);
		
		checkpoint1Img = new ImageView(new Image(getClass().getResourceAsStream("data/checkpoint1.png")));
		checkpoint1Img.setLayoutX(5 + 480);
		checkpoint1Img.setLayoutY(120);
		checkpoint1Img.setFitHeight(160);
		checkpoint1Img.setFitWidth(470);
		checkpoint1Img.setOnMouseEntered(mouseEntered);
		checkpoint1Img.setOnMouseExited(mouseExited);
		checkpoint1Img.setOnMouseClicked(anyCheckpointClicked);
		background.getChildren().add(checkpoint1Img);
		
		checkpoint2Img = new ImageView(new Image(getClass().getResourceAsStream("data/checkpoint2.png")));
		checkpoint2Img.setLayoutX(5 + 480);
		checkpoint2Img.setLayoutY(290);
		checkpoint2Img.setFitHeight(160);
		checkpoint2Img.setFitWidth(470);
		checkpoint2Img.setOnMouseEntered(mouseEntered);
		checkpoint2Img.setOnMouseExited(mouseExited);
		checkpoint2Img.setOnMouseClicked(anyCheckpointClicked);
		background.getChildren().add(checkpoint2Img);
		
		checkpoint3Img = new ImageView(new Image(getClass().getResourceAsStream("data/checkpoint3.png")));
		checkpoint3Img.setLayoutX(5 + 480);
		checkpoint3Img.setLayoutY(460);
		checkpoint3Img.setFitHeight(160);
		checkpoint3Img.setFitWidth(470);
		checkpoint3Img.setOnMouseEntered(mouseEntered);
		checkpoint3Img.setOnMouseExited(mouseExited);
		checkpoint3Img.setOnMouseClicked(anyCheckpointClicked);
		background.getChildren().add(checkpoint3Img);
		
		checkpoint4Img = new ImageView(new Image(getClass().getResourceAsStream("data/checkpoint4.png")));
		checkpoint4Img.setLayoutX(5 + 480);
		checkpoint4Img.setLayoutY(630);
		checkpoint4Img.setFitHeight(160);
		checkpoint4Img.setFitWidth(470);
		checkpoint4Img.setOnMouseEntered(mouseEntered);
		checkpoint4Img.setOnMouseExited(mouseExited);
		checkpoint4Img.setOnMouseClicked(anyCheckpointClicked);
		background.getChildren().add(checkpoint4Img);
		
		//searching
		searchingBackImg = new ImageView(new Image(getClass().getResourceAsStream("data/searchingBack.png")));
		searchingBackImg.setLayoutX(0);
		searchingBackImg.setLayoutY(0);
		searchingBackImg.setFitWidth(480);
		searchingBackImg.setFitHeight(800);
		searchingBackImg.setVisible(false);
		background.getChildren().add(searchingBackImg);
		
		labelOfSearching = new Label();
		labelOfSearching.setLayoutX(200);
		labelOfSearching.setLayoutY(350);
		labelOfSearching.setText("正在搜尋對手");
		labelOfSearching.setVisible(false);
		background.getChildren().add(labelOfSearching);
		
		deletSearchingImg = new ImageView(new Image(getClass().getResourceAsStream("data/deletSearch.png")));
		deletSearchingImg.setLayoutX(165);
		deletSearchingImg.setLayoutY(600);
		deletSearchingImg.setFitHeight(50);
		deletSearchingImg.setFitWidth(150);
		deletSearchingImg.setVisible(false);
		deletSearchingImg.setOnMouseEntered(mouseEntered);
		deletSearchingImg.setOnMouseExited(mouseExited);
		deletSearchingImg.setOnMouseClicked(deletSearchClicked);
		background.getChildren().add(deletSearchingImg);
		
		labelOfTimer = new Label();
		labelOfTimer.setLayoutX(200);
		labelOfTimer.setLayoutY(375);
		labelOfTimer.setFont(new Font(80));
		labelOfTimer.setTextFill(Color.WHITE);
		labelOfTimer.setAlignment(Pos.CENTER);
		labelOfTimer.setStyle("-fx-font-weight:bold;");
		labelOfTimer.setVisible(false);
		timer = 0;
		background.getChildren().add(labelOfTimer);
		//via
		backTopImg = new ImageView(new Image(getClass().getResourceAsStream("data/viaBackTop.png")));
		backTopImg.setLayoutX(0 - 480);
		backTopImg.setLayoutY(0);
		backTopImg.setFitWidth(480);
		backTopImg.setFitHeight(800);
		backTopImg.setVisible(true);
		background.getChildren().add(backTopImg);
		
		backDownImg = new ImageView(new Image(getClass().getResourceAsStream("data/viaBackDown.png")));
		backDownImg.setLayoutX(0 + 480);
		backDownImg.setLayoutY(0);
		backDownImg.setFitWidth(480);
		backDownImg.setFitHeight(800);
		backDownImg.setVisible(true);
		background.getChildren().add(backDownImg);
		
		labelOfMyname = new Label();
		labelOfMyname.setLayoutX(360 + 480);
		labelOfMyname.setLayoutY(250);
		labelOfMyname.setText(account.getName());
		labelOfMyname.setAlignment(Pos.CENTER);
		labelOfMyname.setFont(new Font(15));
		background.getChildren().add(labelOfMyname);
		
		labekOfEnemyName = new Label();
		labekOfEnemyName.setLayoutX(100 - 480);
		labekOfEnemyName.setLayoutY(690);
		labekOfEnemyName.setAlignment(Pos.CENTER);
		labekOfEnemyName.setFont(new Font(15));
		background.getChildren().add(labekOfEnemyName);
		//answer
		labelOfQuestionNumber = new Label();
		labelOfQuestionNumber.setLayoutX(180);
		labelOfQuestionNumber.setLayoutY(150);
		labelOfQuestionNumber.setFont(new Font(40));
		labelOfQuestionNumber.setTextFill(Color.WHITE);
		labelOfQuestionNumber.setAlignment(Pos.CENTER);
		labelOfQuestionNumber.setOpacity(0);
		labelOfQuestionNumber.setVisible(false);
		background.getChildren().add(labelOfQuestionNumber);
		
		labelOfQuestion = new Label();
		labelOfQuestion.setLayoutX(140);
		labelOfQuestion.setLayoutY(175);
		labelOfQuestion.setPrefWidth(200);
		labelOfQuestion.setPrefHeight(160);
		labelOfQuestion.setFont(new Font(25));
		labelOfQuestion.setTextFill(Color.WHITE);
		labelOfQuestion.setAlignment(Pos.CENTER);
		labelOfQuestion.setOpacity(0);
		labelOfQuestion.setVisible(false);
		background.getChildren().add(labelOfQuestion);
		
		option1Btn = new Button();
		option1Btn.setLayoutX(100);
		option1Btn.setLayoutY(350);
		option1Btn.setPrefHeight(90);
		option1Btn.setPrefWidth(280);
		option1Btn.setOpacity(0);
		option1Btn.setVisible(false);
		option1Btn.setStyle("-fx-background-color:#fafeff; -fx-background-radius:10; -fx-font-weight:bold; -fx-font-fill:#262424; -fx-font-size:32;");
		background.getChildren().add(option1Btn);
		
		option2Btn = new Button();
		option2Btn.setLayoutX(100);
		option2Btn.setLayoutY(450);
		option2Btn.setPrefHeight(90);
		option2Btn.setPrefWidth(280);
		option2Btn.setOpacity(0);
		option2Btn.setVisible(false);
		option2Btn.setStyle("-fx-background-color:#fafeff; -fx-background-radius:10; -fx-font-weight:bold; -fx-font-fill:#262424; -fx-font-size:32;");
		background.getChildren().add(option2Btn);
		
		option3Btn = new Button();
		option3Btn.setLayoutX(100);
		option3Btn.setLayoutY(550);
		option3Btn.setPrefHeight(90);
		option3Btn.setPrefWidth(280);
		option3Btn.setOpacity(0);
		option3Btn.setVisible(false);
		option3Btn.setStyle("-fx-background-color:#fafeff; -fx-background-radius:10; -fx-font-weight:bold; -fx-font-fill:#262424; -fx-font-size:32;");
		background.getChildren().add(option3Btn);
		
		option4Btn = new Button();
		option4Btn.setLayoutX(100);
		option4Btn.setLayoutY(650);
		option4Btn.setPrefHeight(90);
		option4Btn.setPrefWidth(280);
		option4Btn.setOpacity(0);
		option4Btn.setVisible(false);
		option4Btn.setStyle("-fx-background-color:#fafeff; -fx-background-radius:10; -fx-font-weight:bold; -fx-font-fill:#262424; -fx-font-size:32;");
		background.getChildren().add(option4Btn);
		
		BtnArr = new Button[5];
		BtnArr[1] = option1Btn;
		BtnArr[2] = option2Btn;
		BtnArr[3] = option3Btn;
		BtnArr[4] = option4Btn;
		
		labelOfMyscore = new Label();
		labelOfMyscore.setLayoutX(13 - 30);
		labelOfMyscore.setLayoutY(350);
		myScore = 0;
		labelOfMyscore.setFont(new Font(30));
		labelOfMyscore.setText("" + myScore);
		labelOfMyscore.setTextFill(Color.WHITE);
		labelOfMyscore.setAlignment(Pos.CENTER);
		background.getChildren().add(labelOfMyscore);
		
		labelOfEnemyscore = new Label();
		labelOfEnemyscore.setLayoutX(450 + 30);
		labelOfEnemyscore.setLayoutY(350);
		enemyScore = 0;
		labelOfEnemyscore.setFont(new Font(30));
		labelOfEnemyscore.setText("" + enemyScore);
		labelOfEnemyscore.setTextFill(Color.WHITE);
		labelOfEnemyscore.setAlignment(Pos.CENTER);
		background.getChildren().add(labelOfEnemyscore);
		
		myScoreBar = new ProgressBar();
		myScoreBar.setLayoutX(-180);
		myScoreBar.setLayoutY(550);
		myScoreBar.setRotate(-90);
		myScoreBar.setPrefHeight(30);
		myScoreBar.setPrefWidth(315);
		myScoreBar.setOpacity(0.75);
		myScoreBar.setStyle("-fx-accent:palegreen; -fx-control-inner-background:black;");
		background.getChildren().add(myScoreBar);
		
		enemyScoreBar = new ProgressBar();
		enemyScoreBar.setLayoutX(320 + 30);
		enemyScoreBar.setLayoutY(550);
		enemyScoreBar.setRotate(-90);
		enemyScoreBar.setPrefHeight(30);
		enemyScoreBar.setPrefWidth(315);
		enemyScoreBar.setOpacity(0.75);
		enemyScoreBar.setStyle("-fx-accent:palegreen; -fx-control-inner-background:black;");
		background.getChildren().add(enemyScoreBar);
		//end
		endBackImg = new ImageView(new Image(getClass().getResourceAsStream("data/endBack.png")));
		endBackImg.setLayoutX(0);
		endBackImg.setLayoutY(0);
		endBackImg.setFitWidth(480);
		endBackImg.setFitHeight(800);
		endBackImg.setVisible(false);
		endBackImg.setOpacity(0);
		background.getChildren().add(endBackImg);
		
		labelOfWin = new Label("WIN!!");
		labelOfWin.setPrefWidth(100);
		labelOfWin.setPrefHeight(35);
		labelOfWin.setVisible(false);
		labelOfWin.setOpacity(0);
		labelOfWin.setStyle("-fx-font-family:\"Berlin Sans FB Demi\"; -fx-font-weight:bold;");
		labelOfWin.setFont(new Font(30));
		labelOfWin.setTextFill(Color.WHITE);
		labelOfWin.setAlignment(Pos.CENTER);
		background.getChildren().add(labelOfWin);
		
		labelOfchallengeResult = new Label();
		labelOfchallengeResult.setLayoutX(97);
		labelOfchallengeResult.setLayoutY(359);
		labelOfchallengeResult.setPrefWidth(285);
		labelOfchallengeResult.setPrefHeight(82);
		labelOfchallengeResult.setTextFill(Color.WHITE);
		labelOfchallengeResult.setAlignment(Pos.CENTER);
		labelOfchallengeResult.setFont(new Font(60));
		labelOfchallengeResult.setStyle("-fx-font-weight:bold;");
		labelOfchallengeResult.setOpacity(0);
		labelOfchallengeResult.setVisible(false);
		background.getChildren().add(labelOfchallengeResult);
		
		loabelOfGold = new Label("金幣:");
		loabelOfGold.setLayoutX(145);
		loabelOfGold.setLayoutY(540);
		loabelOfGold.setTextFill(Color.WHITE);
		loabelOfGold.setFont(new Font(26));
		loabelOfGold.setOpacity(0);
		loabelOfGold.setVisible(false);
		background.getChildren().add(loabelOfGold);
		
		labelOfExp = new Label("經驗:");
		labelOfExp.setLayoutX(145);
		labelOfExp.setLayoutY(575);
		labelOfExp.setTextFill(Color.WHITE);
		labelOfExp.setFont(new Font(26));
		labelOfExp.setOpacity(0);
		labelOfExp.setVisible(false);
		background.getChildren().add(labelOfExp);
		
		labelOfMyplusGold = new Label();
		labelOfMyplusGold.setLayoutX(226);
		labelOfMyplusGold.setLayoutY(538);
		labelOfMyplusGold.setTextFill(Color.WHITE);
		labelOfMyplusGold.setFont(new Font(26));
		labelOfMyplusGold.setOpacity(0);
		labelOfMyplusGold.setVisible(false);
		labelOfMyplusGold.setStyle("-fx-font-family:\"Arial Black\";");
		background.getChildren().add(labelOfMyplusGold);
		
		labelOfMyplusExp = new Label();
		labelOfMyplusExp.setLayoutX(226);
		labelOfMyplusExp.setLayoutY(576);
		labelOfMyplusExp.setTextFill(Color.WHITE);
		labelOfMyplusExp.setFont(new Font(26));
		labelOfMyplusExp.setOpacity(0);
		labelOfMyplusExp.setVisible(false);
		labelOfMyplusExp.setStyle("-fx-font-family:\"Arial Black\";");
		background.getChildren().add(labelOfMyplusExp);
		
		findNewEnemyImg = new ImageView(new Image(getClass().getResourceAsStream("data/findNewEnemy.png")));
		findNewEnemyImg.setLayoutX(80);
		findNewEnemyImg.setLayoutY(675);
		findNewEnemyImg.setFitWidth(127);
		findNewEnemyImg.setFitHeight(70);
		findNewEnemyImg.setOpacity(0);
		findNewEnemyImg.setVisible(false);
		findNewEnemyImg.setOnMouseEntered(mouseEntered);
		findNewEnemyImg.setOnMouseExited(mouseExited);
		findNewEnemyImg.setOnMouseClicked(findOtherEnemyClicked);
		background.getChildren().add(findNewEnemyImg);
		
		endBackToHomeImg = new ImageView(new Image(getClass().getResourceAsStream("data/backToHome.png")));
		endBackToHomeImg.setLayoutX(285);
		endBackToHomeImg.setLayoutY(675);
		endBackToHomeImg.setFitWidth(127);
		endBackToHomeImg.setFitHeight(70);
		endBackToHomeImg.setOpacity(0);
		endBackToHomeImg.setVisible(false);
		endBackToHomeImg.setOnMouseEntered(mouseEntered);
		endBackToHomeImg.setOnMouseExited(mouseExited);
		endBackToHomeImg.setOnMouseClicked(endBackToHomeClicked);
		background.getChildren().add(endBackToHomeImg);
		//message
		messagePane = new Pane();
		messagePane.setLayoutX(112);
		messagePane.setLayoutY(-143);
		messagePane.setPrefWidth(274);
		messagePane.setPrefHeight(143);
		messagePane.setStyle("-fx-background-color: linear-gradient(to right top,#58c8ed,#ffffff);");
		background.getChildren().add(messagePane);
		
		labelOfKeyinMessage = new Label("對話");
		labelOfKeyinMessage.setLayoutX(109);
		labelOfKeyinMessage.setLayoutY(14);
		labelOfKeyinMessage.setPrefWidth(50);
		labelOfKeyinMessage.setPrefHeight(33);
		labelOfKeyinMessage.setFont(new Font(25));
		messagePane.getChildren().add(labelOfKeyinMessage);
		
		keyinMessage = new TextField();
		keyinMessage.setLayoutX(23);
		keyinMessage.setLayoutY(55);
		keyinMessage.setPrefWidth(230);
		keyinMessage.setPrefHeight(33);
		keyinMessage.setFont(new Font(15));
		keyinMessage.setAlignment(Pos.CENTER);
		messagePane.getChildren().add(keyinMessage);
		
		messagePassImg = new ImageView(new Image(getClass().getResourceAsStream("data/messagePass.png")));
		messagePassImg.setLayoutX(29);
		messagePassImg.setLayoutY(96);
		messagePassImg.setFitWidth(100);
		messagePassImg.setFitHeight(33);
		messagePassImg.setOnMouseEntered(mouseEntered);
		messagePassImg.setOnMouseExited(mouseExited);
		messagePane.getChildren().add(messagePassImg);
		
		messageCancelImg = new ImageView(new Image(getClass().getResourceAsStream("data/messageCancel.png")));
		messageCancelImg.setLayoutX(148);
		messageCancelImg.setLayoutY(96);
		messageCancelImg.setFitWidth(100);
		messageCancelImg.setFitHeight(33);
		messageCancelImg.setOnMouseEntered(mouseEntered);
		messageCancelImg.setOnMouseExited(mouseExited);
		messagePane.getChildren().add(messageCancelImg);
		
		myMessageText = new TextField();
		myMessageText.setLayoutX(15);
		myMessageText.setLayoutY(280);
		myMessageText.setPrefWidth(165);
		myMessageText.setFont(new Font(15));
		myMessageText.setStyle("-fx-background-radius: 50;");
		myMessageText.setOpacity(0);
		myMessageText.setVisible(false);
		myMessageText.setEditable(false);
		myMessageText.setFocusTraversable(false);
		background.getChildren().add(myMessageText);
		
		enemyMessageText = new TextField();
		enemyMessageText.setLayoutX(300);
		enemyMessageText.setLayoutY(270);
		enemyMessageText.setPrefWidth(165);
		enemyMessageText.setFont(new Font(15));
		enemyMessageText.setStyle("-fx-background-radius: 50;");
		enemyMessageText.setOpacity(0);
		enemyMessageText.setVisible(false);
		enemyMessageText.setEditable(false);
		enemyMessageText.setFocusTraversable(false);
		background.getChildren().add(enemyMessageText);
	}
	
	public static Timeline forTimer = new Timeline(new KeyFrame(Duration.seconds(1), (event)->{
		timer = timer + 1;
		labelOfTimer.setText("" + timer);
	}));
	
	public static EventHandler<MouseEvent> mouseEntered = (e)->{
		ImageView ImgTemp = (ImageView)e.getSource();
		ClientMain.mainStage.getScene().setCursor(Cursor.HAND);
		Glow glow = new Glow(0);
		ImgTemp.setEffect(glow);
		
		Timeline glowUp = new Timeline(new KeyFrame(Duration.millis(50), (glowEvent)->{
			glow.setLevel(glow.getLevel() + 0.15);
		}));
		glowUp.setCycleCount(5);
		glowUp.play();
	};
	
	public static EventHandler<MouseEvent> mouseExited = (e)->{
		ImageView ImgTemp = (ImageView)e.getSource();
		ClientMain.mainStage.getScene().setCursor(Cursor.DEFAULT);
		Glow glow = new Glow(0.75);
		ImgTemp.setEffect(glow);
		
		Timeline glowDown = new Timeline(new KeyFrame(Duration.millis(50), (glowEvent)->{
			glow.setLevel(glow.getLevel() - 0.15);
		}));
		glowDown.setCycleCount(5);
		glowDown.play();
	};
	
	public static EventHandler<MouseEvent> optionEntered = (e)->{
		ClientMain.mainStage.getScene().setCursor(Cursor.HAND);
	};
	
	public static EventHandler<MouseEvent> optionExited = (e)->{
		ClientMain.mainStage.getScene().setCursor(Cursor.DEFAULT);
	};
	
	public EventHandler<MouseEvent> profileClicked = (e)->{
		background.getChildren().add(profilePane);
		Timeline appear = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
			profilePane.setOpacity(profilePane.getOpacity() + 0.1);
			myName.setOpacity(myName.getOpacity() + 0.1);
			myCharacter.setOpacity(myCharacter.getOpacity() + 0.1);
			backImg.setOpacity(backImg.getOpacity() + 0.1);
		}));
		appear.setCycleCount(10);
		appear.play();
	};
	
	public EventHandler<MouseEvent> nameClicked = (e) ->{
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	messagePane.toFront();
		    	labelOfKeyinMessage.setText("");
		    	keyinMessage.setText(account.getName());
		    	messagePassImg.setOnMouseClicked(changeNameClicked);
		    	messageCancelImg.setOnMouseClicked(changeNameCancelClicked);
				Timeline messageDown = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
					messagePane.setLayoutY(messagePane.getLayoutY() + 62.5);
				}));
				Timeline messageUp = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
					messagePane.setLayoutY(messagePane.getLayoutY() - 15);
				}));
				messageDown.setCycleCount(8);
				messageDown.play();
				messageUp.setCycleCount(2);
				messageUp.setDelay(Duration.millis(400));
				messageUp.play();
				BufferedWriter output;
				try {
					output = new BufferedWriter(new OutputStreamWriter(ClientMain.clientSocket.getOutputStream(), "Cp950"));
					output.write("C " + account.forPassenge());
					output.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		});
	};
	
	public EventHandler<MouseEvent> changeNameClicked = (e)->{
		String message = keyinMessage.getText();
		if(!message.equals("")) {
			keyinMessage.setText("");
			account.setName(message);
			myName.setText(message);
			labelOfName.setText(message);
			Timeline messageUp = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
				messagePane.setLayoutY(messagePane.getLayoutY() - 58.875);
			}));
			messageUp.setCycleCount(8);
			messageUp.play();
			
			try {
				BufferedWriter output = new BufferedWriter(new OutputStreamWriter(ClientMain.clientSocket.getOutputStream(), "Cp950"));
				output.write("C " + account.forPassenge());
				output.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	};

	public EventHandler<MouseEvent> changeNameCancelClicked = (e)->{
			keyinMessage.setText("");
			Timeline messageUp = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
				messagePane.setLayoutY(messagePane.getLayoutY() - 58.875);
			}));
			messageUp.setCycleCount(8);
			messageUp.play();
	};
	
	public EventHandler<MouseEvent> profileBackClicked = (e)->{
		Timeline Fade = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
			profilePane.setOpacity(profilePane.getOpacity() - 0.1);
			myName.setOpacity(myName.getOpacity() - 0.1);
			myCharacter.setOpacity(myCharacter.getOpacity() - 0.1);
			backImg.setOpacity(backImg.getOpacity() - 0.1);
			if(backImg.getOpacity() < 0.2) {
				background.getChildren().remove(profilePane);
			}
		}));
		Fade.setCycleCount(10);
		Fade.play();
	};

	public EventHandler<MouseEvent> backToHomeClicked = (e)->{
		profileImg.setLayoutX(15 - 480);
		challengeImg.setLayoutX(15 - 480);
		bankImg.setLayoutX(15 - 480);
		Timeline backToHome = new Timeline(new KeyFrame(Duration.millis(30), (moveEvent)->{
			profileImg.setLayoutX(profileImg.getLayoutX() + 48);
			challengeImg.setLayoutX(challengeImg.getLayoutX() + 48);
			bankImg.setLayoutX(bankImg.getLayoutX() + 48);
			challengeBackToHomeImg.setLayoutX(challengeBackToHomeImg.getLayoutX() + 48);
			checkpoint1Img.setLayoutX(checkpoint1Img.getLayoutX() + 48);
			checkpoint2Img.setLayoutX(checkpoint2Img.getLayoutX() + 48);
			checkpoint3Img.setLayoutX(checkpoint3Img.getLayoutX() + 48);
			checkpoint4Img.setLayoutX(checkpoint4Img.getLayoutX() + 48);
		}));
		backToHome.setCycleCount(10);
		backToHome.play();
	};

	public EventHandler<MouseEvent> challengeClicked = (e)->{
		Timeline changeToCheckpoint = new Timeline(new KeyFrame(Duration.millis(30), (moveEvent)->{
			profileImg.setLayoutX(profileImg.getLayoutX() - 48);
			challengeImg.setLayoutX(challengeImg.getLayoutX() - 48);
			bankImg.setLayoutX(bankImg.getLayoutX() - 48);
			challengeBackToHomeImg.setLayoutX(challengeBackToHomeImg.getLayoutX() - 48);
			checkpoint1Img.setLayoutX(checkpoint1Img.getLayoutX() - 48);
			checkpoint2Img.setLayoutX(checkpoint2Img.getLayoutX() - 48);
			checkpoint3Img.setLayoutX(checkpoint3Img.getLayoutX() - 48);
			checkpoint4Img.setLayoutX(checkpoint4Img.getLayoutX() - 48);
		}));
		changeToCheckpoint.setCycleCount(10);
		changeToCheckpoint.play();
	};
	
	public EventHandler<MouseEvent> anyCheckpointClicked = (e)->{
		labelOfLevel.setOpacity(1);
		barOfExp.setOpacity(1);
		labelOfName.setOpacity(1);
		textOfMoney.setOpacity(1);
		searchingBackImg.setVisible(true);
		labelOfSearching.setVisible(true);
		deletSearchingImg.setVisible(true);
		labelOfTimer.setVisible(true);
		deletSearchingImg.setOpacity(0);
		searchingBackImg.setOpacity(0);
		labelOfSearching.setOpacity(0);
		labelOfTimer.setOpacity(0);
		timer = 0;
		labelOfTimer.setText("" + timer);
		labelOfTimer.setLayoutX(200);
		labelOfTimer.setLayoutY(375);
		
		Timeline startSearch = new Timeline(new KeyFrame(Duration.millis(30), (moveEvent)->{
			challengeBackToHomeImg.setLayoutX(challengeBackToHomeImg.getLayoutX() - 48);
			checkpoint1Img.setLayoutX(checkpoint1Img.getLayoutX() - 48);
			checkpoint2Img.setLayoutX(checkpoint1Img.getLayoutX() - 48);
			checkpoint3Img.setLayoutX(checkpoint1Img.getLayoutX() - 48);
			checkpoint4Img.setLayoutX(checkpoint1Img.getLayoutX() - 48);
			labelOfLevel.setOpacity(labelOfLevel.getOpacity() - 0.05);
			barOfExp.setOpacity(barOfExp.getOpacity() - 0.05);
			labelOfName.setOpacity(labelOfName.getOpacity() - 0.05);
			textOfMoney.setOpacity(textOfMoney.getOpacity() - 0.05);
			searchingBackImg.setOpacity(searchingBackImg.getOpacity() + 0.05);
			labelOfSearching.setOpacity(labelOfSearching.getOpacity() + 0.05);
			deletSearchingImg.setOpacity(deletSearchingImg.getOpacity() + 0.05);
			labelOfTimer.setOpacity(labelOfTimer.getOpacity() + 0.05);
		}));
		
		startSearch.setCycleCount(20);
		startSearch.play();
		forTimer.setCycleCount(Timeline.INDEFINITE);
		forTimer.play();
		
		try {
			if(e.getSource().equals(checkpoint1Img)) {
				checkpointNumber = 1;
				checkpointBackImg = new ImageView(new Image(getClass().getResourceAsStream("data/checkpoint1Back.png")));
				setTime = 10;
				finalQuestionNumber = 4;
				gotGold = 25;
				gotExp = 3;
			}
			else if(e.getSource().equals(checkpoint2Img)) {
				checkpointNumber = 2;
				checkpointBackImg = new ImageView(new Image(getClass().getResourceAsStream("data/checkpoint2Back.png")));
				setTime = 10;
				finalQuestionNumber = 5;
				gotGold = 100;
				gotExp = 10;
			}
			else if(e.getSource().equals(checkpoint3Img)) {
				checkpointNumber = 3;
				checkpointBackImg = new ImageView(new Image(getClass().getResourceAsStream("data/checkpoint3Back.png")));
				setTime = 8;
				finalQuestionNumber = 6;
				gotGold = 1200;
				gotExp = 30;
			}
			else if(e.getSource().equals(checkpoint4Img)) {
				checkpointNumber = 4;
				checkpointBackImg = new ImageView(new Image(getClass().getResourceAsStream("data/checkpoint4Back.png")));
				setTime = 8;
				finalQuestionNumber = 6;
				gotGold = 8000;
				gotExp = 100;
			}
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(ClientMain.clientSocket.getOutputStream(), "Cp950"));
			output.write(new String("searching" + checkpointNumber));
			output.flush();
			
			myScore = 0;
			enemyScore = 0;
			myNumberOfAC = 0;
			myScoreBar.setProgress(0);
			enemyScoreBar.setProgress(0);
			fullScore = (finalQuestionNumber-1)*200 + 400;
			checkpointBackImg.setLayoutX(0 - 120);
			checkpointBackImg.setLayoutY(0);
			checkpointBackImg.setFitWidth(720);
			checkpointBackImg.setFitHeight(1200);
			checkpointBackImg.setOpacity(0);
			background.getChildren().add(checkpointBackImg);
			checkpointBackImg.toBack();
			
			Thread task = new Thread(new readTask(ClientMain.clientSocket.getOutputStream(), ClientMain.clientSocket.getInputStream()));
			task.start();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	};
	
	public EventHandler<MouseEvent> deletSearchClicked = (e)->{
		forTimer.stop();
		labelOfLevel.setOpacity(0);
		barOfExp.setOpacity(0);
		labelOfName.setOpacity(0);
		textOfMoney.setOpacity(0);
		profileImg.setLayoutX(15);
		challengeImg.setLayoutX(15);
		bankImg.setLayoutX(15);
		challengeBackToHomeImg.setLayoutX(5 + 480);
		checkpoint1Img.setLayoutX(5 + 480);
		checkpoint2Img.setLayoutX(5 + 480);
		checkpoint3Img.setLayoutX(5 + 480);
		checkpoint4Img.setLayoutX(5 + 480);
		
		Timeline changeToHome = new Timeline(new KeyFrame(Duration.millis(30), (moveEvent)->{
			labelOfLevel.setOpacity(labelOfLevel.getOpacity() + 0.05);
			barOfExp.setOpacity(barOfExp.getOpacity() + 0.05);
			labelOfName.setOpacity(labelOfName.getOpacity() + 0.05);
			textOfMoney.setOpacity(textOfMoney.getOpacity() + 0.05);
			searchingBackImg.setOpacity(searchingBackImg.getOpacity() - 0.05);
			labelOfSearching.setOpacity(labelOfSearching.getOpacity() - 0.05);
			deletSearchingImg.setOpacity(deletSearchingImg.getOpacity() - 0.05);
			labelOfTimer.setOpacity(labelOfTimer.getOpacity() - 0.05);
			if(searchingBackImg.getOpacity() < 0) {
				searchingBackImg.setVisible(false);
				labelOfSearching.setVisible(false);
				deletSearchingImg.setVisible(false);
				labelOfTimer.setVisible(false);
			}
		}));
		changeToHome.setCycleCount(20);
		changeToHome.play();
		
		//send message to server let searching interrupt
		try {
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(ClientMain.clientSocket.getOutputStream(), "Cp950"));
			String str = new String("interruptSearching");
			output.write(str);
			output.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	};
	
	public static EventHandler<MouseEvent> optionClicked = (e)->{
		answered = true;
		if(e.getSource().equals(BtnArr[correctAnswer])) {
			myNumberOfAC++;
			if(questionNumber != finalQuestionNumber) {
				myDifference = timer*20;
			}
			else {
				myDifference = timer*40;
			}
			Timeline getpoint = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
				myScore = myScore + myDifference/10;
				labelOfMyscore.setText("" + myScore);
				myScoreBar.setProgress((double)myScore/fullScore);
				((Button)e.getSource()).setStyle("-fx-background-color:mediumspringgreen; -fx-background-radius:10; -fx-font-weight:bold; -fx-font-fill:#262424; -fx-font-size:32;");
			}));
			
			getpoint.setCycleCount(10);
			getpoint.setDelay(Duration.millis(300));
			getpoint.play();
		}
		else {
			Pane alertPane = new Pane();
			alertPane.setLayoutX(0);
			alertPane.setLayoutY(0);
			alertPane.setPrefWidth(480);
			alertPane.setPrefHeight(800);
			alertPane.setOpacity(0);
			alertPane.setStyle("-fx-background-color:red;");
			background.getChildren().add(alertPane);
			
			Timeline backAppear = new Timeline(new KeyFrame(Duration.millis(15), (event)->{
				alertPane.setOpacity(alertPane.getOpacity() + 0.1);
			}));
			Timeline backFade = new Timeline(new KeyFrame(Duration.millis(30), (event)->{
				alertPane.setOpacity(alertPane.getOpacity() - 0.1);
				if(alertPane.getOpacity() < 0.2) {
					background.getChildren().remove(alertPane);
				}
				((Button)e.getSource()).setStyle("-fx-background-color:red; -fx-background-radius:10; -fx-font-weight:bold; -fx-font-fill:#262424; -fx-font-size:32;");
			}));
			
			backAppear.setCycleCount(10);
			backAppear.play();
			backFade.setCycleCount(10);
			backFade.setDelay(Duration.millis(300));
			backFade.play();
		}
		
		for(int i=1;i<5;i++) {
			BtnArr[i].setOnMouseEntered(optionExited);
			BtnArr[i].setOnMouseClicked(null);
		}
		
		try {
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(ClientMain.clientSocket.getOutputStream(), "Cp950"));
			String str = null;
			for(int i=1;i<5;i++) {
				if(e.getSource().equals(BtnArr[i])) {
					str = "O" + i;
				}
			}
			output.write(new String(str));
			output.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	};
	
	public static EventHandler<MouseEvent> endBackToHomeClicked = (e)->{
		try {
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(ClientMain.clientSocket.getOutputStream(), "Cp950"));
			output.write("disconnect");
			output.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Timeline endFade = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
			endBackImg.setOpacity(endBackImg.getOpacity() - 0.05);
			labelOfWin.setOpacity(labelOfWin.getOpacity() - 0.05);
			labelOfchallengeResult.setOpacity(labelOfchallengeResult.getOpacity() - 0.05);
			loabelOfGold.setOpacity(loabelOfGold.getOpacity() - 0.05);
			labelOfExp.setOpacity(labelOfExp.getOpacity() - 0.05);
			labelOfMyplusGold.setOpacity(labelOfMyplusGold.getOpacity() - 0.05);
			labelOfMyplusExp.setOpacity(labelOfMyplusExp.getOpacity() - 0.05);
			findNewEnemyImg.setOpacity(findNewEnemyImg.getOpacity() - 0.05);
			endBackToHomeImg.setOpacity(endBackToHomeImg.getOpacity() - 0.05);
			labelOfMyname.setOpacity(labelOfMyname.getOpacity() - 0.05);
			labekOfEnemyName.setOpacity(labekOfEnemyName.getOpacity() - 0.05);
			myCharacterHeadImg.setOpacity(myCharacterHeadImg.getOpacity() - 0.05);
			enemyCharacterHeadImg.setOpacity(enemyCharacterHeadImg.getOpacity() - 0.05);
			
			if(endBackToHomeImg.getOpacity() < 0.05) {
				endBackImg.setVisible(false);
				labelOfWin.setVisible(false);
				labelOfchallengeResult.setVisible(false);
				loabelOfGold.setVisible(false);
				labelOfExp.setVisible(false);
				labelOfMyplusGold.setVisible(false);
				labelOfMyplusExp.setVisible(false);
				findNewEnemyImg.setVisible(false);
				endBackToHomeImg.setVisible(false);
				labelOfMyname.setLayoutX(360 + 480);
				labelOfMyname.setLayoutY(250);
				labelOfMyname.setOpacity(1);
				labekOfEnemyName.setLayoutX(100 - 480);
				labekOfEnemyName.setLayoutY(690);
				labekOfEnemyName.setOpacity(1);
				background.getChildren().remove(myCharacterHeadImg);
				background.getChildren().remove(enemyCharacterHeadImg);
				background.getChildren().remove(myCharacterImg);
				background.getChildren().remove(enemyCharacterImg);
			}
		}));
		endFade.setCycleCount(20);
		endFade.play();
	};
	
	public static EventHandler<MouseEvent> findOtherEnemyClicked = (e)->{
		try {
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(ClientMain.clientSocket.getOutputStream(), "Cp950"));
			output.write("disconnect");
			output.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		profileImg.setLayoutX(15);
		challengeImg.setLayoutX(15);
		bankImg.setLayoutX(15);
		labelOfLevel.setOpacity(1);
		barOfExp.setOpacity(1);
		labelOfName.setOpacity(1);
		textOfMoney.setOpacity(1);
		searchingBackImg.setVisible(true);
		labelOfSearching.setVisible(true);
		deletSearchingImg.setVisible(true);
		labelOfTimer.setVisible(true);
		searchingBackImg.setVisible(true);
		labelOfSearching.setVisible(true);
		deletSearchingImg.setVisible(true);
		deletSearchingImg.setOpacity(0);
		searchingBackImg.setOpacity(0);
		labelOfSearching.setOpacity(0);
		labelOfTimer.setOpacity(0);
		timer = 0;
		labelOfTimer.setText("" + timer);
		labelOfTimer.setLayoutX(200);
		labelOfTimer.setLayoutY(375);
		profileImg.setLayoutX(15 - 480);
		challengeImg.setLayoutX(15 - 480);
		bankImg.setLayoutX(15 - 480);
		
		Timeline startSearch = new Timeline(new KeyFrame(Duration.millis(30), (moveEvent)->{
			labelOfLevel.setOpacity(labelOfLevel.getOpacity() - 0.05);
			barOfExp.setOpacity(barOfExp.getOpacity() - 0.05);
			labelOfName.setOpacity(labelOfName.getOpacity() - 0.05);
			textOfMoney.setOpacity(textOfMoney.getOpacity() - 0.05);
			searchingBackImg.setOpacity(searchingBackImg.getOpacity() + 0.05);
			labelOfSearching.setOpacity(labelOfSearching.getOpacity() + 0.05);
			deletSearchingImg.setOpacity(deletSearchingImg.getOpacity() + 0.05);
			labelOfTimer.setOpacity(labelOfTimer.getOpacity() + 0.05);
		}));
		Timeline endFade = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
			endBackImg.setOpacity(endBackImg.getOpacity() - 0.05);
			labelOfWin.setOpacity(labelOfWin.getOpacity() - 0.05);
			labelOfchallengeResult.setOpacity(labelOfchallengeResult.getOpacity() - 0.05);
			loabelOfGold.setOpacity(loabelOfGold.getOpacity() - 0.05);
			labelOfExp.setOpacity(labelOfExp.getOpacity() - 0.05);
			labelOfMyplusGold.setOpacity(labelOfMyplusGold.getOpacity() - 0.05);
			labelOfMyplusExp.setOpacity(labelOfMyplusExp.getOpacity() - 0.05);
			findNewEnemyImg.setOpacity(findNewEnemyImg.getOpacity() - 0.05);
			endBackToHomeImg.setOpacity(endBackToHomeImg.getOpacity() - 0.05);
			labelOfMyname.setOpacity(labelOfMyname.getOpacity() - 0.05);
			labekOfEnemyName.setOpacity(labekOfEnemyName.getOpacity() - 0.05);
			myCharacterHeadImg.setOpacity(myCharacterHeadImg.getOpacity() - 0.05);
			enemyCharacterHeadImg.setOpacity(enemyCharacterHeadImg.getOpacity() - 0.05);
			
			if(labelOfMyplusGold.getOpacity() < 0.05) {
				endBackImg.setVisible(false);
				labelOfWin.setVisible(false);
				labelOfchallengeResult.setVisible(false);
				loabelOfGold.setVisible(false);
				labelOfExp.setVisible(false);
				labelOfMyplusGold.setVisible(false);
				labelOfMyplusExp.setVisible(false);
				findNewEnemyImg.setVisible(false);
				endBackToHomeImg.setVisible(false);
				labelOfMyname.setLayoutX(360 + 480);
				labelOfMyname.setLayoutY(250);
				labelOfMyname.setOpacity(1);
				labekOfEnemyName.setLayoutX(100 - 480);
				labekOfEnemyName.setLayoutY(690);
				labekOfEnemyName.setOpacity(1);
				background.getChildren().remove(myCharacterHeadImg);
				background.getChildren().remove(enemyCharacterHeadImg);
				background.getChildren().remove(myCharacterImg);
				background.getChildren().remove(enemyCharacterImg);
			}
		}));
		
		startSearch.setCycleCount(20);
		startSearch.play();
		endFade.setCycleCount(20);
		endFade.play();
		forTimer.setCycleCount(Timeline.INDEFINITE);
		forTimer.play();
		
		if(checkpointNumber == 1) {
			checkpointNumber = 1;
			checkpointBackImg = new ImageView(new Image(ClientMain.class.getResourceAsStream("data/checkPoint1Back.png")));
			setTime = 10;
			finalQuestionNumber = 4;
			gotGold = 25;
			gotExp = 3;
		}
		else if(checkpointNumber == 2) {
			checkpointNumber = 2;
			checkpointBackImg = new ImageView(new Image(ClientMain.class.getResourceAsStream("data/checkpoint2Back.png")));
			setTime = 10;
			finalQuestionNumber = 5;
			gotGold = 100;
			gotExp = 10;
		}
		else if(checkpointNumber == 3) {
			checkpointNumber = 3;
			checkpointBackImg = new ImageView(new Image(ClientMain.class.getResourceAsStream("data/checkpoint3Back.png")));
			setTime = 8;
			finalQuestionNumber = 6;
			gotGold = 1200;
			gotExp = 30;
		}
		else if(checkpointNumber == 4) {
			checkpointNumber = 4;
			checkpointBackImg = new ImageView(new Image(ClientMain.class.getResourceAsStream("data/checkpoint4Back.png")));
			setTime = 8;
			finalQuestionNumber = 6;
			gotGold = 8000;
			gotExp = 100;
		}
		
		myScore = 0;
		enemyScore = 0;
		myNumberOfAC = 0;
		myScoreBar.setProgress(0);
		enemyScoreBar.setProgress(0);
		fullScore = (finalQuestionNumber-1)*200 + 400;
		checkpointBackImg.setLayoutX(0 - 120);
		checkpointBackImg.setLayoutY(0);
		checkpointBackImg.setFitWidth(720);
		checkpointBackImg.setFitHeight(1200);
		checkpointBackImg.setOpacity(0);
		background.getChildren().add(checkpointBackImg);
		checkpointBackImg.toBack();
		
		Thread task;
		try {
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(ClientMain.clientSocket.getOutputStream(), "Cp950"));
			output.write(new String("searching" + checkpointNumber));
			output.flush();
			task = new Thread(new readTask(ClientMain.clientSocket.getOutputStream(), ClientMain.clientSocket.getInputStream()));
			task.start();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	};
	
	public static EventHandler<MouseEvent> headImgClicked = (e)->{
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	labelOfKeyinMessage.setText("對話");
		    	keyinMessage.setText("");
		    	messagePassImg.setOnMouseClicked(messagePassClicked);
		    	messageCancelImg.setOnMouseClicked(messageCancelClicked);
				Timeline messageDown = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
					messagePane.setLayoutY(messagePane.getLayoutY() + 62.5);
				}));
				Timeline messageUp = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
					messagePane.setLayoutY(messagePane.getLayoutY() - 15);
				}));
				messageDown.setCycleCount(8);
				messageDown.play();
				messageUp.setCycleCount(2);
				messageUp.setDelay(Duration.millis(400));
				messageUp.play();
		    }
		});
		
	};

	public static EventHandler<MouseEvent> messagePassClicked = (e)->{
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	String message = keyinMessage.getText();
				if(!message.equals("")) {
					keyinMessage.setText("");
					myMessageText.setText(message);
					myMessageText.setVisible(true);
					myMessageText.setOpacity(0);
					Timeline messageUp = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
						messagePane.setLayoutY(messagePane.getLayoutY() - 58.875);
					}));
					Timeline messageAppear = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
						myMessageText.setOpacity(myMessageText.getOpacity() + 0.1);
					}));
					Timeline messageFade = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
						myMessageText.setOpacity(myMessageText.getOpacity() - 0.1);
						if(myMessageText.getOpacity() < 0.1) {
							myMessageText.setVisible(false);
						}
					}));
					messageUp.setCycleCount(8);
					messageUp.play();
					messageAppear.setCycleCount(10);
					messageAppear.setDelay(Duration.millis(200));
					messageAppear.play();
					messageFade.setCycleCount(10);
					messageFade.setDelay(Duration.millis(3700));
					messageFade.play();
					
					try {
						BufferedWriter output = new BufferedWriter(new OutputStreamWriter(ClientMain.clientSocket.getOutputStream(), "Cp950"));
						output.write("M " + message);
						output.flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
		    }
		});
	};
	
	public static EventHandler<MouseEvent> messageCancelClicked = (e)->{
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	keyinMessage.setText("");
				Timeline messageUp = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
					messagePane.setLayoutY(messagePane.getLayoutY() - 58.875);
				}));
				messageUp.setCycleCount(8);
				messageUp.play();
		    }
		});
	};
	
	public static EventHandler<MouseEvent> anyCharacterlClicked = (e)->{
		for(int i=0;i<profilePane.getChildren().size();i++) {
			if(e.getSource().equals(profilePane.getChildren().get(i))) {
				account.setCharacter(i+1);
			}
		}
		profilePane.getChildren().clear();
		profilePane.getChildren().addAll(myName, myCharacter, backImg);
		myCharacter.setImage(new Image(Gaming.class.getResourceAsStream("data/character" + account.getCharacter() + ".png")));
		for(int i=0;i<profilePane.getChildren().size();i++) {
			profilePane.getChildren().get(i).setOpacity(0);
		}
		Timeline appear = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
			for(int i=0;i<profilePane.getChildren().size();i++) {
				profilePane.getChildren().get(i).setOpacity(profilePane.getChildren().get(i).getOpacity() + 0.1);
			}
		}));
		appear.setCycleCount(10);
		appear.play();
		
		try {
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(ClientMain.clientSocket.getOutputStream(), "Cp950"));
			output.write("C " + account.forPassenge());
			output.flush();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
	};
	
	public static EventHandler<MouseEvent> myCharacterlClicked = (e)->{
		profilePane.getChildren().clear();
		for(int i=1;i<=8;i++) {
			ImageView head = new ImageView(new Image(Gaming.class.getResourceAsStream("data/character" + i + "HeadS.png")));
			head.setFitHeight(120);
			head.setFitWidth(120);
			head.setOpacity(0);
			head.setOnMouseEntered(optionEntered);
			head.setOnMouseExited(optionExited);
			head.setOnMouseClicked(anyCharacterlClicked);
			profilePane.getChildren().add(head);
		}
		double x = 40;
		double y = 20;
		for(int i=0;i<=3;i++) {
			for(int j=0;j<=1;j++) {
				profilePane.getChildren().get(i*2+j).setLayoutX(x);
				profilePane.getChildren().get(i*2+j).setLayoutY(y);
				x = x + 150;
			}
			y = y + 150;
			x = 40;
		}
		
		Timeline appear = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
			for(int i=0;i<8;i++) {
				profilePane.getChildren().get(i).setOpacity(profilePane.getChildren().get(i).getOpacity() + 0.1);
			}
		}));
		appear.setCycleCount(10);
		appear.play();
	};
	
	private static class readTask implements Runnable{
		private BufferedWriter output = null;
		private BufferedReader input = null; 
		
		public readTask(OutputStream out, InputStream in) throws IOException {
			output = new BufferedWriter(new OutputStreamWriter(out, "Cp950"));
			input = new BufferedReader(new InputStreamReader(in, "Cp950"));
		}

		@Override
		public void run() {
			char[] buf = new char[1024];
			int length = 0;
			String str = null;
			try {
				//let server know is searching
				while(true) {
					length = input.read(buf);
					str = new String(buf, 0, length);
					System.out.println(str);
					if(str.charAt(0) == 'c') {
						//connect success
						str = "N " + account.getName() + " " + account.getCharacter();
						output.write(str);
						output.flush();
					}
					else if(str.equals("interruptSearching")) {
						break;
					}
					else if(str.charAt(0) == 'N') { 
						//get enemyName
						String[] data = str.split(" ");
						enemyName = data[1];
						enemyCharacter = Integer.parseInt(data[2]);
						Platform.runLater(new Runnable() {
						    @Override
						    public void run() {
						    	forTimer.stop();
						        labekOfEnemyName.setText(enemyName);
						        //start answer
						        answerTask();
						    }
						});
					}
					else if(str.charAt(0) == 'O') {
						//get enemy Option
						instruction = str;
						Platform.runLater(new Runnable() {
						    @Override
						    public void run() {
						        enemyOption();
						    }
						});
					}
					else if(str.charAt(0) == 'Q') {
						//set question
						question = str;
						Platform.runLater(new Runnable() {
						    @Override
						    public void run() {
						        setQuestion();
						    }
						});
					}
					else if(str.equals("disconnect")) {
						break;
					}
					else if(str.charAt(0) == 'M') {
						enemyMessage = str;
						Platform.runLater(new Runnable() {
						    @Override
						    public void run() {
						        enemyMessage();
						    }
						});
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private static void answerTask() {
		labelOfMyname.setVisible(true);
		labekOfEnemyName.setVisible(true);
		backTopImg.setVisible(true);
		backDownImg.setVisible(true);
		myCharacterImg = new ImageView (new Image(new ClientMain().getClass().getResourceAsStream("data/character" + account.getCharacter() + ".png")));
		myCharacterImg.setLayoutX(50 - 480);
		myCharacterImg.setLayoutY(50);
		myCharacterImg.setFitHeight(370);
		myCharacterImg.setFitWidth(166);
		background.getChildren().add(myCharacterImg);
		
		enemyCharacterImg = new ImageView (new Image(new ClientMain().getClass().getResourceAsStream("data/character" + enemyCharacter + ".png")));
		enemyCharacterImg.setLayoutX(320 + 480);
		enemyCharacterImg.setLayoutY(450);
		enemyCharacterImg.setFitHeight(370);
		enemyCharacterImg.setFitWidth(166);
		background.getChildren().add(enemyCharacterImg);
		
		myCharacterHeadImg = new ImageView (new Image(new ClientMain().getClass().getResourceAsStream("data/character" + account.getCharacter() + "Head.png")));
		myCharacterHeadImg.setLayoutX(330 + 480);
		myCharacterHeadImg.setLayoutY(150);
		myCharacterHeadImg.setFitHeight(129);
		myCharacterHeadImg.setFitWidth(100);
		background.getChildren().add(myCharacterHeadImg);
		
		enemyCharacterHeadImg = new ImageView (new Image(new ClientMain().getClass().getResourceAsStream("data/character" + enemyCharacter + "Head.png")));
		enemyCharacterHeadImg.setLayoutX(75 - 480);
		enemyCharacterHeadImg.setLayoutY(590);
		enemyCharacterHeadImg.setFitHeight(129);
		enemyCharacterHeadImg.setFitWidth(100);
		background.getChildren().add(enemyCharacterHeadImg);
		
		labelOfMyname.toFront();
		labelOfMyname.setLayoutX(360 + 480);
		labelOfMyname.setLayoutY(250);
		labekOfEnemyName.toFront();
		labekOfEnemyName.setLayoutX(100 - 480);
		labekOfEnemyName.setLayoutY(690);
		labelOfMyscore.setVisible(true);
		labelOfEnemyscore.setVisible(true);
		labelOfQuestionNumber.setVisible(true);
		labelOfQuestion.setVisible(true);
		option1Btn.setVisible(true);
		option2Btn.setVisible(true);
		option3Btn.setVisible(true);
		option4Btn.setVisible(true);
		myMessageText.setLayoutX(15);
		myMessageText.setLayoutY(165);
		enemyMessageText.setLayoutX(315);
		enemyMessageText.setLayoutY(165);
		
		Label pointLabel = new Label();
		pointLabel.setLayoutX(180);
		pointLabel.setLayoutY(380);
		pointLabel.setPrefHeight(40);
		pointLabel.setPrefWidth(120);
		pointLabel.setText("0");
		pointLabel.setFont(new Font(24));
		pointLabel.setAlignment(Pos.CENTER);
		pointLabel.setStyle("-fx-background-color:white; -fx-background-radius:5; -fx-font-weight:bold;");
		pointLabel.setOpacity(0);
		background.getChildren().add(pointLabel);
		
		//setTimeline
		Timeline viaScene = new Timeline(new KeyFrame(Duration.millis(30), (event)->{
			labelOfTimer.setOpacity(labelOfTimer.getOpacity() - 0.025);
			searchingBackImg.setOpacity(searchingBackImg.getOpacity() - 0.025);
			labelOfSearching.setOpacity(labelOfSearching.getOpacity() - 0.025);
			deletSearchingImg.setOpacity(deletSearchingImg.getOpacity() - 0.025);
			if(searchingBackImg.getOpacity() < 0) {
				searchingBackImg.setVisible(false);
				labelOfSearching.setVisible(false);
				deletSearchingImg.setVisible(false);
			}
		}));
		Timeline movein = new Timeline(new KeyFrame(Duration.millis(30), (event)->{
			labelOfMyname.setLayoutX(labelOfMyname.getLayoutX() - 12);
			labekOfEnemyName.setLayoutX(labekOfEnemyName.getLayoutX() + 12);
			backTopImg.setLayoutX(backTopImg.getLayoutX() + 12);
			backDownImg.setLayoutX(backDownImg.getLayoutX() - 12);
			myCharacterImg.setLayoutX(myCharacterImg.getLayoutX() + 12);
			enemyCharacterImg.setLayoutX(enemyCharacterImg.getLayoutX() - 12);
			myCharacterHeadImg.setLayoutX(myCharacterHeadImg.getLayoutX() - 12);
			enemyCharacterHeadImg.setLayoutX(enemyCharacterHeadImg.getLayoutX() + 12);
		}));
		Timeline backAppear = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
			pointLabel.setOpacity(pointLabel.getOpacity() + 0.1);
			checkpointBackImg.setOpacity(checkpointBackImg.getOpacity() + 0.1);
		}));
		Timeline forPointLabel = new Timeline(new KeyFrame(Duration.millis(40), (event)->{
			pointLabel.setText(Integer.parseInt(pointLabel.getText()) + 2*gotGold/25 + "");
		}));
		Timeline toAnswerScene = new Timeline(new KeyFrame(Duration.millis(30), (event)->{
			checkpointBackImg.setLayoutX(checkpointBackImg.getLayoutX() + 3);
			checkpointBackImg.setFitWidth(checkpointBackImg.getFitWidth() - 6);
			checkpointBackImg.setFitHeight(checkpointBackImg.getFitHeight() - 10);
			labelOfMyname.setLayoutX(labelOfMyname.getLayoutX() - 8);
			labelOfMyname.setLayoutY(labelOfMyname.getLayoutY() - 3);
			labekOfEnemyName.setLayoutX(labekOfEnemyName.getLayoutX() + 7.5);
			labekOfEnemyName.setLayoutY(labekOfEnemyName.getLayoutY() - 14);
			labelOfMyscore.setLayoutX(labelOfMyscore.getLayoutX() + 0.75);
			myScoreBar.setLayoutX(myScoreBar.getLayoutX() + 1.5);
			labelOfEnemyscore.setLayoutX(labelOfEnemyscore.getLayoutX() - 1.5);
			enemyScoreBar.setLayoutX(enemyScoreBar.getLayoutX() - 1.5);
			backTopImg.setLayoutX(backTopImg.getLayoutX() - 12);
			backDownImg.setLayoutX(backDownImg.getLayoutX() + 12);
			myCharacterImg.setLayoutX(myCharacterImg.getLayoutX() - 12);
			enemyCharacterImg.setLayoutX(enemyCharacterImg.getLayoutX() + 12);
			myCharacterHeadImg.setLayoutX(myCharacterHeadImg.getLayoutX() - 8);
			myCharacterHeadImg.setLayoutY(myCharacterHeadImg.getLayoutY() - 3);
			enemyCharacterHeadImg.setLayoutX(enemyCharacterHeadImg.getLayoutX() + 7.5);
			enemyCharacterHeadImg.setLayoutY(enemyCharacterHeadImg.getLayoutY() - 14);
			pointLabel.setOpacity(pointLabel.getOpacity() - 0.1);
			if(pointLabel.getOpacity() < 0.1) {
				background.getChildren().remove(pointLabel);
			}
		}));
		Timeline toQuestion = new Timeline(new KeyFrame(Duration.millis(10), (event)->{
			try {
	    		questionNumber = 1;
				everyQuestion();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}));
		Timeline setEvent = new Timeline(new KeyFrame(Duration.millis(10), (event)->{
			myCharacterHeadImg.setOnMouseClicked(headImgClicked);
			myCharacterHeadImg.setOnMouseEntered(optionEntered);
			myCharacterHeadImg.setOnMouseExited(optionExited);
		}));
		//play
		viaScene.setCycleCount(40);
		viaScene.play();
		movein.setCycleCount(40);
		movein.setDelay(Duration.millis(1000));
		movein.play();
		forPointLabel.setCycleCount(25);
		forPointLabel.setDelay(Duration.millis(4200));
		forPointLabel.play();
		double delay = 2200;
		for(int i=0;i<10;i++) {
			Cylinder mycl = new Cylinder();
			mycl.setHeight(10);
			mycl.setRadius(20);
			mycl.setLayoutX(400);
			mycl.setLayoutY(180);
			mycl.setRotationAxis(new Point3D(1, 1, 1));
			mycl.setMaterial(new PhongMaterial(Color.YELLOW));
			mycl.setVisible(false);
			background.getChildren().add(mycl);
			
			Cylinder enemycl = new Cylinder();
			enemycl.setHeight(10);
			enemycl.setRadius(20);
			enemycl.setLayoutX(80);
			enemycl.setLayoutY(620);
			enemycl.setRotationAxis(new Point3D(1, 1, 1));
			enemycl.setMaterial(new PhongMaterial(Color.YELLOW));
			enemycl.setVisible(false);
			background.getChildren().add(enemycl);
			
			Timeline myGold = new Timeline(new KeyFrame(Duration.millis(20), (event)->{
				mycl.setVisible(true);
				mycl.setRotate(mycl.getRotate() + 10);
				if(mycl.getRotate() >= 180) {
					mycl.setRotate(-180);
				}
				mycl.setLayoutX(mycl.getLayoutX());
				mycl.setLayoutX(mycl.getLayoutX() - 1.5);
				mycl.setLayoutY(mycl.getLayoutY() + 2);
				if(mycl.getLayoutX() <= 250) {
					background.getChildren().remove(mycl);
				}
			}));
			Timeline enemyGold = new Timeline(new KeyFrame(Duration.millis(20), (event)->{
				enemycl.setVisible(true);
				enemycl.setRotate(mycl.getRotate() - 10);
				if(enemycl.getRotate() <= -180) {
					enemycl.setRotate(180);
				}
				enemycl.setLayoutX(enemycl.getLayoutX());
				enemycl.setLayoutX(enemycl.getLayoutX() + 1.5);
				enemycl.setLayoutY(enemycl.getLayoutY() - 2);
				if(enemycl.getLayoutX() >= 230) {
					background.getChildren().remove(enemycl);
				}
			}));
			
			myGold.setCycleCount(100);
			myGold.setDelay(Duration.millis(delay));
			myGold.play();
			enemyGold.setCycleCount(100);
			enemyGold.setDelay(Duration.millis(delay));
			enemyGold.play();
			delay = delay + 200;
		}
		
		backAppear.setCycleCount(10);
		backAppear.setDelay(Duration.millis(2200));
		backAppear.play();
		toAnswerScene.setDelay(Duration.millis(6000));
		toAnswerScene.setCycleCount(40);
		toAnswerScene.play();
		toQuestion.setCycleCount(1);
		toQuestion.setDelay(Duration.millis(8000));
		toQuestion.play();
		setEvent.setCycleCount(1);
		setEvent.setDelay(Duration.millis(8000));
		setEvent.play();
	}
	
	private static void everyQuestion() throws IOException {
		//ask for question
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(ClientMain.clientSocket.getOutputStream(), "Cp950"));
		output.write(new String("Q" + checkpointNumber));
		output.flush();
		if(questionNumber != finalQuestionNumber) {
			labelOfQuestionNumber.setText("第" + questionNumber + "題");
		}
		else {
			labelOfQuestionNumber.setText("最後一題");
		}
		labelOfQuestionNumber.setVisible(true);
		labelOfTimer.setOpacity(0);
		timer = setTime;
		labelOfTimer.setText("" + timer);
		labelOfTimer.setTextFill(Color.WHITE);
		labelOfTimer.setLayoutX(200);
		labelOfTimer.setLayoutY(20);
		labelOfTimer.setVisible(true);
		answered = false;
		enemyAnswered = false;
		colorInt = 15;
		for(int i=1;i<5;i++) {
			BtnArr[i].setOpacity(0);
			BtnArr[i].setVisible(true);
		}
		//Timeline
		Timeline questionNumAppear = new Timeline(new KeyFrame(Duration.millis(50), (e)->{
			labelOfQuestionNumber.setOpacity(labelOfQuestionNumber.getOpacity() + 0.1);
			labelOfTimer.setOpacity(labelOfTimer.getOpacity() + 0.1);
		}));
		Timeline questionNumFade = new Timeline(new KeyFrame(Duration.millis(50), (e)->{
			labelOfQuestionNumber.setOpacity(labelOfQuestionNumber.getOpacity() - 0.1);
		}));
		Timeline questionAppear = new Timeline(new KeyFrame(Duration.millis(50), (e)->{
			labelOfQuestion.setOpacity(labelOfQuestion.getOpacity() + 0.1);
		}));
		Timeline buttonAppear = new Timeline(new KeyFrame(Duration.millis(50), (e)->{
			for(int i=1;i<5;i++) {
				BtnArr[i].setOpacity(BtnArr[i].getOpacity() + 0.1);
			}
		}));
		Timeline Fade = new Timeline(new KeyFrame(Duration.millis(50), (e)->{
			labelOfQuestion.setOpacity(labelOfQuestion.getOpacity() - 0.1);
			for(int i=1;i<5;i++) {
				if(i != correctAnswer) {
					BtnArr[i].setOpacity(BtnArr[i].getOpacity() - 0.1);
				}
				else {
					BtnArr[i].setStyle("-fx-background-color:mediumspringgreen; -fx-background-radius:10; -fx-font-weight:bold; -fx-font-fill:#262424; -fx-font-size:32;");
				}
			}
		}));
		Timeline correctBtnFade = new Timeline(new KeyFrame(Duration.millis(50), (e)->{
			BtnArr[correctAnswer].setOpacity(BtnArr[correctAnswer].getOpacity() - 0.1);
		}));
		Timeline forNext = new Timeline(new KeyFrame(Duration.millis(1000), (e)->{
			if(questionNumber == finalQuestionNumber) {
				try {
					endScene();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else {
				try {
					questionNumber++;
					everyQuestion();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}));
		Timeline fortimer = new Timeline(new KeyFrame(Duration.millis(1000), (e)->{
			timer = timer - 1;
			labelOfTimer.setText("" + timer);
		}));
		//play
    	questionNumAppear.setCycleCount(10);
		questionNumAppear.play();
		questionNumFade.setCycleCount(10);
		questionNumFade.setDelay(Duration.millis(1000));
		questionNumFade.play();
		questionAppear.setCycleCount(10);
		questionAppear.setDelay(Duration.millis(1800));
		questionAppear.play();
		buttonAppear.setCycleCount(10);
		buttonAppear.setDelay(Duration.millis(3300));
		buttonAppear.play();
		fortimer.setCycleCount(10);
		fortimer.setDelay(Duration.millis(3300));
		fortimer.play();
		new Thread(()->{
			boolean animationEndFlag = false;
			while(!animationEndFlag) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if((answered && enemyAnswered) || timer == 0) {
					fortimer.stop();
					Fade.setCycleCount(10);
					Fade.setDelay(Duration.millis(500));
					Fade.play();
					correctBtnFade.setCycleCount(10);
					correctBtnFade.setDelay(Duration.millis(2000));
					correctBtnFade.play();
					forNext.setCycleCount(1);
					forNext.setDelay(Duration.millis(2500));
					forNext.play();
					break;
				}
			}
		}).start();
	}
	
	private static void setQuestion() {
		String[] temp = question.split(" ");
		for(int i=8;i<temp[1].length();i=i+8) {
			temp[1] = temp[1].substring(0, i) + "\r\n" + temp[1].substring(i);
			i = i + 2;
		}
		labelOfQuestion.setText(temp[1]);
		option1Btn.setText(temp[2]);
		option2Btn.setText(temp[3]);
		option3Btn.setText(temp[4]);
		option4Btn.setText(temp[5]);

		correctAnswer = Integer.parseInt("" + temp[6].charAt(0));
		for(int i=1;i<5;i++) {
			BtnArr[i].setStyle("-fx-background-color:#fafeff; -fx-background-radius:10; -fx-font-weight:bold; -fx-font-fill:#262424; -fx-font-size:32;");
			BtnArr[i].setOnMouseEntered(optionEntered);
			BtnArr[i].setOnMouseExited(optionExited);
			BtnArr[i].setOnMouseClicked(optionClicked);
		}
	}
	
	private static void enemyOption() {
		enemyAnswered = true;
		if(Integer.parseInt("" + instruction.charAt(1)) == correctAnswer) {
			if(questionNumber != finalQuestionNumber) {
				enemyDifference = timer*20;
			}
			else {
				enemyDifference = timer*40;
			}
			
			Timeline getpoint = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
				enemyScore = enemyScore + enemyDifference/10;
				labelOfEnemyscore.setText("" + enemyScore);
				enemyScoreBar.setProgress((double)enemyScore/fullScore);
			}));
			
			getpoint.setCycleCount(10);
			getpoint.setDelay(Duration.millis(300));
			getpoint.play();
			
			new Thread(()->{
				while(!answered) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				BtnArr[correctAnswer].setStyle("-fx-background-color:mediumspringgreen; -fx-background-radius:10; -fx-font-weight:bold; -fx-font-fill:#262424; -fx-font-size:32;");
			}).start();
		}
		else {
			enemyScoreBar.setStyle("-fx-accent:palegreen; -fx-control-inner-background:red");
			char[] color = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
			Timeline barFade = new Timeline(new KeyFrame(Duration.millis(30), (event)->{
				enemyScoreBar.setStyle("-fx-accent:palegreen; -fx-control-inner-background:#" + color[colorInt] + color[colorInt] + "0000;");
				colorInt--;
			}));
			barFade.setCycleCount(16);
			barFade.play();
			
			new Thread(()->{
				while(!answered) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				BtnArr[Integer.parseInt("" + instruction.charAt(1))].setStyle("-fx-background-color:red; -fx-background-radius:10; -fx-font-weight:bold; -fx-font-fill:#262424; -fx-font-size:32;");
			}).start();
		}
	}

	private static void endScene() throws IOException {
		endBackImg.setVisible(true);
		labelOfWin.setVisible(true);
		labelOfchallengeResult.setVisible(true);
		loabelOfGold.setVisible(true);
		labelOfExp.setVisible(true);
		labelOfMyplusGold.setVisible(true);
		labelOfMyplusExp.setVisible(true);
		findNewEnemyImg.setVisible(true);
		endBackToHomeImg.setVisible(true);
		labelOfLevel.toFront();
		barOfExp.toFront();
		labelOfName.toFront();
		textOfMoney.toFront();
		double delay = 900;
		if(myScore >= enemyScore) {
			labelOfWin.setLayoutX(86);
			labelOfWin.setLayoutY(291);
			labelOfchallengeResult.setText("挑戰成功");
			gotExp = gotExp * myNumberOfAC;
			labelOfMyplusGold.setText("+" + gotGold);
			
			for(int i=0;i<9;i++) {
				Cylinder gd = new Cylinder();
				gd.setHeight(10);
				gd.setRadius(20);
				gd.setLayoutX(320);
				gd.setLayoutY(200);
				gd.setMaterial(new PhongMaterial(Color.YELLOW));
				gd.setRotationAxis(new Point3D(1, 1, 1));
				gd.setVisible(false);
				background.getChildren().add(gd);
				
				Timeline gold = new Timeline(new KeyFrame(Duration.millis(20), (event)->{
					gd.setVisible(true);
					gd.setLayoutX(gd.getLayoutX() - 1.6);
					gd.setRotate(gd.getRotate() - 10);
					if(gd.getRotate() <= -180) {
						gd.setRotate(180);
					}
					if(gd.getLayoutX() <= 160) {
						background.getChildren().remove(gd);
					}
				}));
				gold.setCycleCount(100);
				gold.setDelay(Duration.millis(delay));
				gold.play();
				delay = delay + 200;
			}
		}
		else {
			labelOfWin.setLayoutX(298);
			labelOfWin.setLayoutY(291);
			labelOfchallengeResult.setText("挑戰失敗");
			gotGold = 0 - gotGold;
			gotExp = myNumberOfAC;
			labelOfMyplusGold.setText("" + gotGold);
			
			for(int i=0;i<9;i++) {
				Cylinder gd = new Cylinder();
				gd.setHeight(10);
				gd.setRadius(20);
				gd.setLayoutX(160);
				gd.setLayoutY(200);
				gd.setMaterial(new PhongMaterial(Color.YELLOW));
				gd.setRotationAxis(new Point3D(1, 1, 1));
				gd.setVisible(false);
				background.getChildren().add(gd);
				
				Timeline gold = new Timeline(new KeyFrame(Duration.millis(20), (event)->{
					gd.setVisible(true);
					gd.setLayoutX(gd.getLayoutX() + 1.6);
					gd.setRotate(gd.getRotate() + 10);
					if(gd.getRotate() >= 180) {
						gd.setRotate(-180);
					}
					if(gd.getLayoutX() >= 320) {
						background.getChildren().remove(gd);
					}
				}));
				gold.setCycleCount(100);
				gold.setDelay(Duration.millis(delay));
				gold.play();
				delay = delay + 200;
			}
		}
		labelOfMyplusExp.setText("+" + gotExp);
		account.setMoney(account.getMoney() + gotGold);
		account.setExp(account.getExp() + gotExp);
		if(account.getExp() + gotExp >= account.getLevel()*50) {
			account.setExp(account.getExp() + gotExp - account.getLevel()*50);
			account.setLevel(account.getLevel() + 1);
			account.setMoney(account.getMoney() + 1000*account.getLevel());
			labelOfLevel.setText("LV:" + account.getLevel());
		}
		textOfMoney.setText("   $" + account.getMoney());
		barOfExp.setProgress(((double)account.getExp()/(double)(account.getLevel()*50)));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(ClientMain.clientSocket.getOutputStream(), "Cp950"));
		output.write("C " + account.forPassenge());
		output.flush();
		
		Timeline endAppear = new Timeline(new KeyFrame(Duration.millis(50), (e)->{
			labelOfMyname.setLayoutX(labelOfMyname.getLayoutX() + 4);
			labelOfMyname.setLayoutY(labelOfMyname.getLayoutY() + 5);
			labekOfEnemyName.setLayoutX(labekOfEnemyName.getLayoutX() - 4);
			labekOfEnemyName.setLayoutY(labekOfEnemyName.getLayoutY() + 5);
			myCharacterHeadImg.setLayoutX(myCharacterHeadImg.getLayoutX() + 4);
			myCharacterHeadImg.setLayoutY(myCharacterHeadImg.getLayoutY() + 5);
			enemyCharacterHeadImg.setLayoutX(enemyCharacterHeadImg.getLayoutX() - 4);
			enemyCharacterHeadImg.setLayoutY(enemyCharacterHeadImg.getLayoutY() + 5);
			myMessageText.setLayoutX(myMessageText.getLayoutX() + 3);
			myMessageText.setLayoutY(myMessageText.getLayoutY() + 5);
			enemyMessageText.setLayoutX(enemyMessageText.getLayoutX() - 3);
			enemyMessageText.setLayoutY(enemyMessageText.getLayoutY() + 5);
			endBackImg.setOpacity(endBackImg.getOpacity() + 0.05);
			labelOfWin.setOpacity(labelOfWin.getOpacity() + 0.05);
			labelOfchallengeResult.setOpacity(labelOfchallengeResult.getOpacity() + 0.05);
			loabelOfGold.setOpacity(loabelOfGold.getOpacity() + 0.05);
			labelOfExp.setOpacity(labelOfExp.getOpacity() + 0.05);
			labelOfMyplusGold.setOpacity(labelOfMyplusGold.getOpacity() + 0.05);
			labelOfMyplusExp.setOpacity(labelOfMyplusExp.getOpacity() + 0.05);
			findNewEnemyImg.setOpacity(findNewEnemyImg.getOpacity() + 0.05);
			endBackToHomeImg.setOpacity(endBackToHomeImg.getOpacity() + 0.05);
			labelOfLevel.setOpacity(labelOfLevel.getOpacity() + 0.05);
			barOfExp.setOpacity(barOfExp.getOpacity() + 0.05);
			labelOfName.setOpacity(labelOfName.getOpacity() + 0.05);
			textOfMoney.setOpacity(textOfMoney.getOpacity() + 0.05);
			
			if(endBackToHomeImg.getOpacity() > 0.95) {
				//initial
				profileImg.setLayoutX(15);
				challengeImg.setLayoutX(15);
				bankImg.setLayoutX(15);
				challengeBackToHomeImg.setLayoutX(5 + 480);
				checkpoint1Img.setLayoutX(5 + 480);
				checkpoint2Img.setLayoutX(5 + 480);
				checkpoint3Img.setLayoutX(5 + 480);
				checkpoint4Img.setLayoutX(5 + 480);
				searchingBackImg.setVisible(false);
				labelOfSearching.setVisible(false);
				deletSearchingImg.setVisible(false);
				labelOfTimer.setLayoutX(200);
				labelOfTimer.setLayoutY(375);
				labelOfTimer.setVisible(false);
				labelOfQuestionNumber.setVisible(false);
				labelOfQuestion.setVisible(false);
				for(int i=1;i<5;i++) {
					BtnArr[i].setVisible(false);
				}
				labelOfMyscore.setText("0");
				labelOfMyscore.setLayoutX(13 - 30);
				labelOfMyscore.setLayoutY(350);
				labelOfMyscore.setVisible(false);
				labelOfEnemyscore.setText("0");		
				labelOfEnemyscore.setLayoutX(450 + 30);
				labelOfEnemyscore.setLayoutY(350);
				labelOfEnemyscore.setVisible(false);
				myScoreBar.setLayoutX(-180);
				myScoreBar.setLayoutY(550);
				enemyScoreBar.setLayoutX(320 + 30);
				enemyScoreBar.setLayoutY(550);
				checkpointBackImg.setVisible(false);
				background.getChildren().remove(checkpointBackImg);	
			}
		}));
		//play
		endAppear.setCycleCount(20);
		endAppear.play();
	}

	private static void enemyMessage() {
		enemyMessage = enemyMessage.substring(2);
		enemyMessageText.setText(enemyMessage);
		enemyMessageText.setVisible(true);
		enemyMessageText.setOpacity(0);
		Timeline messageAppear = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
			enemyMessageText.setOpacity(enemyMessageText.getOpacity() + 0.1);
		}));
		Timeline messageFade = new Timeline(new KeyFrame(Duration.millis(50), (event)->{
			enemyMessageText.setOpacity(enemyMessageText.getOpacity() - 0.1);
			if(enemyMessageText.getOpacity() < 0.1) {
				enemyMessageText.setVisible(false);
			}
		}));
		messageAppear.setCycleCount(10);
		messageAppear.setDelay(Duration.millis(200));
		messageAppear.play();
		messageFade.setCycleCount(10);
		messageFade.setDelay(Duration.millis(3700));
		messageFade.play();
	}
}
