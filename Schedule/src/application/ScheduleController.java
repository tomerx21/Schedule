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
    @FXML private ComboBox<Times> endTimeCB;	//Lecture end time ComboBox
    
    @FXML    
    void add(ActionEvent event) {
    	tempVbox = new VBox(5);
    	tempVbox.setFillWidth(true);
    	tempVbox.setMaxWidth(112);
    	tempVbox.setMaxHeight(81);
    	tempVbox.setPrefWidth(112);
    	tempVbox.setPrefHeight(81);
    	tempVbox.setAlignment(Pos.CENTER);
    	tempVbox.getChildren().add(new Label(courseTF.getText().toString()));
    	tempVbox.getChildren().add(new Label(lectTF.getText().toString()));
    	tempVbox.getChildren().add(new Label(classTF.getText().toString()));
    	ScheduleGrid.add(tempVbox, dayCB.getValue().getNum(), startTimeCB.getValue().getNum(), 1, 1);
    }

    @FXML
    public void initialize() {
    	for (int i = 0; i < 8; i++) {
			days[i] = new Days(i);
			dayCB.getItems().add(days[i]);
    	}
    	for (int i = 1; i < 10; i++) {
    		if (i != 5) {
			times[i] = new Times(i);
			startTimeCB.getItems().add(times[i]);
			endTimeCB.getItems().add(times[i]);
    		}
    	}
    	courseVbox.setVisible(false);
    	//ImportentVbox.setDisable(true);
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