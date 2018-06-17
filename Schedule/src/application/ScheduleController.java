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
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
public class ScheduleController {
	private ArrayList<Course> courses = new ArrayList<Course>();
	private int length;
	@FXML private VBox tempVbox;
    @FXML private GridPane ScheduleGrid;
    @FXML private VBox courseVbox; //Course VBox
    @FXML private TextField courseTF;
// Lectu1re
    @FXML private RadioButton lectRB;	//Lecture RadioButton
    @FXML private RadioButton execRB; //Exercise RadioButton
    @FXML private RadioButton labRB; //Lab RadioButton
    @FXML private RadioButton wsRB; //Sadna RadioButton
    @FXML private ComboBox<Integer> lectStartTimeCB;

    @FXML private VBox ImportentVbox; //CONTAIN ALL OF THE BELOW
    @FXML private VBox lectVbox;	//Lecturer VBox
    @FXML private TextField lectTF; //Lecturer TextField
    @FXML private VBox classVbox;	//Class VBox
    @FXML private TextField classTF;//Class TextField
    @FXML private VBox dayVbox;		//Day VBox
    @FXML private ComboBox<Integer> dayCB; //Day ComboBox
    @FXML private VBox startTimeVbox;//Lecture start time VBox
    @FXML private ComboBox<Integer> startTimeCB; //Lecture start time ComboBox
    @FXML private VBox endTimeVbox;		 //Lecture end time VBox
    @FXML private ComboBox<Integer> endTimeCB;	//Lecture end time ComboBox
    
    @FXML    
    void add(ActionEvent event) {
    	/*
    	tempVbox = new VBox(5);
    	tempVbox.setFillWidth(false);
    	tempVbox.setMaxWidth(112);
    	tempVbox.setMaxHeight(81);
    	tempVbox.setPrefWidth(112);
    	tempVbox.setPrefHeight(81);
    	tempVbox.getChildren().add(new Label(courseTF.getText().toString()));
    	tempVbox.getChildren().add(new Label(lectTF.getText().toString()));
    	tempVbox.setAlignment(Pos.TOP_CENTER);
    	ScheduleGrid.add(tempVbox, 7-lectDayCB.getValue(), lectStartTimeCB.getValue(), lectLengthCB.getValue(), 1);
    	tempVbox.getChildren().clear();
    	tempVbox.getChildren().add(new Label(courseTF.getText().toString()));
    	tempVbox.getChildren().add(new Label(execTF.getText().toString()));
    	ScheduleGrid.add(tempVbox, 7-execDayCB.getValue(), execStartTimeCB.getValue(), execLengthCB.getValue(), 1);
    	tempVbox.getChildren().clear();
    	tempVbox.getChildren().add(new Label(courseTF.getText().toString()));
    	tempVbox.getChildren().add(new Label(labTF.getText().toString()));
    	ScheduleGrid.add(tempVbox, 7-labDayCB.getValue(), labLengthCB.getValue(), labStartTimeCB.getValue(), 1);
    	tempVbox.getChildren().clear();
    	tempVbox.getChildren().add(new Label(courseTF.getText().toString()));
    	tempVbox.getChildren().add(new Label(wsTF.getText().toString()));
    	ScheduleGrid.add(tempVbox, 7-wsDayCB.getValue(), WSLengthCB.getValue(), WSStartTimeCB.getValue(), 1);

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
    	initializeComboBoxes();
    	courseVbox.setVisible(false);
    	ImportentVbox.setDisable(true);
    	}
    
    //Init all the combo boxes
    public void initializeComboBoxes() {
    	dayCB.getItems().addAll(1,2,3,4,5,6,7);
    	startTimeCB.getItems().addAll(1,2,3,4,5,6,7,8,9);
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
    
    void CheckBoxPressed(VBox vbox) {
    	if (vbox.isDisable() == true) {
    		//vbox.setVisible(true);
    		vbox.setDisable(false);
    	}
    	else {
    		//vbox.setVisible(false);	
    		vbox.setDisable(true);
    		}
    }

}