package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ScheduleController {
	boolean courseTFFlag = false, lectTFFlag = false, classTFFlag = false, startTimeCBFlag = false, endTimeCBFlag = false, dayCBFlag = false;
	private Days days[] = new Days[8];
	private Times times[] = new Times[10];
	@FXML private VBox tempVbox;
    @FXML private GridPane ScheduleGrid;
    @FXML private VBox courseVbox; //Course VBox
    @FXML private TextField courseTF;
    @FXML private ColorPicker colorCP;
    @FXML private RadioButton lectRB;	//Lecture RadioButton
    @FXML private RadioButton execRB; //Exercise RadioButton
    @FXML private RadioButton labRB; //Lab RadioButton
    @FXML private RadioButton wsRB; //Sadna RadioButton
    @FXML private VBox courseNameVbox;
    @FXML private Button deleteBtn;
    @FXML private ComboBox<Integer> lectStartTimeCB;
    @FXML private Label lectLabel;	//Lecture label
    @FXML private VBox veryImportentVbox; //CONTAIN ALL OF THE BELOW
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
    @FXML private Button addBtn;
    @FXML private Label colorLabel;
    
    @FXML    
    void add(ActionEvent event) {
    	tempVbox = new VBox(5);
    	tempVbox.setFillWidth(true);
    	tempVbox.setMaxWidth(112.6);
    	tempVbox.setMaxHeight(81.7*(endTimeCB.getValue().getNum()-startTimeCB.getValue().getNum()));
    	tempVbox.setPrefWidth(112.5);
    	tempVbox.setAlignment(Pos.CENTER);
    	tempVbox.getChildren().add(new Label(courseTF.getText().toString()));
    	tempVbox.getChildren().add(new Label(lectTF.getText().toString()));
    	tempVbox.getChildren().add(new Label(classTF.getText().toString()));
    	String style = "-fx-background-color: " + toRgbString(colorCP.getValue()) + ";";
    	tempVbox.setStyle(style);
    	ScheduleGrid.add(tempVbox, dayCB.getValue().getNum(), startTimeCB.getValue().getNum(), 1,endTimeCB.getValue().getNum()-startTimeCB.getValue().getNum() );
    	courseTF.clear();
    	lectTF.clear();
    	classTF.clear();
         delete();
    }
    
    private void delete() {
    	courseTF.clear();
    	lectTF.clear();
    	classTF.clear();
    	dayCB.setValue(dayCB.getItems().get(0));
    	endTimeCB.setValue(endTimeCB.getItems().get(0));
    	startTimeCB.setValue(startTimeCB.getItems().get(0));
		
	}

	private String toRgbString(Color c) {
        return "rgb(" + to255Int(c.getRed()) + "," + to255Int(c.getGreen()) + "," + to255Int(c.getBlue()) + ")";
    }
    
    private int to255Int(double f) {
        return (int) (f * 255);
    }
    
    @FXML
    public void initialize() {
    	for (int i = 0; i < 8; i++) {
			days[i] = new Days(i);
			dayCB.getItems().add(days[i]);
    	}
    	for (int i = 0; i < 10; i++) {
    		if (i != 5) {
			times[i] = new Times(i);
			startTimeCB.getItems().add(times[i]);
			endTimeCB.getItems().add(times[i]);
    		}
    	}
    	 colorCP.getStyleClass().add("split-button");
    	colorCP.setStyle("-fx-color-label-visible: false ;");
    	colorLabel.setVisible(false);
    	courseVbox.setVisible(false);
    	colorCP.setVisible(false);
    	addBtn.setDisable(true);
    	}
    
    @FXML
    void newCourse(ActionEvent event) {
    	courseVbox.setVisible(true);
    	colorCP.setVisible(true);
    	colorLabel.setVisible(true);
    }
    
    @FXML
    void deleted(ActionEvent event) {
    	delete();
    }

    @FXML
    void execAction(ActionEvent event) {
        lectLabel.setText(execRB.getText()+":");
    }
    
    @FXML
    void wsAction(ActionEvent event) {
    	lectLabel.setText(wsRB.getText()+":");
    }
    
    @FXML
    void lectAction(ActionEvent event) {
    	lectLabel.setText(lectRB.getText()+":");
    }
    
    @FXML
    void labAction(ActionEvent event) {
    	lectLabel.setText(labRB.getText()+":");
    }

    @FXML
    void keyTypedClassTF(KeyEvent event) {
		if (courseTF.getText().trim().equals("")) 
			courseTFFlag = false;
		else
			courseTFFlag = true;
		if ((courseTFFlag == true) && (lectTFFlag == true) && (classTFFlag == true) && (startTimeCBFlag == true) && (endTimeCBFlag == true) && (dayCBFlag == true))
			addBtn.setDisable(false);
		else
			addBtn.setDisable(true);
    }

    @FXML
    void keyTypedCourseTF(KeyEvent event) {
		if (lectTF.getText().trim().equals("")) 
			lectTFFlag = false;
		else
			lectTFFlag = true;
		if ((courseTFFlag == true) && (lectTFFlag == true) && (classTFFlag == true) && (startTimeCBFlag == true) && (endTimeCBFlag == true) && (dayCBFlag == true))
			addBtn.setDisable(false);
		else
			addBtn.setDisable(true);
    }

    public void checkIfDisableBtn() {
		if ((courseTFFlag == true) && (lectTFFlag == true) && (classTFFlag == true) && (startTimeCBFlag == true) && (endTimeCBFlag == true) && (dayCBFlag == true))
			addBtn.setDisable(false);
		else
			addBtn.setDisable(true);
    }
    @FXML
    void keyTypedLectTF(KeyEvent event) {
		if (classTF.getText().trim().equals("")) 
			classTFFlag = false;
		else
			classTFFlag = true;
		checkIfDisableBtn();
    }
    @FXML
    void startHiding(ActionEvent event) {
		if (startTimeCB.getSelectionModel() == null) 
			startTimeCBFlag = false;
		else
			startTimeCBFlag = true;
		checkIfDisableBtn();
    }
    @FXML
    void endHiding(ActionEvent event) {
		if (endTimeCB.getSelectionModel() == null)
			endTimeCBFlag = false;
		else
			endTimeCBFlag = true;
		checkIfDisableBtn();
    }
    @FXML
    void dayHiding(ActionEvent event) {
		if (dayCB.getSelectionModel() == null)
			dayCBFlag = false;
		else
			dayCBFlag = true;
		checkIfDisableBtn();
    }

}