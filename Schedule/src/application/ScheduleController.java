package application;



import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ScheduleController {
	boolean courseTFFlag = false, lectTFFlag = false, classTFFlag = false, startTimeCBFlag = false, endTimeCBFlag = false, dayCBFlag = false;
	private Days days[] = new Days[8];
	private Times times[] = new Times[10];
	private ArrayList<VBox> VboxArr=new ArrayList<VBox>();
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
    @FXML private ToggleGroup typeGroup;
    
    @FXML    
    void add(ActionEvent event) {
    	tempVbox = new VBox(5);
    	//tempVbox.setFillWidth(true);
    	//tempVbox.setMaxWidth(112.6);
    	//tempVbox.setMaxHeight(81.7*(endTimeCB.getValue().getNum()-startTimeCB.getValue().getNum()));
    	//tempVbox.setPrefWidth(112.5);
    	tempVbox.setAlignment(Pos.CENTER);
    	tempVbox.getChildren().add(new Label(lectLabel.getText()+" "+courseTF.getText().toString()));
    	tempVbox.getChildren().add(new Label(lectTF.getText().toString()));
    	tempVbox.getChildren().add(new Label(classTF.getText().toString()));
    	
   
    	String style = "-fx-background-color: " + toRgbString(colorCP.getValue()) + ";";
    	tempVbox.setStyle(style);
    	ScheduleGrid.add(tempVbox, dayCB.getValue().getNum(), startTimeCB.getValue().getNum(), 1,endTimeCB.getValue().getNum()-startTimeCB.getValue().getNum() );
    	courseTF.clear();
    	
    	lectTF.clear();
    	classTF.clear();
    	VboxArr.add(tempVbox);
    	for(int i=0; i<VboxArr.size();i++){
    		int j=VboxArr.get(i).getChildren().get(0).toString().indexOf(':');
    		String tempCorStr =VboxArr.get(i).getChildren().get(0).toString().substring(j+2, VboxArr.get(i).getChildren().get(0).toString().length()-1);
    		j=VboxArr.get(i).getChildren().get(1).toString().indexOf('\'');
    		String tempLecStr =VboxArr.get(i).getChildren().get(1).toString().substring(j+1, VboxArr.get(i).getChildren().get(1).toString().length()-1);
    		j=VboxArr.get(i).getChildren().get(2).toString().indexOf('\'');
    		String tempclassStr =VboxArr.get(i).getChildren().get(2).toString().substring(j+1, VboxArr.get(i).getChildren().get(2).toString().length()-1);
    		int colNum= GridPane.getColumnIndex(VboxArr.get(i));
    		VboxArr.get(i).setOnMouseClicked( ( e ) ->
        { 
        	classTF.setText(tempclassStr);
        	lectTF.setText(tempLecStr);
        	courseTF.setText(tempCorStr);
        	dayCB.setValue(new Days(7-colNum));
        } );
    	}
    	
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
    	setTimeCB(1, startTimeCB);
    	setTimeCB(1, endTimeCB);
    	dayCB.setValue(dayCB.getItems().get(0));
    	endTimeCB.setValue(endTimeCB.getItems().get(0));
    	startTimeCB.setValue(startTimeCB.getItems().get(0));
    	colorCP.getStyleClass().add("split-button");
    	colorCP.setStyle("-fx-color-label-visible: false ;");
    	colorLabel.setVisible(false);
    	courseVbox.setVisible(false);
    	colorCP.setVisible(false);
    	addBtn.setDisable(true);
    }
    
    public void setTimeCB(int startIndex, ComboBox<Times> CB) {
    CB.getItems().clear();
    CB.getItems().add(times[0] = new Times(0));
	for (int i = startIndex; i < 10; i++) {
		if (i != 5) {
		times[i] = new Times(i);
		CB.getItems().add(times[i]);
		}
		CB.setValue(CB.getItems().get(0));
	}
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
		if (startTimeCB.getValue()==null||startTimeCB.getValue().getNum() == 0) {
			startTimeCBFlag = false;
			setTimeCB(1, endTimeCB);
		}
			
		else {
			startTimeCBFlag = true;
			setTimeCB(startTimeCB.getValue().getNum() + 1, endTimeCB);
		}
		checkIfDisableBtn();
    }
    @FXML
    void endHiding(ActionEvent event) {
		if (endTimeCB.getValue()==null||endTimeCB.getValue().getNum() == 0) 
			endTimeCBFlag = false;
		else
			endTimeCBFlag = true;
		checkIfDisableBtn();
    }
    @FXML
    void dayHiding(ActionEvent event) {
		if (dayCB.getValue()==null||dayCB.getValue().getNum() == 0) 
			dayCBFlag = false;
		else
			dayCBFlag = true;
		checkIfDisableBtn();
    }

}