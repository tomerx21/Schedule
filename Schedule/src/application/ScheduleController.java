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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ScheduleController {
	private ArrayList<Course> courses= new ArrayList<Course>();
	private int length;
	@FXML private VBox tempVbox;
    @FXML private GridPane ScheduleGrid;
    @FXML private VBox courseVbox; //Course VBox
    @FXML private TextField courseTF;
// Lecture
    @FXML private VBox lectVbox;	//Lecture VBox
    @FXML private TextField lectTF; //Lecture TextField
    @FXML private ComboBox<Integer> lectDayCB;
    @FXML private ComboBox<Integer> lectLengthCB;
    @FXML private ComboBox<Integer> lectStartTimeCB;
// Exercise
    @FXML private VBox execVbox;	//Exercise VBox
    @FXML private TextField execTF; //Exercise TextField
    @FXML private ComboBox<Integer> execDayCB;
    @FXML private ComboBox<Integer> execLengthCB;
    @FXML private ComboBox<Integer> execStartTimeCB;
// Lab
    @FXML private VBox labVbox;	//Lab VBox
    @FXML private TextField labTF; //Lab TextField
    @FXML private ComboBox<Integer> labDayCB;
    @FXML private ComboBox<Integer> labLengthCB;
    @FXML private ComboBox<Integer> labStartTimeCB;
// Workshop
    @FXML private VBox wsVbox;	//Workdshop TextField
    @FXML private TextField wsTF; //Workdshop TextField
    @FXML private ComboBox<Integer> wsDayCB;
    @FXML private ComboBox<Integer> WSLengthCB;
    @FXML private ComboBox<Integer> WSStartTimeCB;
    
    @FXML
    void add(ActionEvent event) {

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
    	/*
    	courseVbox.setVisible(false);
    	lectVbox.setVisible(false);
    	execVbox.setVisible(false);
    	labVbox.setVisible(false);
    	wsVbox.setVisible(false);
    	*/
    	initializeComboBoxes();
    	courseVbox.setVisible(false);
    	lectVbox.setDisable(true);
    	execVbox.setDisable(true);
    	labVbox.setDisable(true);
    	wsVbox.setDisable(true);
    	}
    
    //Init all the combo boxes
    public void initializeComboBoxes() {
    	lectDayCB.getItems().addAll(1,2,3,4,5,6,7);
    	lectLengthCB.getItems().addAll(1,2,3,4);
    	//lectStartTimeCB.getItems().addAll("8:30", "9:30", "10:30", "11:30", "12:40", "13:40", "14:40", "15:40", "16:40" );
    	lectStartTimeCB.getItems().addAll(1,2,3,4,5,6,7,8,9);
    	execDayCB.getItems().addAll(1,2,3,4,5,6,7);
    	execLengthCB.getItems().addAll(1,2,3,4);
    	execStartTimeCB.getItems().addAll(1,2,3,4,5,6,7,8,9);
    	labDayCB.getItems().addAll(1,2,3,4,5,6,7);
    	labLengthCB.getItems().addAll(1,2,3,4);
    	labStartTimeCB.getItems().addAll(1,2,3,4,5,6,7,8,9);
    	wsDayCB.getItems().addAll(1,2,3,4,5,6,7);
    	WSLengthCB.getItems().addAll(1,2,3,4);
    	WSStartTimeCB.getItems().addAll(1,2,3,4,5,6,7,8,9);
    }
    @FXML
    void newCourse(ActionEvent event) {
    	courseVbox.setVisible(true);
    	//courses.add(new Course());
    }

    @FXML
    void lectLengthCBUpdate(ActionEvent event) {
    	length = lectLengthCB.getValue();
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
    @FXML
    void lectCBPress(ActionEvent event) {
    	CheckBoxPressed(lectVbox);
    }
    @FXML
    void execCBPress(ActionEvent event) {
    	CheckBoxPressed(execVbox);
    }
    @FXML
    void labCBPress(ActionEvent event) {
    	CheckBoxPressed(labVbox);
    }
    @FXML
    void wsCBPress(ActionEvent event) {
    	CheckBoxPressed(wsVbox);
    }

    @FXML
    void execLenghtCBUpdate(ActionEvent event) {

    }

    @FXML
    void labLenghtCBUpdate(ActionEvent event) {

    }

    @FXML
    void wsLenghtCBUpdate(ActionEvent event) {

    }
}
