/**
 * Sample Skeleton for 'ScheduleController.fxml' Controller Class
 */

package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ScheduleController {
	private ArrayList<Course> courses = new ArrayList<Course>();
	private Days days[] = new Days[8];
	private Times times[] = new Times[10];
	private int length;
	@FXML private VBox tempVbox;
    @FXML private GridPane ScheduleGrid;
    @FXML private VBox courseVbox; //Course VBox
    @FXML private TextField courseTF;
    
    @FXML private RadioButton lectRB;	//Lecture RadioButton
    @FXML private RadioButton execRB; //Exercise RadioButton
    @FXML private RadioButton labRB; //Lab RadioButton
    @FXML private RadioButton wsRB; //Sadna RadioButton
    @FXML private ComboBox<Integer> lectStartTimeCB;
    @FXML private Label lectLabel;	//Lecture label
    @FXML private VBox ImportentVbox; //CONTAIN ALL OF THE BELOW
    @FXML private VBox lectVbox;	//Lecturer VBox
    @FXML private TextField lectTF; //Lecturer TextField
    @FXML private VBox classVbox;	//Class VBox
    @FXML private TextField classTF;//Class TextField
    @FXML private VBox dayVbox;		//Day VBox
    @FXML private ComboBox<Days> dayCB; //Day ComboBox
    @FXML private VBox startTimeVbox;//Lecture start time VBox
    @FXML private ComboBox<Times> startTimeCB; //Lecture start time ComboBox
    @FXML private VBox endTimeVbox;		 //Lecture end time VBox
    @FXML private ComboBox<Integer> endTimeCB;	//Lecture end time ComboBox
    
    @FXML    
    void add(ActionEvent event) {
    	tempVbox = new VBox(5);
    	tempVbox.setFillWidth(false);
    	tempVbox.setMaxWidth(112);
    	tempVbox.setMaxHeight(81);
    	tempVbox.setPrefWidth(112);
    	tempVbox.setPrefHeight(81);
    	tempVbox.setAlignment(Pos.CENTER);
    	tempVbox.getChildren().add(new Label(courseTF.getText().toString()));
    	tempVbox.getChildren().add(new Label(lectTF.getText().toString()));
    	tempVbox.getChildren().add(new Label(classTF.getText().toString()));
    	ScheduleGrid.add(tempVbox, 7-dayCB.getValue().getNum(), startTimeCB.getValue().getNum(), 1, 1);
    	/*
    	tempVbox = new VBox(5);
    	//tempVbox.setFillWidth(true);
    	VBox.setVgrow(tempVbox, Priority.NEVER);
    	tempVbox.getChildren().addAll(new Label("VERY"), new Label("BIG"), new Label("BOOBS"));
    	tempVbox.setAlignment(Pos.TOP_CENTER);
    	tempVbox.setMaxWidth(112);
    	tempVbox.setMaxHeight(81);
    	VBox.setVgrow(tempVbox, Priority.NEVER);
    	ScheduleGrid.add(tempVbox, 2, 2, 1, 1);*/
    }

    @FXML
    public void initialize() {
    	for (int i = 0; i < 8; i++)
			days[i] = new Days(i);
    	for (int i = 0; i < 10; i++)
			times[i] = new Times(i);
    	initializeComboBoxes();
    	courseVbox.setVisible(false);
    	//ImportentVbox.setDisable(true);
    	}
    
    //Init all the combo boxes
    public void initializeComboBoxes() {
    	dayCB.getItems().addAll(days[1], days[2], days[3], days[4], days[5], days[6], days[7]);
    	startTimeCB.getItems().addAll(times[1], times[2], times[3], times[4], times[6], times[7], times[8], times[9]);
    	endTimeCB.getItems().addAll(1,2,3,4,5,6,7,8,9);
    	//lectStartTimeCB.getItems().addAll("8:30", "9:30", "10:30", "11:30", "12:40", "13:40", "14:40", "15:40", "16:40" );
    }
    @FXML
    void newCourse(ActionEvent event) {
    	courseVbox.setVisible(true);
    	//courses.add(new Course());
    }

    @FXML
    void lectLengthCBUpdate(ActionEvent event) {

    } 
    @FXML
    void ececfunc(ActionEvent event) {
        lectLabel.setText(execRB.getText()+":");
    }
    @FXML
    void wsfunc(ActionEvent event) {
    	lectLabel.setText(wsRB.getText()+":");
    }
    @FXML
    void lectfunc(ActionEvent event) {
    	lectLabel.setText(lectRB.getText()+":");
    }
    @FXML
    void labfunc(ActionEvent event) {
    	lectLabel.setText(labRB.getText()+":");
    }

}